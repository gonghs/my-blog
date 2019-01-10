package ice.maple.servicereal.config

import ice.maple.servicereal.BaseTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-10 14:24
 */
class ConfigTest : BaseTest(){
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val testKey = this.javaClass.name

    @Value("\${spring.redis.port}")
    private lateinit var port:String

    @Autowired
    private lateinit var redisProperties:RedisProperties

    @Before
    fun setUp() {
        log.info("----------before-----------")
    }

    @After
    fun tearDown() {
        log.info("----------after-----------")
    }

    @Test
    fun testProperties(){
        println(redisProperties.port)
        println(redisProperties.host)
        println(redisProperties.timeout)
    }
}