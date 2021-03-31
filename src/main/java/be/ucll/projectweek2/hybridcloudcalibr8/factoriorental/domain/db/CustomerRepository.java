package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.db;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
