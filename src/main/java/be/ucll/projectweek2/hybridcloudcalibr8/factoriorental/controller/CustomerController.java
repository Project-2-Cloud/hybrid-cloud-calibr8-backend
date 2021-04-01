package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.controller;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.Customer;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin( origins = "http://localhost:8080", allowCredentials = "true")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable String id){
        return customerService.findOne(id);
    }

    @PostMapping("")
    public Customer add(@Valid @RequestBody Customer customer){
        return customerService.add(customer);
    }

    @PutMapping("")
    public Customer update(@Valid @RequestBody Customer customer){
        return customerService.update(customer);
    }

    @DeleteMapping("")
    public void delete(@Valid @RequestBody Customer customer) { customerService.delete(customer); }
}
