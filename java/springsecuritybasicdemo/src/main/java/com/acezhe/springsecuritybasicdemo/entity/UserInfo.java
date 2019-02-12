package com.acezhe.springsecuritybasicdemo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    @Size(max = 100)
    @NonNull
    private String username;

    @Column
    @Size(max = 500)
    @NonNull
    private String password;

    @Column
    @Size(max = 10)
    @NonNull
    private String role;
}
