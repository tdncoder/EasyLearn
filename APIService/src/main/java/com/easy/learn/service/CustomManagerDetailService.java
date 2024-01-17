//package com.easy.learn.service;
//
//import com.easy.learn.entity.Manager;
//import com.easy.learn.repository.ManagerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//public class CustomManagerDetailService implements UserDetailsService {
//@Autowired
//private ManagerRepository managerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Manager manager = managerRepository.findByUserName(username);
//        if (manager == null) {
//            throw new UsernameNotFoundException("Username not found");
//        }
//        return new CustomManagerDetails(manager);
//    }
//}
