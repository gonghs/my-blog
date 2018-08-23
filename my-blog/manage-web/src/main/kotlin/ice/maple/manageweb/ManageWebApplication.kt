package ice.maple.manageweb

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
open class ManageWebApplication

fun main(args: Array<String>) {
    SpringApplication.run(ManageWebApplication::class.java, *args)
}