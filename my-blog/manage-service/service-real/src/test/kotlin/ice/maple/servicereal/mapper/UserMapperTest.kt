package ice.maple.servicereal.mapper

import ice.maple.servicereal.BaseTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

/**
 * 用户mybatis测试类
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-11 16:35
 */

class UserMapperTest : BaseTest() {
    @Autowired(required = false)
    lateinit var userMapper: IUserMapper

    @Test
    fun testGetUsers(){
        val list = userMapper.getUsers()
        list.forEach { println(it) }
    }

    @Test
    fun testGetUsers1(){
        val list = userMapper.getUsers1()
        list.forEach { println(it) }
    }
}