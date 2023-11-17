package de.ithoc.training.cybersecurity.ssrf;


import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InternalServer {

    private static final int CUSTOMER_COUNT = 100;
    private final List<Customer> customers = new ArrayList<>(CUSTOMER_COUNT);

    @PostConstruct
    private void init() {
        for (int i = 0; i < CUSTOMER_COUNT; i++) {
            Customer customer = new Customer();
            customer.setId(String.valueOf(i));
            customer.setEmail("customer." + i + "@example.com");
            customer.setTurnover(i * 1000);
            customers.add(customer);
        }
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> get(@RequestParam(required = false) Integer limit) {
        if(limit == null) {
            limit = CUSTOMER_COUNT;
        }

        List<Customer> customers = this.customers.subList(0, limit);

        return ResponseEntity.ok(customers);
    }

}
