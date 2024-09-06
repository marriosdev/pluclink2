package com.pluclink.api.modules.Link.dtos;

import jakarta.validation.constraints.NotBlank;

public record LinkRecordDto(@NotBlank String url) {

}
