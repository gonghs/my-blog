package ice.maple.manageweb.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * security认证配置
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 10:28
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
open class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var myUserDetailsService: MyUserDetailsService

    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .antMatchers("/", "/css/**").permitAll()
                .antMatchers("/admin").hasRole("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll()
        http.exceptionHandling().accessDeniedPage("/403");
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder())
    }


    @Bean
    open fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder();
    }
}

fun main(args: Array<String>) {
    val password: String = "123456";
    val passwordEncoder = BCryptPasswordEncoder(6)
    println(passwordEncoder.encode(password))
}