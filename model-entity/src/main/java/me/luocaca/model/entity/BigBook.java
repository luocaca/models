package me.luocaca.model.entity;

import lombok.Data;

@Data
public class BigBook {
    private String  bookName;
    private String author;

    public BigBook(){

    }

    public BigBook(String bookName, String author) {
        this.bookName = bookName;
        this.author = author;
    }
}
