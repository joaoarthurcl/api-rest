package com.products.apirest.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.products.apirest.model.Product;
import com.products.apirest.repositories.ProductRepository;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Product REST API")
@CrossOrigin(origins = "*")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value = "Return a list of products")
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value = "Return a product by id")
	public Product findById(@PathVariable(value = "id") Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.get();
	}
	
	@PostMapping(path = "/product")
	@ResponseBody
	@ApiOperation(value = "Create a product")
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping(path = "/product/{id}")
	@ApiOperation(value = "Delete a product by id")
	public void deleteById(@PathVariable(value = "id") Long id) {
		productRepository.deleteById(id);
	
	}
	
	@DeleteMapping(path = "/product")
	@ApiOperation(value = "Delete a product")
	public void deleteProduct(@RequestBody Product product) {
		productRepository.delete(product);
	}
	
	@PutMapping("/product")
	@ApiOperation(value = "Update a product")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
}
