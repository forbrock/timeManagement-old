package com.myproject.spring.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
}
