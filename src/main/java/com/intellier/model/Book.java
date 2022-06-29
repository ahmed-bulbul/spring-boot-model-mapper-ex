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
@Table(name = "BOOK")
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    //Many-to-one relation with user/author
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User author;

    private Boolean isPublished;

    //One-to-many relation with comment
    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Post> posts;

    public Book(Long id, String title, String description, User author, Boolean isPublished) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.author = author;
        this.isPublished = isPublished;
    }
}
