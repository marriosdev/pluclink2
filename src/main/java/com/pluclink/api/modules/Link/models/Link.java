package com.pluclink.api.modules.Link.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.Collate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID uuid;
    
    private String url;
    
    @Column(length = 6)
    private String shortUrl;
    
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "link")
    private List<LinkTracker> trackers;
}
