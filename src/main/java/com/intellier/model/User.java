package com.intellier.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACL_USER")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String username;
    private String password;
    private String role;

    //one many relation with book
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;


    public User(long l, String fullName, String username, String password, String author) {
        this.id = l;
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.role = author;
    }
}
