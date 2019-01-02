package ice.maple.manageweb.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 11:03
 */
class MyUserDetailsService: UserDetailsService {

    override fun loadUserByUsername(p0: String?): UserDetails {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}