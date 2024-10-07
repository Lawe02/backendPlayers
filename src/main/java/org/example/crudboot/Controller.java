package org.example.crudboot;

import org.example.crudboot.Service.ObjectService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private ObjectService service;

    public Controller(ObjectService service) {
        this.service = service;
    }
}
