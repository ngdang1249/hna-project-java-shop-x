package service;

import dao.DAOFactory;
import dao.IProductDAO;
import dao.ProductDAOImpl;
import model.Product;

public class ProductServiceImpl {

    private IProductDAO iProductDAO;

    public ProductServiceImpl() {
        this.iProductDAO = DAOFactory.getInstance().getProductDAO();
    }

    public void setiProductDAO(IProductDAO iProductDAO) {
        this.iProductDAO = iProductDAO;
    }

    public int saveProduct(Product product) {
        if (product != null) return iProductDAO.save(product);
        return 0;
    }

}
