package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.controller;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.Product;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
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
    public String add(@Valid @RequestBody Product product, @AuthenticationPrincipal Jwt accessToken){
        String scope = accessToken.getClaims().get("scope").toString();
        boolean partnerRole = scope.contains("partner");
        if (!partnerRole) return "Not authorized to add product";
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
        productService.add(product);
        return "Product added";
    }

    @PutMapping("")
    public String update(@Valid @RequestBody Product product, @AuthenticationPrincipal Jwt accessToken){
        String scope = accessToken.getClaims().get("scope").toString();
        boolean partnerRole = scope.contains("partner");
        if (!partnerRole) return "Not authorized to update product";
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
        productService.update(product);
        return "Product updated";
    }

    @DeleteMapping("")
    public String delete(@Valid @RequestBody Product product, @AuthenticationPrincipal Jwt accessToken){
        String scope = accessToken.getClaims().get("scope").toString();
        boolean partnerRole = scope.contains("partner");
        if (!partnerRole) return "Not authorized to delete product";
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString());
        System.out.println("Contains sequence 'partner': " + accessToken.getClaims().get("scope").toString().contains("partner"));
        productService.delete(product);
        return "Product deleted";
    }
}
