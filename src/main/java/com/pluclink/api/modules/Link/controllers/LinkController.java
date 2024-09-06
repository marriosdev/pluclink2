package com.pluclink.api.modules.Link.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pluclink.api.modules.Link.dtos.LinkRecordDto;
import com.pluclink.api.modules.Link.repositories.LinkRepository;
import com.pluclink.api.modules.Link.services.CreateNewShortLinkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class LinkController {
    
    @Autowired
    public LinkRepository linkRepository;

    @Autowired
    public CreateNewShortLinkService createNewShortLinkService;

    @PostMapping("links")
    public ResponseEntity<String> createLink(@RequestBody LinkRecordDto dto) {
        createNewShortLinkService.execute(dto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
