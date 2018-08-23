package ice.maple.manageweb.proxy

import ice.maple.utils.SerializeUtils
import org.apache.commons.logging.LogFactory
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import org.springframework.web.client.RestTemplate
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method

open class RemoteServiceInvokeHandler : InvocationHandler {
    protected val log = LogFactory.getLog(this.javaClass)
    private var portType: Class<*>? = null
    private var restTemplate: RestTemplate? = null
    private var application: String? = null

    constructor(portType: Class<*>, restTemplate: RestTemplate, appId: String) {
        this.portType = portType
        this.restTemplate = restTemplate
        this.application = appId
    }

    private fun getRemoteUrl(): String {
        return "http://$application/localInvoke"
    }

    override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any? {
        if ("toString" == method!!.name) {
            return proxy.toString()
        }
        val obj = HashMap<String,Any?>()
        obj["class"] = portType!!.name
        obj["method"] = method.name
        obj["args"] = args
        obj["paramTypes"] = method.parameterTypes
        val postData = SerializeUtils.hessianSerialize(obj)
        val resp = restTemplate!!.exchange(getRemoteUrl(),HttpMethod.POST, HttpEntity(postData),ByteArray::class.java)
        if (resp.statusCode != HttpStatus.OK) throw Exception("调用${getRemoteUrl()}返回非正常状态${resp.statusCodeValue}")
        val result = SerializeUtils.hessianDeserialize(resp.body) as Map<*, *>
        return if (!(result["success"] as Boolean)) throw Exception(result["error"] as String)
        else result["data"]
    }

}