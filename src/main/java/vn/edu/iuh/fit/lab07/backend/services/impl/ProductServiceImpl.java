package vn.edu.iuh.fit.lab07.backend.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab07.backend.models.Product;
import vn.edu.iuh.fit.lab07.backend.repositories.ProductRepository;
import vn.edu.iuh.fit.lab07.backend.services.ProductService;

import java.awt.print.Pageable;
import java.util.ArrayList;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ArrayList<Product> getAll() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> showPaging() {
        return productRepository.findAll(PageRequest.of(0, 8));
    }
}
