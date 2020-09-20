package com.domain;

import com.domain.parts.UserRole;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name= "nickname")
    private String nickname;

    @Column(name="loginname")
    private String loginname;

    @Column(name="password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name="activate")
    private boolean activeStatus;
}
