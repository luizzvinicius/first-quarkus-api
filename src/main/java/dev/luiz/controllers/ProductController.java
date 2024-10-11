package dev.luiz.controllers;

import dev.luiz.dto.ProductDto;
import dev.luiz.models.Product;
import dev.luiz.services.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
public class ProductController {

    @Inject
    ProductService productService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProduct() {
        return productService.getProducts();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Product getProduct(int id) {
        return productService.getProduct(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
    public void createProduct(ProductDto productDto) {
        productService.createProduct(productDto);
    }
}