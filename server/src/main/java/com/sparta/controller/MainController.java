package com.sparta.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

  @PostMapping("/load/{provider}")
  public ResponseEntity<String> load(@PathVariable("provider") String provider, @RequestBody byte[] content) throws IOException {
    return ResponseEntity.ok("hola");
  }

  @GetMapping("/data/{provider}/total")
  public ResponseEntity<String> total(@PathVariable("provider") String provider) {
    return ResponseEntity.ok("hola");
  }

}
