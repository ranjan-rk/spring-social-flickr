package org.springframework.social.flickr.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.flickr.connect.FlickrConnectionFactory;

@Configuration
public class SocialConfig {

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        
        registry.addConnectionFactory(new FlickrConnectionFactory(
            environment.getProperty("clientId"),
            environment.getProperty("clientSecret")));
        return registry;
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new IllegalStateException("Unable to get a ConnectionRepository: no user signed in");
        }
        return usersConnectionRepository().createConnectionRepository(authentication.getName());
    }
    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator(), 
            textEncryptor);
    }
    
    @Bean
    public ConnectController connectController() {
        return new ConnectController(connectionFactoryLocator(), connectionRepository());
    }

    @Inject
    private DataSource dataSource;

    @Inject
    private TextEncryptor textEncryptor;	
    @Inject
    private Environment environment;
}
