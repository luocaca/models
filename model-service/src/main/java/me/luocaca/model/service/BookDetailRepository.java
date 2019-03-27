package me.luocaca.model.service;

import me.luocaca.model.entity.Book;
import me.luocaca.model.entity.BookDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 */
public interface BookDetailRepository extends JpaRepository<BookDetail, Long> {


    /**
     * @param  user
     * @return
     */
//    @Override
//    User save(User user);


}
