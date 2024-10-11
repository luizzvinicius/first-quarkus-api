package dev.luiz.services;

import dev.luiz.dto.ProductDto;
import dev.luiz.models.Product;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {
    public List<Product> getProducts() {
        return Product.listAll();
    }

    public Product getProduct(int id) {
        Optional<Product> productOptional = PanacheEntityBase.findByIdOptional(id);
        return productOptional.orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void createProduct(ProductDto productDto) {
        Product.persist(new Product(productDto.name(), productDto.price()));
    }
}