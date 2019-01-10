package ice.maple.servicereal.utils

import ice.maple.utils.SerializeUtils
import org.springframework.data.redis.serializer.RedisSerializer
import java.nio.charset.Charset

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-09 20:58
 */
class HessianRedisSerializer<T>(private var clazz: Class<T>) : RedisSerializer<T>{

    override fun serialize(t: T?): ByteArray? {
        return SerializeUtils.hessianSerialize(t)
    }

    override fun deserialize(bt: ByteArray?): T? {
        if(bt == null || bt.isEmpty()) return null
        return SerializeUtils.hessianDeserialize(bt) as? T
    }

}