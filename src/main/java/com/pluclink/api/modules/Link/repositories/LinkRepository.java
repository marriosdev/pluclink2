package com.pluclink.api.modules.Link.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;
import com.pluclink.api.modules.Link.models.Link;

public interface LinkRepository extends JpaRepository<Link, UUID> {
    public Optional<Link> findByShortUrl(String shortUrl);
}
