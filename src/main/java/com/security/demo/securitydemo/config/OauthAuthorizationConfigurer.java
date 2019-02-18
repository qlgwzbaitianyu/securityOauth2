package com.security.demo.securitydemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.token.TokenStore;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableAuthorizationServer
public class OauthAuthorizationConfigurer extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()");
    }

    public ClientDetailsService clientDetailsService() {
        return new ClientDetailsService() {
            @Override
            public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
                BaseClientDetails details = new BaseClientDetails();
                details.setClientId("aaa");
                details.setClientSecret("$2a$10$5zuH0Tf.JGT2rtRqNU0SVeTxNJWezNzzmzDM4p/0Ifj4JDoj9Pfvu");
                details.setAuthorizedGrantTypes(Arrays.asList("authorization_code") );
                details.setScope(Arrays.asList("all"));
                details.setRegisteredRedirectUri(Collections.singleton("http://anywhere.com"));
                details.setResourceIds(Arrays.asList("oauth2-resource"));
                Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
                authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
                details.setAuthorities(authorities);
                return details;
            }
        };
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //clients.withClientDetails(clientDetailsService());
        clients.inMemory()
                .withClient("aaa")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                .authorities("ROLE_CLIENT", "ROLE_ADMIN", "ROLE_ANONYMOUS")
                .scopes("all")
                .secret("$2a$10$5zuH0Tf.JGT2rtRqNU0SVeTxNJWezNzzmzDM4p/0Ifj4JDoj9Pfvu")
                .redirectUris("http://anywhere.com")
                .accessTokenValiditySeconds(60);
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }
}
