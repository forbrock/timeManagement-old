package com.myproject.spring.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "state", length = 20, columnDefinition = "varchar(20) default 'ACTIVE'", nullable = false)
    @Enumerated(EnumType.STRING)
    private State state = State.ACTIVE;

    @Column(name = "created")
    @CreatedDate
    private LocalDateTime created;

    @Column(name = "last_modified")
    @LastModifiedDate
    private LocalDateTime lastModified;
}
