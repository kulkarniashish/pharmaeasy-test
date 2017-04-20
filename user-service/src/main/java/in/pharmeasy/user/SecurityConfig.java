package in.pharmeasy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("patient").password("patient").roles("PATIENT")
		.and()
		.withUser("doctor").password("doctor").roles("DOCTOR")
		.and()
		.withUser("doctor2").password("doctor2").roles("DOCTOR")
		.and()
		.withUser("pharmacist").password("pharmacist").roles("PHARMACIST");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll()
		.and().formLogin();

		http.csrf().disable();
	}
}