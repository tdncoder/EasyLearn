//package com.easy.learn.service;
//
//import com.easy.learn.entity.Manager;
////import org.springframework.security.core.GrantedAuthority;
////import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class CustomManagerDetails implements UserDetails {
//    private Manager manager;
//    public CustomManagerDetails(Manager manager) {
//        this.manager = manager;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return manager.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return manager.getUserNameManager();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public String getFullName() {
//        return manager.getFirstName() + " " + manager.getLastName();
//    }
//}
