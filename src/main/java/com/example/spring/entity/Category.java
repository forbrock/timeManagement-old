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

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", unique = true, nullable = false)
    private String name;
    @Column(name = "category_state", nullable = false)
    private Integer categoryState;
    @Column(name = "created")
    @CreatedDate
    private LocalDate created;
    @Column(name = "last_modified")
    @LastModifiedDate
    private LocalDate lastModified;
}
