package vn.edu.iuh.fit.lab07.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.lab07.backend.models.OrderDetail;
import vn.edu.iuh.fit.lab07.backend.pks.OrderDetailPK;

@Repository
public interface OrderDetailRepsitory extends JpaRepository<OrderDetail, OrderDetailPK> {
}
