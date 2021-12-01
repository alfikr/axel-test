package com.jasavast;

import com.jasavast.service.PositionService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = BoilerPlateApplication.class)
@Slf4j
public class PositionServiceIT {
    @Autowired
    private PositionService positionService;
    @Test
    public void testAllPosition(){
        log.info("result {}",positionService.getPosition());
    }
    @Test
    public void testGetPositionById(){
        log.info("result {}",positionService.getDetailPosition("32bf67e5-4971-47ce-985c-44b6b3860cdb"));
    }
}
