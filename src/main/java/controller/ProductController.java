package controller;

import entities.Product;
import service.ProductServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ProductController {

    private ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    public void saveProduct(Scanner scanner) throws SQLException {
        System.out.println("Enter your name: ");
        Product product = new Product();
        product.setName(scanner.nextLine());
        System.out.println("Enter the price: ");
        product.setPrice(scanner.nextDouble());
        productServiceImpl.create(product);
    }

    public void showProductList() {
        List<Product> products = productServiceImpl.findAll();
        for (Product prod : products) {
            System.out.println(prod.toString());
        }
    }

    public boolean deleteProduct(Integer id) {
        Optional<Product> product = productServiceImpl.find(id);
        if (product.isPresent()) {
            return productServiceImpl.remove(id);
        }
        System.out.println("No records found for the product id : " + id);
        return false;
    }
}
