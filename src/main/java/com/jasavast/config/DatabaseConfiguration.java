package com.jasavast.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.jasavast.repository"})
public class DatabaseConfiguration {
    private org.h2.tools.Server webServer;
    private org.h2.tools.Server tcpServer;
    @EventListener(org.springframework.context.event.ContextRefreshedEvent.class)
    public void start() throws java.sql.SQLException{
        this.webServer=org.h2.tools.Server.createWebServer("-webPort","8082","-tcpAllowOthers").start();
        this.tcpServer=org.h2.tools.Server.createTcpServer("-tcpPort","9092","-tcpAllowOthers").start();
    }
    @EventListener(org.springframework.context.event.ContextClosedEvent.class)
    public void stop() {
        this.tcpServer.stop();
        this.webServer.stop();
    }
}
