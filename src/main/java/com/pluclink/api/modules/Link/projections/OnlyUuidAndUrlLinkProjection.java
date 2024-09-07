package com.pluclink.api.modules.Link.projections;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OnlyUuidAndUrlLinkProjection {

    private UUID uuid;
    
    private String url;

    public OnlyUuidAndUrlLinkProjection(UUID uuid, String url) {
        this.uuid = uuid;
        this.url = url;
    }
}
