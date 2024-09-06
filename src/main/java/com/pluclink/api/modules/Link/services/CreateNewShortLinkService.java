package com.pluclink.api.modules.Link.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pluclink.api.modules.Link.dtos.LinkRecordDto;
import com.pluclink.api.modules.Link.models.Link;

@Service
public class CreateNewShortLinkService {

    @Autowired
    private GenerateShortUrl generateShortUrl;
    
    public Link execute(LinkRecordDto dto){
        Link link = new Link();
        BeanUtils.copyProperties(dto, link);
        generateShortUrl.execute(link.getUrl());
        
        return new Link();
    }
}
