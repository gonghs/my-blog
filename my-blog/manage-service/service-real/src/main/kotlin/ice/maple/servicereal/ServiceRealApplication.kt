package ice.maple.servicereal

import ice.maple.servicereal.config.RedisProperties
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableCaching
@EnableConfigurationProperties(RedisProperties::class)
open class ServiceRealApplication

fun main(args:Array<String>){
    SpringApplication.run(ServiceRealApplication::class.java,*args)
}