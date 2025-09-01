package com.Vayu.URL_Shortner.Service;

import com.Vayu.URL_Shortner.Entity.UrlEntity;
import com.Vayu.URL_Shortner.Repository.UrlRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.util.Base64;

@Service
public class UrlService {
    private final UrlRepository repository;


    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }


    @Transactional
    public String shortenUrl(String originalUrl) {
        String shortCode = generateHash(originalUrl);
        UrlEntity entity = new UrlEntity();
        entity.setOriginalUrl(originalUrl);
        entity.setShortCode(shortCode);
        repository.save(entity);
        return shortCode;
    }


    public String getOriginalUrl(String shortCode) {
        return repository.findByShortCode(shortCode)
                .map(UrlEntity::getOriginalUrl)
                .orElseThrow(() -> new RuntimeException("URL not found"));
    }


    private String generateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] hash = digest.digest(input.getBytes());
            String base62 = Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
            return base62.substring(0, 8);
        } catch (Exception e) {
            throw new RuntimeException("Hashing failed", e);
        }
    }
}