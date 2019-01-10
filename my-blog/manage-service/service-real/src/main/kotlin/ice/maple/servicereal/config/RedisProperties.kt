package ice.maple.servicereal.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

/**
 * 读取redis配置
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-10 13:58
 */

@ConfigurationProperties(prefix = "spring.redis")
@PropertySource("classpath:/bootstrap.yml")
class RedisProperties{
    lateinit var host:String
    lateinit var port:String
    var timeout:Int = 0
}
//? 怎么使用数据类注入属性
//data class RedisProperties(var host:String,var port:String,var timeout:Int)