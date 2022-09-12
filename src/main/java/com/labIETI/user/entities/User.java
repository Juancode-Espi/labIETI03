package com.labIETI.user.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User {

    @Id
    private Long id;

    private String name;

    @Indexed( unique = true )
    private String email;

    private String lastName;

    private LocalDate createdAt;
}
