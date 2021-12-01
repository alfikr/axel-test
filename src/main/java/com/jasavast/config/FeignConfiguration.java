package com.jasavast.config;

import feign.codec.Decoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@EnableFeignClients(basePackages = "com.jasavast.service")
public class FeignConfiguration {
    @Bean
    public Decoder feignDecoder(){
        ObjectFactory<HttpMessageConverters> messageConverter=()->{
            HttpMessageConverters converters=new HttpMessageConverters();
            return converters;
        };
        return new SpringDecoder(messageConverter);
    }
}
