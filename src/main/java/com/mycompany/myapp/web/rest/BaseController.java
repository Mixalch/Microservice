package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping ("/value/{value}")
    public ResponseEntity setValue(@PathVariable("value") int value) {
        service.setValue(value);
        return ResponseEntity.ok("OK");
    }

}
