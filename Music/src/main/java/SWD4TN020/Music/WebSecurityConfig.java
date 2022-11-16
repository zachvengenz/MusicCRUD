package SWD4TN020.Music;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig  {
	@Autowired
	private UserDetailsService userDetailsService;
	
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        	.antMatchers("/css/**", "/", "/artist_list", "/album_list", 
        			"/recordlabel_list", "/track_list", "/artist_albums/{id}", 
        			"/album_tracks/{id}", "/api", "/artists", "/albums", "/tracks", "/recordlabels").permitAll()
        	.antMatchers("/h2-console/**").permitAll()
        	.anyRequest().authenticated()
        	.and()
    	  .csrf().ignoringAntMatchers("/h2-console/**")
    	  .and()
    	  .headers().frameOptions().sameOrigin()
    	  .and()
        .formLogin()
          .permitAll()
          .and()
         .logout()
          .logoutSuccessUrl("/")
          .permitAll()
          .and()
         .httpBasic();
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}