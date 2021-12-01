package com.jasavast.service;

import com.jasavast.service.dto.PositionDTO;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "position-service",url = "http://dev3.dansmultipro.co.id/api/recruitment")
public interface PositionService {
    @GetMapping("/positions.json")
    public List<PositionDTO> getPosition();
    @GetMapping("/positions/{ID}")
    public PositionDTO getDetailPosition(@PathVariable(name = "ID") String id);
}
