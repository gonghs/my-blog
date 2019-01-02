package ice.maple.servicereal

import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ServiceRealApplicationTests {
    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    val redisTemplate: RedisTemplate<String, Any>?= null
    @Test
    fun contextLoads() {

    }

    @Test
    fun redisSet(){
        redisTemplate!!.opsForValue().set("maple", "maple1111")
        redisTemplate.opsForValue().get("maple")
        log.info("取值成功")
    }
}