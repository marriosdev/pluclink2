package com.pluclink.api.modules.Link.models;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class LinkTracker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 36)
    private UUID uuid;
    
    @Column(length = 39)
    private String ip;
    
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="link_id")
    @JsonIgnore
    private Link link;
}
