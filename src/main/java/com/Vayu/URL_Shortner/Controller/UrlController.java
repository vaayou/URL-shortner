package com.Vayu.URL_Shortner.Controller;

import com.Vayu.URL_Shortner.Service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UrlController {
    private final UrlService service;


    public UrlController(UrlService service) {
        this.service = service;
    }


    @PostMapping("/shorten")
    public ResponseEntity<Map<String, String>> shorten(@RequestParam String url) {
        String shortCode = service.shortenUrl(url);
        return ResponseEntity.ok(Map.of("shortUrl", "http://localhost:8080/" + shortCode));
    }


    @GetMapping("/{shortCode}")
    public void redirect(@PathVariable String shortCode, HttpServletResponse response) throws IOException {
        String originalUrl = service.getOriginalUrl(shortCode);
        response.sendRedirect(originalUrl);
    }
}