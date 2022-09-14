package com.labIETI.user.entities;

import com.labIETI.user.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;


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

    private String passwordHash;

    private List<RoleEnum> roles;

    public void update(User user){
        if(user.getEmail() != null){
            this.setEmail(user.getEmail());
        }
        if(user.getName() != null){
            this.setName(user.getName());
        }
        if(user.getLastName() != null){
            this.setLastName(user.getLastName());
        }
        if(user.getCreatedAt() != null){
            this.setCreatedAt(user.getCreatedAt());
        }
        if(user.getPasswordHash() != null){
            this.setPasswordHash(user.getPasswordHash());
        }
    }
}
