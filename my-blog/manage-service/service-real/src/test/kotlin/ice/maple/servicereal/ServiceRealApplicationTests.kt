package ice.maple.servicereal

import ice.maple.servicereal.dao.UserDao
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.test.context.junit4.SpringRunner
import javax.inject.Inject

@RunWith(SpringRunner::class)
@SpringBootTest
class ServiceRealApplicationTests {
    private val log = LoggerFactory.getLogger(this.javaClass)
    @Inject
    lateinit var userDao: UserDao

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, Any>
    @Test
    fun contextLoads() {

    }

    @Test
    fun redisSet(){
        redisTemplate.opsForValue().set("maple", "maple")
        println(redisTemplate.opsForValue().get("maple"))
        log.info("取值成功")
    }

    @Test
    fun userDaoTest(){
        userDao.queryByName("maple")
    }
}