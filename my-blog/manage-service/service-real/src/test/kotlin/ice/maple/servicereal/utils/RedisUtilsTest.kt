package ice.maple.servicereal.utils

import ice.maple.manageservice.bo.SysUser
import ice.maple.servicereal.BaseTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-10 10:53
 */
class RedisUtilsTest : BaseTest(){
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val testKey = this.javaClass.name

    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, Any>
    @Autowired
    lateinit var redisUtils: RedisUtils

    @Before
    fun setUp() {
        log.info("----------before-----------")
    }

    @After
    fun tearDown() {
        log.info("----------after-----------")
    }

    @Test
    fun getByAny() {
        val sysUser = SysUser("111", "222", "2222")
        redisUtils.setAny(testKey,sysUser)
        val retUser = redisUtils.getT<SysUser>(testKey)
        println(retUser)
        redisUtils.delete(testKey)
    }

    @Test
    fun getAnyByKey() {
    }

    @Test
    fun setAny() {
    }

    @Test
    fun redisUtilTest(){
        val sysUser = SysUser("1","maple","1111")
        redisUtils.setAny("user",sysUser)
//        val user1 = RedisUtils.getByKey<SysUser>("user")
    }

    @Test
    fun redisObjTest(){
        val sysUser = SysUser("1","maple","1111")
        redisTemplate.opsForValue().set("user",sysUser)
        val user1 = redisTemplate.opsForValue().get("user") as? SysUser
        log.info("取值成功")
    }

    @Test
    fun redisStringTest(){
        redisUtils.setAny(testKey,"100");
        val returnValue = redisUtils.getLong(testKey)
        println(returnValue)
    }
}