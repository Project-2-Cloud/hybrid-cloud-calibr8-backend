package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.db;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<ProductOrder, Long> {
}
