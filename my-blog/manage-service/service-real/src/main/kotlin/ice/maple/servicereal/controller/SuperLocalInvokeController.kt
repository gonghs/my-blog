package ice.maple.servicereal.controller

import ice.maple.utils.SerializeUtils
import org.apache.commons.lang.ArrayUtils
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.web.bind.annotation.PostMapping
import java.io.IOException
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

abstract class SuperLocalInvokeController:ApplicationContextAware{
    private var applicationContext:ApplicationContext? = null
    private val log = LoggerFactory.getLogger("SuperLocalInvokeController")

    /**
     * 供服务间调用开放的api
     */

    @Suppress("UNCHECKED_CAST")
    @PostMapping("/localInvoke")
    fun invoke(req:HttpServletRequest,resp:HttpServletResponse){
        val result = HashMap<String,Any?>()
//        var ctx: RequestContext? = null
        try {
            val obj = SerializeUtils.hessianDeserialize(req.inputStream) as? Map<*, *> ?: throw Exception("请求参数类型不正确")
            //调用本地方法
            val port = Class.forName(obj["class"] as String)
            val types = obj["paramTypes"] as? Array<Class<*>> ?: emptyArray()
            val method = port.getMethod(obj["method"] as String,*types)
            val args = obj["args"] as? Array<Any> ?: emptyArray()
            log.debug("Begin invoke service " + obj["class"] as String
                    + "." + obj["method"] as String + ", args:"
                    + ArrayUtils.toString(args, "[]"))
            val target = applicationContext!!.getBean(port)
            result["data"] = method.invoke(target,*args)
            result["success"] = true
        }catch (e:Exception ){
            result["success"] = false
            result["error"] = e.message
        }finally {
            try {
                SerializeUtils.hessianSerialize(result, resp.outputStream)
            }catch (e: IOException){
                log.error("Response invoke result error", e)
            }
        }
    }

    override fun setApplicationContext(applicationContext: ApplicationContext?) {
        this.applicationContext = applicationContext
    }
}