package examples.springsecurity;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true
)
@EnableAutoConfiguration(
        exclude = {
                UserDetailsServiceAutoConfiguration.class
        }
)
public class ApplicationBootSecurity {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.csrf()
                .disable();

        http.cors()
                .disable();

        http.httpBasic()
                .disable();

        http.jee()
                .disable();

        http.formLogin()
                .disable();

        http.logout()
                .disable();

        http.rememberMe()
                .disable();

        http.x509()
                .disable();

        http.requestCache()
                .disable();

        http.authorizeRequests()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/**/*").authenticated();

        return http.build();
    }

}
