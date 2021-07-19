package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.domain.DTO;
import com.mycompany.myapp.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/counter")
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

    @GetMapping("/")
    public ResponseEntity<String> getValue() {
        return ResponseEntity.ok(service.getValue());
    }

    @PostMapping ("/")
    public ResponseEntity setValue(@RequestBody DTO value) {
        service.setValue(value.getValue());
        return ResponseEntity.ok("OK");
    }

}
