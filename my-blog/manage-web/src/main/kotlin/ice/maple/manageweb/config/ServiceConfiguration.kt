package ice.maple.manageweb.config

import ice.maple.manageservice.service.IHelloService
import ice.maple.manageservice.service.IUserService
import ice.maple.manageweb.proxy.RemoteProxyFactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.core.Ordered
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
open class ServiceConfiguration : WebMvcConfigurer {
    @Autowired
    private val proxy: RemoteProxyFactoryBean? = null

    @Bean
    open fun helloServiceBean(): IHelloService {
        return proxy!!.getProxy(IHelloService::class.java, null)
    }

    @Bean
    open fun userServiceBean(): IUserService {
        return proxy!!.getProxy(IUserService::class.java, null)
    }

    @Bean
    @LoadBalanced
    open fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {
        registry.addViewController("/").setViewName("forward:/index")
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE)
    }
}