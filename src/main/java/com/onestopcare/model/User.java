package com.onestopcare.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
public class User {
    private String login;
    private String fullName;
    private String email;
    private String password;
    private String salt;
    private boolean enabled;

    private Organization organization; //user belongs to organization

    private Set<Role> roles = new HashSet<>();
}
