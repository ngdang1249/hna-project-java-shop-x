package controller;

import model.Product;
import service.ProductServiceImpl;

public class ProductController {

    private ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    public void addProduct(Product product) {
        productServiceImpl.saveProduct(product);
    }
}
