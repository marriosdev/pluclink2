package com.pluclink.api.modules.Link.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;

import com.pluclink.api.exceptions.NotFoundException;

import org.springframework.stereotype.Service;

import com.pluclink.api.modules.Link.models.Link;
import com.pluclink.api.modules.Link.models.LinkTracker;
import com.pluclink.api.modules.Link.projections.OnlyUuidAndUrlLinkProjection;
import com.pluclink.api.modules.Link.repositories.LinkRepository;
import com.pluclink.api.modules.Link.repositories.LinkTrackerRepository;

@Service
public class RedirectShortLinkService {

    @Autowired
    protected LinkRepository linkRepository;

    @Autowired
    protected LinkTrackerRepository linkTrackerRepository;

    public OnlyUuidAndUrlLinkProjection execute(String shortUrl, String ip) throws NotFoundException {
        Optional<OnlyUuidAndUrlLinkProjection> reference = linkRepository.findUrlAndUuidByShortUrl(shortUrl);
        if (reference.isEmpty()) {
            throw new NotFoundException("Item não encontrado");
        }

        Link link = new Link();
        BeanUtils.copyProperties(reference.get(), link);

        LinkTracker tracker = new LinkTracker();

        tracker.setLink(link);
        tracker.setIp(ip); 
        tracker.setCreatedAt(LocalDateTime.now());
        linkTrackerRepository.save(tracker);

        return reference.get();
    }
}
