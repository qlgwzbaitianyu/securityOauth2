package com.security.demo.securitydemo.security;

import com.security.demo.securitydemo.dto.Role;
import com.security.demo.securitydemo.dto.User;
import com.security.demo.securitydemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class FormLogInUserDetail implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(FormLogInUserDetail.class);


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
        User user = userRepository.findUserByName(s, firstPageWithTwoElements).get(0);
        org.springframework.security.core.userdetails.User securityUser = null;
        if(user != null){
            StringBuilder authorityString = new StringBuilder();
            for(Role role : user.getRoles()){
                authorityString.append(role.getName()).append(",");
            }

            securityUser = new org.springframework.security.core.userdetails.User(
                    user.getName(), user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(authorityString.toString() + "ROLE_USER")
            );
            logger.info("in loadUserByUserName: " + user.toString() + "\n" + "** securityUser: " + securityUser.toString());
            logger.info("user authorities" + securityUser.getAuthorities().toString());
        }

        //return org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder().username("ty").password("0718").roles("ADMIN").build();
        return securityUser;
    }
}
