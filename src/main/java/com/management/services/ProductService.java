package com.management.services;

import com.management.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product saveProduct(Product product);
    Product updateProduct(Product product);
    Product getProduct(Long id);
    List<Product> getAllProducts();
    void deleteProductById(Long id);
    void deleteAllProducts();

    List<Product> findAllProductsByPrice(Double priceProduct);
    List<Product> findAllProductsByNamePrice(@Param("nameProduct") String nameProduct , @Param("priceProduct") Double priceProduct);


    List<Product> findAllProductsByNameSort();

    Page<Product> getAllProductsByPage(int page, int size);
}
