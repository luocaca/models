package me.luocaca.model.service;

import me.luocaca.model.entity.Company;
import me.luocaca.model.entity.User;

public interface UserService {


    /**
     * save.
     *
     * @param user
     */
    User save(User user);

    Company save(Company company);
}
