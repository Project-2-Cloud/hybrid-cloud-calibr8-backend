package be.ucll.projectweek2.hybridcloudcalibr8.factoriorental.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order")
@CrossOrigin( origins = "http://localhost:8080", allowCredentials = "true")
public class OrderController {

}
