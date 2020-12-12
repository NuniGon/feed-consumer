package com.sparta.controller;

import com.sparta.model.LoadBatch;
import com.sparta.service.DataProviderService;
import com.sparta.service.LoadProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class MainController {

    private final LoadProviderService loadProviderService;
    private final DataProviderService dataProviderService;

    @PostMapping("/load/{provider}")
    public ResponseEntity<LoadBatch> load(@PathVariable("provider") String provider, @RequestBody byte[] content) throws Exception {
        return ResponseEntity.ok(loadProviderService.save(provider, content));
    }

    @GetMapping("/data/{provider}/total")
    public ResponseEntity<Long> total(@PathVariable("provider") String provider) {
        return ResponseEntity.ok(dataProviderService.getTotalRecords(provider).getTotal());
    }

}
