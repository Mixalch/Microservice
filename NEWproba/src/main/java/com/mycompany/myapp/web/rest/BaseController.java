package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BaseController {

    @Autowired
    private BaseService service;

    @GetMapping("/increment")
    public ResponseEntity<Integer> increment() {
        return ResponseEntity.ok(service.increment());
    }

    @GetMapping("/decrement")
    public ResponseEntity<Integer> decrement() {
        return ResponseEntity.ok(service.decrement());
    }
}
