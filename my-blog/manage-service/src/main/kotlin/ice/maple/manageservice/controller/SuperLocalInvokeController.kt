package ice.maple.manageservice.controller

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware

abstract class SuperLocalInvokeController:ApplicationContextAware{
    private val applicationContext:ApplicationContext? = null

    /**
     * 供服务间调用开放的api
     */
}