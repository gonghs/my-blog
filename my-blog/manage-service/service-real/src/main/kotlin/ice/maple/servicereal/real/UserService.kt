package ice.maple.servicereal.real

import ice.maple.manageservice.bo.SysUser
import ice.maple.manageservice.service.IUserService
import ice.maple.servicereal.dao.UserDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

/**
 * 用户服务类
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 11:08
 */

@Service
open class UserService : IUserService {
    @Autowired
    lateinit var userDao: UserDao

    @Cacheable(cacheNames = ["authority"],key = "#name")
    override fun getUserByName(name: String):SysUser? {
        return userDao.queryByName(name)
    }
}