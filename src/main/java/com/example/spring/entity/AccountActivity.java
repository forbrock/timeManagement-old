package com.example.spring.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "account_activity",
        uniqueConstraints = {@UniqueConstraint(columnNames={"account_id", "activity_id"})})
public class AccountActivity {
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
    private LocalDate created;
    @Column(name = "accepted")
    @DateTimeFormat
    private LocalDate accepted;
}
