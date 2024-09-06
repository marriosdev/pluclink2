package com.pluclink.api.modules.Link.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluclink.api.modules.Link.dtos.LinkRecordDto;
import com.pluclink.api.modules.Link.models.Link;
import com.pluclink.api.modules.Link.repositories.LinkRepository;

@Service
public class CreateNewShortLinkService {

    @Autowired
    protected GenerateShortUrlService generateShortUrlService;
 
    @Autowired
    protected LinkRepository linkRepository;
    
    public Link execute(LinkRecordDto dto){
        Link link = new Link();
        BeanUtils.copyProperties(dto, link);
        link.setShortUrl(generateShortUrlService.execute());
        linkRepository.save(link);
        return link;
    }
}
