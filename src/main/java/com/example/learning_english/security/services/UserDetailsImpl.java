package com.example.learning_english.security.services;

import com.example.learning_english.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {
    private int id;
    private String username;
    private String email;

    private String password;
    private boolean enabled;
    private List<Integer> groupId;

    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(int id,
                           String username,
                           String email,
                           String password,
                           boolean enabled,
                           List<Integer> groupId,
                           Collection<? extends GrantedAuthority> authorities){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.enabled = enabled;
        this.groupId = groupId;
    }

    //TODO: Build a UserDetails
    public static UserDetailsImpl build(User user){

        //convert Set<Role> into List<GrantedAuthority>
        List<GrantedAuthority> auth = user.getRoles()
                                        .stream()
                                        .map(role ->
                                                new SimpleGrantedAuthority(role.getName().name())
                                        )
                                        .collect(Collectors.toList());
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                user.getGroupMembers().stream().map(groupMember -> groupMember.getGroup().getId()).collect(Collectors.toList()),
                auth
        );
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public List<Integer> getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        UserDetailsImpl userDetails = (UserDetailsImpl) obj;
        return Objects.equals(id,userDetails.id);
    }
}
