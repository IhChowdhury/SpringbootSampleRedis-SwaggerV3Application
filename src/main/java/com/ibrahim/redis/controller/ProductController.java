package com.ibrahim.redis.controller;

import com.ibrahim.redis.entity.Product;
import com.ibrahim.redis.repository.ProductDao;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/product")
@Tag(name = "product", description = "Product API")
public class ProductController {

    @Autowired
    private ProductDao productDao;


    @Operation(summary = "Add a new Product", description = "This api will add a new product", tags = {"product"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product Added", content = @Content(schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping
    public Product save(@Parameter(description = "Product to add cannot null or empty.", required = true, schema = @Schema(implementation = Product.class))
                            @Valid @RequestBody Product product){
        return productDao.save(product);
    }

    @Operation(summary = "Get all Products", description = "This api will provide all the products.")
    @ApiResponse(responseCode = "200", description = "Operation successful", content = @Content)
    @GetMapping
    public List<Product> getAllProducts(){
        return productDao.findAll();
    }


    @Operation(summary = "Find specific Product", description = "This api will give a single product based on given id.")
    @ApiResponse(responseCode = "200", description = "Operation successful", content = @Content(schema = @Schema(implementation = Product.class)))
    @GetMapping("/{id}")
    @Cacheable(key = "#id", value = "Product")
    public Product findProduct(@Parameter(description = "Product id shuould not be 0.", required = true) @PathVariable int id){
        return  productDao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id", value = "Product")
    public String remove(@PathVariable int id){
        return productDao.deleteProduct(id);
    }
}
