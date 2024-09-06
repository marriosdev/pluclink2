package com.pluclink.api.modules.Link.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pluclink.api.modules.Link.dtos.LinkRecordDto;
import com.pluclink.api.modules.Link.models.Link;
import com.pluclink.api.modules.Link.repositories.LinkRepository;
import com.pluclink.api.modules.Link.services.CreateNewShortLinkService;
import com.pluclink.api.modules.Link.services.RedirectShortLinkService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LinkController {
    
    @Autowired
    protected LinkRepository linkRepository;

    @Autowired
    protected CreateNewShortLinkService createNewShortLinkService;

    @Autowired 
    protected RedirectShortLinkService redirectShortLinkService;

    @PostMapping("links")
    public ResponseEntity<Link> createLink(@RequestBody @Valid LinkRecordDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(createNewShortLinkService.execute(dto));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<String> redirectUrl(@PathVariable(value="shortUrl") String shortUrl) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(redirectShortLinkService.execute(shortUrl));
    }
}
