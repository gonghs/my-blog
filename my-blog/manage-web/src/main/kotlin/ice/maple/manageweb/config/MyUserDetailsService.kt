package ice.maple.manageweb.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import ice.maple.manageservice.service.IUserService
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service


/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 11:03
 */
@Service
class MyUserDetailsService : UserDetailsService {

    @Autowired
    lateinit var userService: IUserService

    /**
     * 根据用户名返回用户
     *
     * @param username 用户名
     * @return UserDetails 用户
     */
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String?): UserDetails {
        val name:String = username!!.toString()
        val sysUser = userService.getUserByName(name)
        sysUser ?: throw UsernameNotFoundException(username)
        var authorities = mutableListOf<SimpleGrantedAuthority>()
        sysUser.roles.forEach {
            it.permissions.forEach { it -> authorities.add(SimpleGrantedAuthority(it.code)) }
        }
        return User(sysUser.name, sysUser.password, authorities)
    }

}