package me.luocaca.model.entity;

import lombok.Data;
import me.luocaca.model.entity.Company;

import javax.persistence.*;
import java.util.Set;

/**
 * User
 * <p/>
 * Created in 2018.07.25
 * <p/>
 *
 * @author <a href="https://github.com/liaozihong" style="background: #55a7e3;">Liaozihong</a>
 */
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private int age;


    @Column(name = "active")
    private int active;


    public User() {
    }

    public User(User users) {
        this.active = users.getActive();
        this.roles = users.getRoles();
        this.id = users.getId();
        this.password = users.getPassword();
    }

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "user_role" , joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    /**
     * OneToOne User是关系的维护端，当删除 User，会级联删除 company
     * user中的companyIdcompanyId字段参考company表中的id字段
     */
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "companyId", referencedColumnName = "id")
    private Company company;

}
