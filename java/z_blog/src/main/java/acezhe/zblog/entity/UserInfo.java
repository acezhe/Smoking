package acezhe.zblog.entity;

import lombok.Data;

import javax.persistence.*;
/**
 * UserInfo POJO
 */
@Entity
@Table(name = "user_info")
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String password;


}
