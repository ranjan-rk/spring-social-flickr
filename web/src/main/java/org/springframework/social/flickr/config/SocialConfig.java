package org.springframework.social.flickr.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.flickr.api.Flickr;
import org.springframework.social.flickr.connect.FlickrConnectionFactory;
import org.springframework.social.flickr.user.SecurityContext;
import org.springframework.social.flickr.user.SimpleConnectionSignUp;
import org.springframework.social.flickr.user.SimpleSignInAdapter;
import org.springframework.social.flickr.user.User;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import java.util.logging.Logger;

@Configuration
public class SocialConfig {


    protected Log logger   = LogFactory.getLog(getClass());

    @Inject
    private DataSource dataSource;

    @Inject
    private Environment environment;

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
    	System.out.println("inside the connection facotry locator");
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FlickrConnectionFactory(
            environment.getProperty("clientId"),
            environment.getProperty("clientSecret")));
        return registry;
    }

    @Bean
    @Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository(){
    	logger.debug("inside the connectionRepository");
    	User user = SecurityContext.getCurrentUser();
	    return usersConnectionRepository().createConnectionRepository(user.getId());
    }

    @Bean
    public UsersConnectionRepository usersConnectionRepository() {
    	logger.debug("inside the usersConnectionRepository");
    	JdbcUsersConnectionRepository repository =
                new JdbcUsersConnectionRepository(dataSource,
				connectionFactoryLocator(), Encryptors.noOpText());
		repository.setConnectionSignUp(new SimpleConnectionSignUp());
		return repository;
    }


	@Bean
	@Scope(value="request", proxyMode=ScopedProxyMode.INTERFACES)
	public Flickr flickr() {
		logger.debug("inside the flickr");
	    return connectionRepository().getPrimaryConnection(Flickr.class).getApi();
	}

	@Bean
	public ProviderSignInController providerSignInController() {
		logger.debug("inside the providerSignInController");
        return new ProviderSignInController(
                connectionFactoryLocator(),
                usersConnectionRepository(),
                new SimpleSignInAdapter());
	}
	
	 
	@Bean 
	public CommonsMultipartResolver multipartResolver(){
		logger.debug("calling CommonsMultipartResolver");
		CommonsMultipartResolver c = new CommonsMultipartResolver();
		c.setMaxUploadSize(100 * 1000);
		return c;
	}
}
