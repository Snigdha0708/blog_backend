package com.example.demo.modal;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Followers implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Users users;
    @ManyToOne
    private Users users1;
   public Followers()
   {}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Users getUsers1() {
        return users1;
    }

    public void setUsers1(Users users1) {
        this.users1 = users1;
    }
}
