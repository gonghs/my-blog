package ice.maple.manageservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class ManageServiceApplication

fun main(args:Array<String>){
    SpringApplication.run(ManageServiceApplication::class.java,*args)
}