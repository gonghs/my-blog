package ice.maple.servicereal

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
open class ServiceRealApplication

fun main(args:Array<String>){
    SpringApplication.run(ServiceRealApplication::class.java,*args)
}