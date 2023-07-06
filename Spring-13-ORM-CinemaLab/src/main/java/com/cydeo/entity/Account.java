package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "account_details")
public class Account extends BaseEntity{

    private String name;
    private  String address;
    private String country;
    private String city;
    private String State;
    private Integer age;
    private String postal_code;
    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.ADMIN;

    @OneToOne(mappedBy = "account")
    private User user;


}
