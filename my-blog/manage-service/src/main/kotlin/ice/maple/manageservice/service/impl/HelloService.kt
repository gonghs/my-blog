package ice.maple.manageservice.service.impl

import ice.maple.manageservice.service.IHelloService
import org.springframework.stereotype.Service

@Service
class HelloService:IHelloService{
    override fun hello():String {
        return "hello world"
    }

    override fun hello(text: String): String {
        return text
    }
}