package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.service;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.db.CustomerRepository;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.Customer;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAll(){
        return customerRepository.findAll().isEmpty() ? new ArrayList<>(): customerRepository.findAll();
    }

    public Customer findOne(String id){
        return customerRepository.findById(id).orElseThrow(()-> {throw new ServiceException("Customer doesn't exist");});
    }

    public Customer add(Customer product){
        if (product.getId() != null && customerRepository.findById(product.getId()).isPresent()){
            throw new ServiceException("User already exists");
        }
        return customerRepository.save(product);
    }

    public Customer update(Customer product){
        if (product.getId() == null || !customerRepository.findById(product.getId()).isPresent()){
            throw new ServiceException("User does not exist");
        }
        return customerRepository.save(product);
    }

    public void delete(Customer product){
        if (product.getId() == null || !customerRepository.findById(product.getId()).isPresent()){
            throw new ServiceException("User does not exist");
        }
        customerRepository.delete(product);
    }
}
