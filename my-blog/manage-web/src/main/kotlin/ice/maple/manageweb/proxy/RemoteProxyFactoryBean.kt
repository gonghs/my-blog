package ice.maple.manageweb.proxy

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.lang.reflect.Proxy
import java.util.HashMap

@Component
class RemoteProxyFactoryBean : ApplicationContextAware {
    @Autowired
    private val restTemplate: RestTemplate? = null
    private var applicationContext: ApplicationContext? = null
    @Value("\${webConfig.defaultServiceInstanceId}")
    private val defaultServiceInstanceId: String? = null
    //缓存已建立的代理对象
    private val proxies = HashMap<Class<*>, Any>()

    @SuppressWarnings("UNCHECKED_CAST")
    fun <T> getProxy(intelClass: Class<T>, appId: String?): T {
        if (proxies.containsKey(intelClass)) {
            return proxies[intelClass] as T
        }
        defaultServiceInstanceId ?: throw Exception("未设置defaultServiceInstanceId配置参数")
        //先从本地获取
        return try {
            val target = applicationContext!!.getBean(intelClass)
            target as T
        } catch (e: Exception) {
            val handler = RemoteServiceInvokeHandler(intelClass, restTemplate!!, appId ?: defaultServiceInstanceId)
            val proxy = Proxy.newProxyInstance(intelClass.classLoader, arrayOf<Class<*>>(intelClass), handler)
            proxies[intelClass] = proxy
            proxy as T
        }

    }


    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }

}