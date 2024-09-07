package com.pluclink.api.modules.Link.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;
import com.pluclink.api.modules.Link.models.Link;
import com.pluclink.api.modules.Link.projections.OnlyUuidAndUrlLinkProjection;

public interface LinkRepository extends JpaRepository<Link, UUID> {
    public Optional<Link> findByShortUrl(String shortUrl);
    
    @Query("SELECT new com.pluclink.api.modules.Link.projections.OnlyUuidAndUrlLinkProjection(l.uuid, l.url) FROM Link l WHERE l.shortUrl = :shortUrl")
    public Optional<OnlyUuidAndUrlLinkProjection> findUrlAndUuidByShortUrl(String shortUrl);
}
