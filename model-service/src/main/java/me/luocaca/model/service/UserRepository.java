package me.luocaca.model.service;

import me.luocaca.model.entity.Person;
import me.luocaca.model.entity.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * @author Administrator
 */
public interface UserRepository extends JpaRepository<User, Long> {


    /**
     * @param
     * @return
     */
//    @Override
//    User save(User user);

    //   @Query(value = "SELECT DISTINCT t1.to_user_id FROM (SELECT * FROM relationship WHERE from_user_id = ?1)  AS t1 INNER JOIN relationship t2 ON t1.to_user_id = t2.from_user_id ", nativeQuery = true)
//    List<Long> findFriendsByUserId(Long userId);
    @Query(value = "SELECT * FROM USER  WHERE user_name = ?1", nativeQuery = true)
    Optional<User> findByName(String username);


}
