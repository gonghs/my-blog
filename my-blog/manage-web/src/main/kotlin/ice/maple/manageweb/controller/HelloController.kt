package ice.maple.manageweb.controller

import ice.maple.manageservice.service.IHelloService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController{
    @Autowired
    private var helloService:IHelloService? = null

    @GetMapping("/hello")
    fun hello():String{
        return helloService!!.hello()
    }

    @GetMapping("hello1")
    fun hello(text:String):String{
        return helloService!!.hello(text)
    }
}