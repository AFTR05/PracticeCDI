package com.example.owncdi.service.impl;

import com.example.owncdi.annotations.MySqlConn;
import com.example.owncdi.model.Category;
import com.example.owncdi.model.Product;
import com.example.owncdi.repository.Repository;
import com.example.owncdi.repository.imp.CategoryRepositoryImp;
import com.example.owncdi.repository.imp.ProductRepostoryImp;
import com.example.owncdi.service.Service;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Qualifier;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
@SessionScoped
@Named("Service")
public class ProductServiceImpl implements Service<Product>, Serializable {

    @Inject
    @MySqlConn
    private ProductRepostoryImp repository;

    @Override
    public List<Product> getlist() throws SQLException {
        System.out.println("------------LIST PRODUCTS------------");

        return repository.list();
    }

    @Override
    public Product getbyId(Long id) throws SQLException {
        System.out.println("------------GET PRODUCT BY ID------------");
        return repository.byId(id);
    }

    @Override
    public void save(Product o) throws SQLException {
        System.out.println("------------SAVE PRODUCT------------");
        repository.save(o);
    }

    @Override
    public void delete(Long id) throws SQLException {
        System.out.println("------------DELETE PRODUCT------------");
        repository.delete(id);
    }

    @Override
    public void update(Long id,Product o) throws SQLException {
        System.out.println("------------UPDATE PRODUCT------------");
        repository.update(id,o);
    }
}
