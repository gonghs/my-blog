package ice.maple.manageservice.service.impl

import ice.maple.manageservice.service.IHelloService

class HelloService:IHelloService{
    override fun hello():String {
        return "hello world"
    }
}