package com.pluclink.api.modules.Link.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluclink.api.exceptions.NotFoundException;
import com.pluclink.api.modules.Link.models.Link;
import com.pluclink.api.modules.Link.repositories.LinkRepository;

@Service
public class GetLinkDetailsService {
    @Autowired
    private LinkRepository linkRepository;

    public Link execute(UUID uuid) {
        Optional<Link> link = linkRepository.findById(uuid);
        if(link.isEmpty()) {
            throw new NotFoundException("Item não encontrado");
        }
        return link.get();
    }
}
