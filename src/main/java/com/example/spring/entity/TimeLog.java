package com.example.spring.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

//@Entity
@Table(name = "account_activity")
public class TimeLog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "start_date")
    @CreatedDate
    private LocalDate startDate;
    @Column(name = "account_activity_id")
    private Long accountActivityId;
}
