package com.Vayu.URL_Shortner.Entity;

         import jakarta.persistence.*;
         import java.time.LocalDateTime;

         @Entity
         @Table(name = "urls")
         public class UrlEntity {
             @Id
             @GeneratedValue(strategy = GenerationType.IDENTITY)
             private Long id;

             @Column(nullable = false, length = 2048)
             private String originalUrl;

             @Column(nullable = false, unique = true, length = 10)
             private String shortCode;

             private LocalDateTime createdAt = LocalDateTime.now();
             private LocalDateTime expiryAt;

             @Column(nullable = false)
             private boolean active = true;

             @Column(nullable = false)
             private int clickCount = 0;

             // Getters & Setters
             public Long getId() {
                 return id;
             }

             public void setId(Long id) {
                 this.id = id;
             }

             public String getOriginalUrl() {
                 return originalUrl;
             }

             public void setOriginalUrl(String originalUrl) {
                 this.originalUrl = originalUrl;
             }

             public String getShortCode() {
                 return shortCode;
             }

             public void setShortCode(String shortCode) {
                 this.shortCode = shortCode;
             }

             public LocalDateTime getCreatedAt() {
                 return createdAt;
             }

             public void setCreatedAt(LocalDateTime createdAt) {
                 this.createdAt = createdAt;
             }

             public LocalDateTime getExpiryAt() {
                 return expiryAt;
             }

             public void setExpiryAt(LocalDateTime expiryAt) {
                 this.expiryAt = expiryAt;
             }

             public boolean isActive() {
                 return active;
             }

             public void setActive(boolean active) {
                 this.active = active;
             }

             public int getClickCount() {
                 return clickCount;
             }

             public void setClickCount(int clickCount) {
                 this.clickCount = clickCount;
             }

             @Override
             public String toString() {
                 return "UrlEntity{" +
                         "id=" + id +
                         ", originalUrl='" + originalUrl + '\'' +
                         ", shortCode='" + shortCode + '\'' +
                         ", createdAt=" + createdAt +
                         ", expiryAt=" + expiryAt +
                         ", active=" + active +
                         ", clickCount=" + clickCount +
                         '}';
             }
         }