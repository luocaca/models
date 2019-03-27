package me.luocaca.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Company {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String createData;
    @Column(nullable = false)
    private String location;


//
//
//    @Column(name = "phone", nullable = true, length = 11)
//    private String phone;//手机
//    @Column(name = "zipcode", nullable = true, length = 6)
//    private String zipcode;//邮政编码
//    @Column(name = "address", nullable = true, length = 100)
//    private String address;//地址


//    @OneToOne(cascade={CascadeType.ALL})
//    @PrimaryKeyJoinColumn(name = "id", referencedColumnName="company_id")
//    private User user;


}
