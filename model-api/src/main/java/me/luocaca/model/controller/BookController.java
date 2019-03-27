package me.luocaca.model.controller;

import me.luocaca.model.entity.Book;
import me.luocaca.model.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {


    @Autowired
    BookService bookService;

    @RequestMapping("/addBook")
    public Book addBook(Book book) {
        book.setBookName("跟着大傻学java");
        book.setPrice(12.50f);
        book.setOwerId(2);
        return bookService.save(book);
    }

    @RequestMapping("/getBooks")
    public String getBooks() {
        return bookService.findAll() + "";
    }


}
