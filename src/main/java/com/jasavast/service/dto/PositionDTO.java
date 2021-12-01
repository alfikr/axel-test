package com.jasavast.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class PositionDTO {
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("url")
    private String url;
    @JsonProperty("created_at")
    @JsonFormat(pattern = "EEE MMM dd HH:mm:ss zzz yyyy",shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdAt;
    @JsonProperty("company_url")
    private String companyUrl;
    @JsonProperty("location")
    private String location;
    @JsonProperty("description")
    private String description;
    @JsonProperty("how_to_apply")
    private String howToApply;
    @JsonProperty("company_logo")
    private String companyLogo;
}
