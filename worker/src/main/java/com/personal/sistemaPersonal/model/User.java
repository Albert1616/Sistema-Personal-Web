package com.personal.sistemaPersonal.model;

import com.personal.sistemaPersonal.enumerate.UserTypes;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true, nullable = false)
    @NotEmpty(message = "{campo.login.obrigatorio}")
    private String login;
    @Column(nullable = false)
    @NotEmpty(message = "{campo.password.obrigatorio}")
    private String password;
    @Column
    @NotNull
    private UserTypes paper;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public String getLogin(){
        return this.login;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public UserTypes getPaper(){
        return this.paper;
    }

}
