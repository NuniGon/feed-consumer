package com.sparta.controller;

import com.sparta.model.dto.TotalRecordsDTO;
import com.sparta.service.DataProviderService;
import com.sparta.service.LoadProviderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class MainController {

    private final LoadProviderService loadProviderService;
    private final DataProviderService dataProviderService;

    @PostMapping("/load/{provider}")
    public ResponseEntity<TotalRecordsDTO> load(@PathVariable("provider") String provider, @RequestBody byte[] content) throws IOException {
        try {
            return ResponseEntity.ok(loadProviderService.save(provider, content));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/data/{provider}/total")
    public ResponseEntity<TotalRecordsDTO> total(@PathVariable("provider") String provider) {
        try {
            return ResponseEntity.ok(dataProviderService.getTotalRecords(provider));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
