package vn.edu.iuh.fit.lab07.backend.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab07.backend.enums.ProductStatus;
import vn.edu.iuh.fit.lab07.backend.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public Page<Product> findAllByStatusOrStatus(ProductStatus status, ProductStatus status2, Pageable pageable);

    public Product findProductByNameAndManufacturer(String name, String manufacturer);

    public Product findProductByProductId(long productId);
}
