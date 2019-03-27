package me.luocaca.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class BookDetail {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private long numberOfPages;


    private String intro;
//    @OneToOne(cascade = CascadeType.ALL,mappedBy = "bookDetail")
//    private Book book ;


    public BookDetail() {
    }

    public BookDetail(long numberOfPages) {
        this.numberOfPages = numberOfPages;

    }

}
