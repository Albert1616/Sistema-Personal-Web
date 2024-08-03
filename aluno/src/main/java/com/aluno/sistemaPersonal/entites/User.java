package com.aluno.sistemaPersonal.entites;

import com.aluno.sistemaPersonal.enumerate.UserTypes;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class User {
    private String login;

    private String password;

    private UserTypes paper;
}
