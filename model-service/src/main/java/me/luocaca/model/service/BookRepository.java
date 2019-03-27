package me.luocaca.model.service;

import me.luocaca.model.entity.Book;
import me.luocaca.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Administrator
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


    /**
     * @param  user
     * @return
     */
//    @Override
//    User save(User user);


}
