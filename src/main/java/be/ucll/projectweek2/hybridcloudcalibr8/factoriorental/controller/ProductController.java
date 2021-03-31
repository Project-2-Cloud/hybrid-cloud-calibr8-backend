package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.controller;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.Product;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin( origins = "http://localhost:8080", allowCredentials = "true")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable Long id){
        return productService.findOne(id);
    }

    @PostMapping("")
    public Product add(@Valid @RequestBody Product product){
        return productService.add(product);
    }

    @PutMapping("")
    public Product update(@Valid @RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("")
    public void delete(@Valid @RequestBody Product product) { productService.delete(product); }

}
