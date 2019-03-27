package me.luocaca.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "book")
public class Book implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "book_name")
    private String bookName;

    @Column(name = "price")
    private float price;


    @Column(name = "owerId")
    private Integer owerId;


    @OneToOne
            (cascade = CascadeType.ALL)
    @JoinColumn(name = "book_detail")
    private BookDetail bookDetail;

    public Book() {

    }


    public Book(String bookName, float price,BookDetail bookDetail) {

        this.bookName = bookName;
        this.price = price;
        this.bookDetail = bookDetail;
    }


}
