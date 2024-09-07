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

@Entity
public class Link {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID uuid;
    
    @Getter @Setter
    private String url;
    
    @Column(length = 6)
    @Getter @Setter
    private String shortUrl;
    
    @Column(updatable = false)
    @Getter @Setter
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "link")
    @Getter @Setter
    private List<LinkTracker> trackers;
}
