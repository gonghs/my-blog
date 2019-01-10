package ice.maple.servicereal.config


import ice.maple.servicereal.utils.HessianRedisSerializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer

/**
 * redis 配置类
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-02 09:53
 */
@Configuration
open class RedisConfig{

    /**
     * 将redisTemplate格式化为string,any格式
     *
     * @param factory redis连接工厂
     * @return redisTemplate
     */
    @Bean
    open fun redisTemplate(factory: RedisConnectionFactory):RedisTemplate<String,Any> {
        val template = RedisTemplate<String,Any>()
        template.connectionFactory = factory
        val hessianRedisSerializer = HessianRedisSerializer(Any::class.java)
//        val om = ObjectMapper()
//        om.setVisibility(PropertyAccessor.ALL,JsonAutoDetect.Visibility.ANY)
//        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
//        jackson2JsonRedisSerializer.setObjectMapper(om)
        val stringRedisSerializer = StringRedisSerializer()
        template.keySerializer = stringRedisSerializer
        template.hashKeySerializer = stringRedisSerializer
        template.valueSerializer = hessianRedisSerializer
        template.hashValueSerializer = hessianRedisSerializer
        template.afterPropertiesSet()
        return template
    }
}