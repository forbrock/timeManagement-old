package com.myproject.spring.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_categories_id", referencedColumnName = "id", nullable = false)
    Set<Activity> activities = new HashSet<>();

    @Column(name = "category_state", length = 20, columnDefinition = "varchar(20) default 'ACTIVE'", nullable = false)
    @Enumerated(EnumType.STRING)
    private State state = State.ACTIVE;

    @Column(name = "created")
    @CreatedDate
    private LocalDateTime created;

    @Column(name = "last_modified")
    @LastModifiedDate
    private LocalDateTime lastModified;
}
