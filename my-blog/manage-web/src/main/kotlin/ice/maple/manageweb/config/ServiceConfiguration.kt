package ice.maple.manageweb.config

import ice.maple.manageservice.service.IHelloService
import ice.maple.manageweb.proxy.RemoteProxyFactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.cloud.client.loadbalancer.LoadBalanced




@Configuration
open class ServiceConfiguration{
    @Autowired
    private val proxy: RemoteProxyFactoryBean? = null

    @Bean
    open fun userServiceBean(): IHelloService {
        return proxy!!.getProxy(IHelloService::class.java, null)
    }

    @Bean
    @LoadBalanced
    open fun restTemplate(): RestTemplate {
        return RestTemplate()
    }
}