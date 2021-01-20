package dao;

import model.Product;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements IProductDAO {

    private Connection conn;

    public ProductDAOImpl() {
        this.conn = DBUtil.getConnection();
    }

    @Override
    public int save(Product entity) throws SQLException {
        int result = 0;
        String sql = "INSERT INTO `products` (`name`, `price`)" +
                " VALUES (?, ?)";
        boolean autoCommitDefault = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getPrice());
            result = pstmt.executeUpdate();

            System.out.println("Inserted records into the table");
        } catch (Throwable e) {
            try {
                conn.rollback();
                } catch (Throwable throwable) {
                System.out.println("Could not rollback transaction");
            }
        } finally {
            conn.setAutoCommit(autoCommitDefault);
        }
        return result;
    }

    @Override
    public Optional<Product> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = null;
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM products")) {
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return products;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Product entity) {

    }
}
