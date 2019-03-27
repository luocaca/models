package me.luocaca.model.service;

import me.luocaca.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookService extends JpaRepository<Book,Integer> {
}
