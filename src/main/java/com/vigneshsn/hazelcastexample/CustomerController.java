package com.vigneshsn.hazelcastexample;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final HazelcastInstance hazelcastInstance;

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerName(@PathVariable String id) {
        IMap<String, Customer> mapCustomers = hazelcastInstance.getMap("customers");
        Customer customer =  mapCustomers.get(id);
        if(customer == null) {
           return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customer);
    }

}
