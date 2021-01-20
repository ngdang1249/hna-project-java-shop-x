import controller.ProductController;
import dao.DBUtil;
import dao.ProductDAOImpl;
import model.Product;
import service.ProductServiceImpl;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Connection conn = DBUtil.getConnection();
        ProductDAOImpl productDaoImpl = new ProductDAOImpl();
        ProductServiceImpl productServiceImpl = new ProductServiceImpl();
        ProductController productController = new ProductController(productServiceImpl);
        Product product = new Product("iPhone 11 Pro Max", 1100D);
        productController.addProduct(product);
    }

}
