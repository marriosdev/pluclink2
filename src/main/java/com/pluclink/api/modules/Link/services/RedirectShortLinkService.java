package com.pluclink.api.modules.Link.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.pluclink.api.exceptions.NotFoundException;

import org.springframework.stereotype.Service;

import com.pluclink.api.modules.Link.models.Link;
import com.pluclink.api.modules.Link.repositories.LinkRepository;

@Service
public class RedirectShortLinkService {
    
    @Autowired 
    protected LinkRepository linkRepository;

    public String execute(String shortUrl) throws NotFoundException{
        Optional<Link> link = linkRepository.findByShortUrl(shortUrl);

        if(link.isEmpty()) {
            throw new NotFoundException("Item não encontrado");
        }
        
        return link.get().getUrl();
    }        
}
