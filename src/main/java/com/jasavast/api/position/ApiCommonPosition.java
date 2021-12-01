package com.jasavast.api.position;

import com.jasavast.core.annotation.GetExecution;
import com.jasavast.service.ApiAbstract;
import com.jasavast.service.PositionService;
import com.jasavast.service.dto.PositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component("apiCommonPosition")
public class ApiCommonPosition extends ApiAbstract {
    @Autowired
    private PositionService positionService;

    @GetExecution
    public Mono<PositionDTO> getPositionDto(){
        return Mono.justOrEmpty(reqData)
                .map(jsonObject -> {
                    Assert.notNull(jsonObject.getString("positionId"),"Position ID cannot be null");
                    return jsonObject.getString("positionId");
                }).flatMap(s -> {
                    return Mono.fromCallable(()->{
                        return positionService.getDetailPosition(s);
                    });
                });
    }

    @GetExecution
    public Flux<PositionDTO> getAllPosition(){
        List<PositionDTO> listPosition = positionService.getPosition();
        return Flux.fromIterable(listPosition);
    }
}
