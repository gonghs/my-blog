package ice.maple.servicereal.utils

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Component

/**
 * redis 工具类
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-02 10:08
 */

@Component
object RedisUtils{
    @Autowired
    val redisTemplate: RedisTemplate<String, Any> ?= null

}