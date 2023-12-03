package vn.edu.iuh.fit.lab07.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.lab07.backend.models.Product;

import java.awt.print.Pageable;
import java.util.ArrayList;

@Service
public interface ProductService {

    public ArrayList<Product> getAll();

    public Page<Product> getAll(int pageNo, int pageSize, String sortBy, String sortDirection);

    public Product add(Product product);

    public Product update(Product product);

    public void delete(Long id);
}
