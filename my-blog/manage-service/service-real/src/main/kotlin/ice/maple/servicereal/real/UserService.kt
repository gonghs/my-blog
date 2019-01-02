package ice.maple.servicereal.real

import ice.maple.manageservice.bo.SysUser
import ice.maple.manageservice.service.IUserService
import ice.maple.servicereal.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 11:08
 */

@Service
class UserService : IUserService {
    @Autowired
    val userDao: UserDao? = null

    override fun getUserByName(name: String):SysUser? {
        return userDao?.queryByName(name);
    }
}