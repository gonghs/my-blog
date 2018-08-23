package ice.maple.manageservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
open class ManageServiceApplication

fun main(args:Array<String>){
    SpringApplication.run(ManageServiceApplication::class.java,*args)
}