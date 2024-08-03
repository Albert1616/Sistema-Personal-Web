package com.nutri.sistemaPersonal.entites;

import com.nutri.sistemaPersonal.enumerate.UserTypes;
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
