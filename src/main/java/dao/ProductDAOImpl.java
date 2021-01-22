package dao;

import entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductDAOImpl implements IProductDAO {

    private final String INSERT_SQL = "INSERT INTO `products` (`name`, `price`)" +
            " VALUES (?, ?)";

    private Connection conn;

    public ProductDAOImpl() {
        this.conn = DBUtil.getConnection();
    }

    @Override
    public int save(Product entity) throws SQLException {
        int rowCount = -1;
        try (PreparedStatement pstmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
            conn.setAutoCommit(false);

            pstmt.setString(1, entity.getName());
            pstmt.setDouble(2, entity.getPrice());
            rowCount = pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();

            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (rs.next()) {
                do {
                    for (int i = 1; i <= columnCount; i++) {
                        String key = rs.getString(i);
                        System.out.println("KEY " + i + " = " + key);
                    }
                } while (rs.next());
            } else {
                System.out.println("NO KEYS WERE GENERATED.");
            }

            conn.commit();
            rs.close();

            System.out.println("ADDED ROW"); // UPDATED ROW
        } catch (Throwable e) {
            try {
                conn.rollback();
            } catch (Throwable throwable) {
                System.out.println("Could not rollback transaction");
            }
        } finally {
            conn.setAutoCommit(true);
        }
        return rowCount;
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
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public long count() {
        int rowCount = -1;
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM products");
            rs.next();
            rowCount = rs.getInt(1);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    @Override
    public boolean deleteById(Integer id) {
        int rowCount = 0;
        System.out.println("ROW DELETED");
        String query = "DELETE FROM products WHERE id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            rowCount = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount > 0;
    }

    @Override
    public void delete(Product entity) {

    }

    private void displayRow(String title, ResultSet rs) {
        System.out.println(title);
        System.out.println();
    }
}

