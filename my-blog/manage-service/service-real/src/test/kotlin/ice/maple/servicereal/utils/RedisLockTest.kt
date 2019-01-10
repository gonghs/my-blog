package ice.maple.servicereal.utils

import ice.maple.servicereal.BaseTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.redisson.api.RLock
import org.redisson.api.RedissonClient
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import java.util.concurrent.TimeUnit

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-10 12:39
 */
class RedisLockTest : BaseTest(){
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val testRedisKey = this.javaClass.name
    private val lockKey = "testLockKey"
    @Autowired
    lateinit var redisUtils: RedisUtils
    @Autowired
    lateinit var redisClient: RedissonClient
    @Before
    fun setUp() {
        log.info("----------before-----------")
    }

    @After
    fun tearDown() {
        log.info("----------after-----------")
    }

    @Test
    fun testDistributed(){
        redisUtils.setAny(testRedisKey,"100")
        println("100" == redisUtils.getT<String>(testRedisKey))
        for (i in 0..55){
            val lock = redisClient.getLock(lockKey)
            lock.lock(60,TimeUnit.MINUTES)
            val stock = redisUtils.getT<Int>(testRedisKey)
            if(stock!! > 0){
                redisUtils.setAny(testRedisKey, value = stock-1)
                println("stock: $stock-1")
            }
        }
    }
}