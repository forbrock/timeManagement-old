package com.myproject.spring.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

//@Entity
@Table(name = "users_activities",
        uniqueConstraints = {@UniqueConstraint(columnNames={"account_id", "activity_id"})})
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "activity_id", nullable = false)
    private Long activityId;

    @Column(name = "activity_state", nullable = false)
    private Integer activityState;

    @Column(name = "created")
    @CreatedDate
    private LocalDateTime created;

    @Column(name = "accepted")
    @DateTimeFormat
    private LocalDateTime accepted;
}
