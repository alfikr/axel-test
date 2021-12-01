package com.jasavast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jsv_audit")
@Builder
@Entity
public class AuditEventModel {
    @Id
    @Column(name="event_id")
    private String id;

    @NotNull
    private String principal;

    @Column(name="event_date")
    @Builder.Default
    private LocalDateTime auditEventDate=LocalDateTime.now();

    @Column(name="event_type")
    private String auditEventType;
    @Column(name = "log_type")
    private String logType;
    @Column(name = "execution_time")
    private long executionTime;
    @Column
    private boolean error;
    @Column
    private long executionStart;
    private String errorMessage;
    @Column
    private long executionEnd;
    private String className;
    private String methodName;
    private String message;
    private String title;
    @Transient
    private Map<String,String> data = new HashMap<>();

}
