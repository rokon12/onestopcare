package com.onestopcare.model;

import javax.persistence.*;

/**
 * @author Bazlur Rahman Rokon
 * @date 10/1/15.
 */
@Entity
public class UserRole extends PersistenceObject<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserRole setId(Integer id) {
        this.id = id;
        return this;
    }

    public User getUser() {
        return user;
    }

    public UserRole setUser(User user) {
        this.user = user;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserRole setRole(Role role) {
        this.role = role;
        return this;
    }

    @Override
    public Integer getId() {
        return id;
    }
}
