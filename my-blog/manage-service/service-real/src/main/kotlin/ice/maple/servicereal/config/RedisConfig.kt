package ice.maple.servicereal.config


import ice.maple.servicereal.utils.HessianRedisSerializer
import org.apache.commons.lang.StringUtils
import org.redisson.Redisson
import org.redisson.api.RedissonClient
import org.redisson.config.Config
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.StringRedisSerializer
import javax.annotation.Resource

/**
 * redis 配置类
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-02 09:53
 */
@Configuration
open class RedisConfig{

    @Autowired
    lateinit var redisProperties: RedisProperties

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
        val stringRedisSerializer = StringRedisSerializer()
        template.keySerializer = stringRedisSerializer
        template.hashKeySerializer = stringRedisSerializer
        template.valueSerializer = hessianRedisSerializer
        template.hashValueSerializer = hessianRedisSerializer
        template.afterPropertiesSet()
        return template
    }


    /**
     * 哨兵模式自动装配
     *
     * @return redis客户端
     */
    @Bean
    open fun redisClient(): RedissonClient {
        val serverConfig = Config().apply {
            this.useSingleServer()
                    .setAddress("redis://${redisProperties.host}:${redisProperties.port}").timeout = redisProperties.timeout
        }
        return Redisson.create(serverConfig)
    }
}