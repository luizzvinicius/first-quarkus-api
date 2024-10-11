package dev.luiz.controllers;

import dev.luiz.models.Product;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/products")
public class ProductController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProduct() {
        return Product.listAll();
    }
}