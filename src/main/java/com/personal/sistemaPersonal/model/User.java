package com.personal.sistemaPersonal.model;

import com.personal.sistemaPersonal.enumerate.UserTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String login;
    @Column
    @NotEmpty(message = "{campo.password.obrigatorio}")
    private String password;
    @Column
    @NotEmpty(message = "{campo.type.obrigatorio}")
    private UserTypes paper;
}
