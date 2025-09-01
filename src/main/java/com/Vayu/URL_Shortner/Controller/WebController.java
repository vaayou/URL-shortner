package com.Vayu.URL_Shortner.Controller;

import com.Vayu.URL_Shortner.Service.UrlService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    private final UrlService service;


    public WebController(UrlService service) {
        this.service = service;
    }


    @GetMapping("/")
    public String index() {
        return "index";
    }


    @PostMapping("/shorten")
    public String shorten(@RequestParam String url, Model model) {
        String shortCode = service.shortenUrl(url);
        String shortUrl = "http://localhost:8080/api/" + shortCode;
        model.addAttribute("shortUrl", shortUrl);
        return "result";
    }
}