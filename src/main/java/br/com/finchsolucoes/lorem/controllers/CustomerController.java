package br.com.finchsolucoes.lorem.controllers;

import br.com.finchsolucoes.lorem.domains.Customer;
import br.com.finchsolucoes.lorem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by leodouglas on 23/12/15.
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteAll() {
        repository.deleteAll();
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll() {
        Iterable<Customer> customer = repository.findAll();
        if (customer != null) {
            return new ResponseEntity(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable String id) {
        Customer customer = repository.findOne(id);
        if (customer != null) {
            return new ResponseEntity(customer, HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity post(@RequestBody Customer body) {
        Customer customer = new Customer(body.getName(), body.getIdentityDocument());
        customer.setSocialDocument(body.getSocialDocument());
        return new ResponseEntity(repository.save(customer), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity get(@PathVariable String id, @RequestBody Customer body) {
        Customer customer = repository.findOne(id);
        if (customer != null) {
            customer.setName(body.getName());
            customer.setIdentityDocument(body.getIdentityDocument());
            customer.setSocialDocument(body.getSocialDocument());
            return new ResponseEntity(repository.save(customer), HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND);
        }
    }

}
