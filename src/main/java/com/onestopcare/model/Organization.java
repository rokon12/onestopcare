package com.onestopcare.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Bazlur Rahman Rokon
 * @since 9/30/15.
 */
public class Organization {

    private String name;
    private String description;

    private Set<Module> modules = new HashSet<>();
    private Set<User> users = new HashSet<>();

}
