package me.luocaca.model.service;

import me.luocaca.model.entity.Company;
import me.luocaca.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Administrator
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {


    /**
     * @param  user
     * @return
     */
//    @Override
//    User save(User user);


}
