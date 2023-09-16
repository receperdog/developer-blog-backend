package com.erdog.developerblogbackend.model;

import com.erdog.developerblogbackend.model.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseModel {
    @Column(unique = true, name = "user_name")
    private String userName;
    @Column(name = "fist_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "teelphone_number")
    private String telephoneNumber;
    @Column(name = "password")
    private String password;
}
