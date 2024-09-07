package com.pluclink.api.modules.Link.projections;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

public class OnlyUuidAndUrlLinkProjection {

    @Getter @Setter
    private UUID uuid;
    
    @Getter @Setter
    private String url;

    public OnlyUuidAndUrlLinkProjection(UUID uuid, String url) {
        this.uuid = uuid;
        this.url = url;
    }
}
