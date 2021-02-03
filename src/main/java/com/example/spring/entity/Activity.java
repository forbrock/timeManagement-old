package com.example.spring.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

//@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "category_id", nullable = false)
    private Long categoryId;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "activity_state", nullable = false)
    private Integer activityState;
    @Column(name = "created")
    @CreatedDate
    private LocalDate created;
    @Column(name = "last_modified")
    @LastModifiedDate
    private LocalDate lastModified;
}
