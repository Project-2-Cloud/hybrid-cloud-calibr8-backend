package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.service;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.db.OrderRepository;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.ProductOrder;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<ProductOrder> getAll(){
        return orderRepository.findAll();
    }

    public ProductOrder get(long id){
        return orderRepository.findById(id).orElseThrow(()-> {throw new ServiceException("Order does not exist");
        });
    }
    public ProductOrder add(ProductOrder order){
        if (orderRepository.existsById(order.getId())){
            throw new ServiceException("There is already an order with this id");
        }
        return orderRepository.save(order);
    }

    public ProductOrder update(ProductOrder order){
        if (!orderRepository.existsById(order.getId())){
            throw new ServiceException("There is no order with this id");
        }
        return orderRepository.save(order);
    }

    public void delete(ProductOrder order){
        if (!orderRepository.existsById(order.getId())){
            throw new ServiceException("There is no order with this id");
        }
        orderRepository.delete(order);
    }

}
