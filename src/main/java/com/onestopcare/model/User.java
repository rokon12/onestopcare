package com.onestopcare.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
@Entity
public class User extends PersistenceObject<Long> implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 4, max = 32)
    private String login;

    @Size(min = 4, max = 120)
    private String fullName;

    @Email
    @Size(min = 4, max = 120)
    private String email;

    @Size(max = 280)
    private String password;

    @Size(max = 16)
    private String salt;

    private boolean enabled;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Organization organization; //user belongs to organization

    @Column(nullable = false)
    private boolean locked;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<UserRole> userRoles = new HashSet<>();

    @Transient
    private List<SimpleGrantedAuthority> simpleGrantedAuthorityList;

    @Override
    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public User setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    public User setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Organization getOrganization() {
        return organization;
    }

    public User setOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

    public boolean isLocked() {
        return locked;
    }

    public User setLocked(boolean locked) {
        this.locked = locked;
        return this;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public User setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
        return this;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (simpleGrantedAuthorityList == null && !CollectionUtils.isEmpty(getUserRoles())) {
            simpleGrantedAuthorityList = new ArrayList<>();

            simpleGrantedAuthorityList
                    .addAll(getUserRoles()
                            .stream()
                            .map(userRole -> new SimpleGrantedAuthority(userRole
                                    .getRole().name())).collect(Collectors.toList()));
        }

        return simpleGrantedAuthorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
