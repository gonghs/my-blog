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
class RedisUtils {
    @Autowired
    lateinit var redisTemplate: RedisTemplate<String, Any>

    /**
     * 获取普通缓存对象
     *
     * @param key 键
     * @return any 值对象
     */
    fun getAnyByKey(key: String):Any? {
        return redisTemplate.opsForValue().get(key)
    }

    /**
     * 获取普通缓存对象
     *
     * @param key 键
     * @return any 值对象
     */
    inline fun <reified T : Any> getByKey(key: String):T? {
        return  redisTemplate.opsForValue().get(key) as? T
    }

    /**
     * 存入普通缓存对象
     *
     * @param key 键
     * @param value 值对象
     * @return Boolean 是否成功
     */
    fun setAny(key:String,value:Any) {
        redisTemplate.opsForValue().set(key,value)
    }

    /**
     * 删除普通缓存对象
     *
     * @param key 键
     * @return Boolean 是否成功
     */
    fun delete(key:String):Boolean {
        return redisTemplate.delete(key)
    }
}