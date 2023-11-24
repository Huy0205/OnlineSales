package vn.edu.iuh.fit.lab07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab07.backend.models.ProductPrice;
import vn.edu.iuh.fit.lab07.backend.pks.ProductPricePK;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, ProductPricePK> {
}
