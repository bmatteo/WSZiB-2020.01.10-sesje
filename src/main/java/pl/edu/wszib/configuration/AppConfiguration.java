package pl.edu.wszib.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.SessionScope;
import pl.edu.wszib.SessionObject;

@Configuration
public class AppConfiguration {
    @Bean
    @SessionScope
    public SessionObject sessionObject() {
        return new SessionObject();
    }
}
