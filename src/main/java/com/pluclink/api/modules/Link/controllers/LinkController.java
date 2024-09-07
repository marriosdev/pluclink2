package com.pluclink.api.modules.Link.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.pluclink.api.modules.Link.dtos.LinkRecordDto;
import com.pluclink.api.modules.Link.models.Link;
import com.pluclink.api.modules.Link.services.CreateNewShortLinkService;
import com.pluclink.api.modules.Link.services.GetLinkDetailsService;
import com.pluclink.api.modules.Link.services.RedirectShortLinkService;

import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class LinkController {
    
    @Autowired
    protected CreateNewShortLinkService createNewShortLinkService;
    
    @Autowired
    protected GetLinkDetailsService getLinkDetailsService;

    @Autowired 
    protected RedirectShortLinkService redirectShortLinkService;

    @PostMapping("links")
    public ResponseEntity<Link> createLink(@RequestBody @Valid LinkRecordDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(createNewShortLinkService.execute(dto));
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity<Object> redirectUrl(@PathVariable(value="shortUrl") String shortUrl) throws NotFoundException {
        Map<String, String> response = new HashMap<>();
        response.put("url", redirectShortLinkService.execute(shortUrl));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("links/{uuid}")
    public ResponseEntity<Object> getLinkDetails(@PathVariable(value="uuid") UUID uuid) {
        return ResponseEntity.status(HttpStatus.OK).body(getLinkDetailsService.execute(uuid));
    }
}
