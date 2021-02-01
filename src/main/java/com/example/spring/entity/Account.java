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
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "account_state", nullable = false)
    private Integer accountState;
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleType role;
    @Column(name = "created")
    @CreatedDate
    private LocalDate created;
    @Column(name = "last_modified")
    @LastModifiedDate
    private LocalDate lastModified;
}
