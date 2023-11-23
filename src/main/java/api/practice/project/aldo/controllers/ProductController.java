package api.practice.project.aldo.controllers;

import api.practice.project.aldo.models.ProductModel;
import api.practice.project.aldo.repositories.ProductRepository;
import api.practice.project.aldo.dtos.ProductRecord;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("api/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecord productRecord){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecord, productModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));
    }

    @GetMapping("api/products")
    public ResponseEntity<List<ProductModel>> getAllProduct(){
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

}
