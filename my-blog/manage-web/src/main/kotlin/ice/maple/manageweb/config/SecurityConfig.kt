package ice.maple.manageweb.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
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
open class SecurityConfig:WebSecurityConfigurerAdapter(){

    override fun configure(http: HttpSecurity?) {
        super.configure(http)
        http?.let {
            http.authorizeRequests()
                    .antMatchers("/", "/index.html").permitAll()
                    .anyRequest().authenticated()// 其他地址的访问均需验证权限
                    .and()
                    .formLogin()
                    .loginPage("/login.html")
                    .failureUrl("/login-error.html").permitAll()
                    .and()
                    .logout()
                    .logoutSuccessUrl("/index.html");
        }
    }

    @Bean
    open fun passwordEncoder():PasswordEncoder{
        return BCryptPasswordEncoder();
    }
}