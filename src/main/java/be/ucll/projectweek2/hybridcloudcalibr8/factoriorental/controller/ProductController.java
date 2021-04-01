package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.controller;

import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.Product;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.model.Role;
import be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import javax.security.sasl.AuthenticationException;
import javax.validation.Valid;
import java.util.Arrays;
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
    public Product add(@Valid @RequestBody Product product, @AuthenticationPrincipal Jwt accessToken) throws AuthenticationException {
        checkAuthentication(accessToken, new Role[]{Role.ADMIN, Role.DEV});
        return  productService.add(product);
    }

    @PutMapping("")
    public Product update(@Valid @RequestBody Product product, @AuthenticationPrincipal Jwt accessToken) throws AuthenticationException {
        checkAuthentication(accessToken, new Role[]{Role.ADMIN, Role.DEV});
        return productService.update(product);
    }

    @DeleteMapping("")
    public void delete(@Valid @RequestBody Product product, @AuthenticationPrincipal Jwt accessToken) throws AuthenticationException {
        checkAuthentication(accessToken, new Role[]{Role.ADMIN, Role.DEV});
        productService.delete(product);
    }

    private void checkAuthentication(Jwt accessToken, Role[] role) throws AuthenticationException {
        String scope = accessToken.getClaims().get("scope").toString();
        boolean roleIsPresent = false;
        for (Role r: role) {
            if (scope.contains(r.getValue())){
                roleIsPresent = true;
                break;
            }
        }
        if (!roleIsPresent)  throw new AuthenticationException();
    }
}
