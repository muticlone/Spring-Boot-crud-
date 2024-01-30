package com.example.Spring.Boot.Controllers;

import com.example.Spring.Boot.Dtos.ProdutsRecordDto;
import com.example.Spring.Boot.models.ProductModel;
import com.example.Spring.Boot.repositories.ProductRepositories;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ProductController {

    @Autowired
    ProductRepositories productRepositories;

    @PostMapping("/products")
    public ResponseEntity <ProductModel> saveProduct(@RequestBody  @Valid ProdutsRecordDto produtsRecordDto){
        var productModel = new  ProductModel();
        BeanUtils.copyProperties(produtsRecordDto,productModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(productRepositories.save(productModel));
    }

    @GetMapping("/products")
    public  ResponseEntity<List<ProductModel>> getAllProducts(){
        return  ResponseEntity.status(HttpStatus.OK).body(productRepositories.findAll());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModel> product0 = productRepositories.findById(id);

        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(product0.get());
    }


    @PutMapping("/products/{id}")
    public  ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id , @RequestBody  @Valid ProdutsRecordDto produtsRecordDto){
        Optional<ProductModel> product0 = productRepositories.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }

        var productModel =  product0.get();
        BeanUtils.copyProperties(produtsRecordDto,productModel);

        return  ResponseEntity.status(HttpStatus.OK).body(productRepositories.save(productModel));
    }


    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id){
        Optional<ProductModel> product0 = productRepositories.findById(id);
        if (product0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        productRepositories.delete(product0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successFully");
    }


}
