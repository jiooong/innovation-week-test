package com.example.jpa_relation_test.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class BookStore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "bookStore")
    private List<Book> bookList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void addBook(Book book){
        book.setBookStore(this);
        this.bookList.add(book);
    }
}
