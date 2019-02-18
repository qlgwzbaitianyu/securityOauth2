/*
package com.security.demo.securitydemo.security;

import com.security.demo.securitydemo.dto.User;
import com.security.demo.securitydemo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class OauthClientDetailService implements ClientDetailsService {
    @Autowired
    UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(FormLogInUserDetail.class);

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        User user = userRepository.findUserById(Integer.parseInt(clientId));

        BaseClientDetails details = new BaseClientDetails();
        details.setClientId(clientId);
        details.setAuthorizedGrantTypes(Arrays.asList("authorization_code") );
        details.setScope(Arrays.asList("read, trust"));
        details.setRegisteredRedirectUri(Collections.singleton("http://anywhere.com"));
        details.setResourceIds(Arrays.asList("oauth2-resource"));
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        details.setAuthorities(authorities);
        return details;
    }
}
*/
