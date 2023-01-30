package com.example.springbootcrud.User.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

// serializable helps translating to streams
@Entity //needed for database mapping
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    public Long id;
    public String name;
    private String email;
    private int yob;
    @Enumerated(EnumType.ORDINAL)
    private com.example.springbootcrud.User.Model.Role role;

    @Column(name = "terms_and_conditions")
    private boolean termsandconditions;

    public User(String name, String email, int yob, Role role, boolean termsandconditions) {
        this.name = name;
        this.email = email;
        this.yob = yob;
        this.role = role;
        this.termsandconditions = termsandconditions;
    }

    public User(String name, String email, int yob, boolean termsandconditions) {
        this.name = name;
        this.email = email;
        this.yob = yob;
        this.termsandconditions = termsandconditions;
    }
}
