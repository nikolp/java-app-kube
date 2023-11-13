package com.example.appkube;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MainController {
    @Value("${version:1}")
    int version;

    @GetMapping("/")
    VersionResponse index() {
        log.info("index() called");
        return new VersionResponse("Hello World!", version);
    }
}
