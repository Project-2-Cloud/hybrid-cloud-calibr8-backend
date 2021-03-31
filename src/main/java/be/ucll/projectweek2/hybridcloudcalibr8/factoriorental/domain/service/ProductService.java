package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.service;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.db.ProductRepository;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.Product;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll().isEmpty() ? new ArrayList<>(): productRepository.findAll();
    }

    public Product findOne(long id){
        return productRepository.findById(id).orElseThrow(()-> {throw new ServiceException("Product doesn't exist");});
    }

    public Product add(Product product){
        if (product.getId() != null && productRepository.findById(product.getId()).isPresent()){
            throw new ServiceException("Product already exists");
        }
        return productRepository.save(product);
    }

    public Product update(Product product){
        if (product.getId() == null || !productRepository.findById(product.getId()).isPresent()){
            throw new ServiceException("Product does not exist");
        }
        return productRepository.save(product);
    }

    public void delete(Product product){
        if (product.getId() == null || !productRepository.findById(product.getId()).isPresent()){
            throw new ServiceException("Product does not exist");
        }
        productRepository.delete(product);
    }
}
