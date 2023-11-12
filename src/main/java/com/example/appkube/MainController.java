package com.example.appkube;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("/")
    VersionResponse index() {
        return new VersionResponse("Hello World!", 1);
    }
}
