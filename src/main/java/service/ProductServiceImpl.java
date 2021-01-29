package service;

import dao.ProductDAO;
import dao.ProductDAOImpl;
import entities.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl {

    private ProductDAO productDAO;

    public ProductServiceImpl() {
        this.productDAO = new ProductDAOImpl();
    }

    public void create(Product product) throws SQLException {
        if (product == null) {
            System.out.println("Unable to get product details.");
            return;
        }
        boolean status = productDAO.save(product);
        if (status) {
            System.out.println("Insert successfully!");
        } else {
            System.out.println("Insert failed!");
        }
    }

    public void edit() {

    }

    public List<Product> findAll() {
        return productDAO.findAll();
    }

    public boolean remove(Integer id) {
        return productDAO.deleteById(id);
    }


    public Optional<Product> find(Integer id) {
        return productDAO.findById(id);
    }
}
