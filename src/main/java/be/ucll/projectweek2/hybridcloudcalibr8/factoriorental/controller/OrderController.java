package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.controller;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.ProductOrder;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/order")
@CrossOrigin( origins = "http://localhost:8080", allowCredentials = "true")
public class OrderController {

    @Autowired
    ProductOrderService orderService;

    @GetMapping("")
    public List<ProductOrder> getAll(){
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public ProductOrder get(@PathVariable long id){
        return orderService.get(id);
    }

    @PostMapping("")
    public ProductOrder add(@Valid @RequestBody ProductOrder order){
        return orderService.add(order);
    }

    @PutMapping("")
    public ProductOrder update(@Valid @RequestBody ProductOrder order){
        return orderService.update(order);
    }

    @DeleteMapping
    public void delete(@Valid @RequestBody ProductOrder order){
        orderService.delete(order);
    }
}
