package br.com.finchsolucoes.lorem.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by leodouglas on 23/12/15.
 */
@RestController
public class ServiceDiscoveryController {

    @RequestMapping(value = "/info" ,method = RequestMethod.GET)
    public ResponseEntity info() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/health" ,method = RequestMethod.GET)
    public ResponseEntity health() {
        return new ResponseEntity(HttpStatus.OK);
    }
}
