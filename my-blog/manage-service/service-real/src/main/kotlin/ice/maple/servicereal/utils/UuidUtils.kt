package ice.maple.servicereal.utils

import java.util.*

/**
 * uuid生成
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-11 15:57
 */
object UuidUtils{
    fun genUuid(): String {
        return UUID.randomUUID().toString().replace("-", "")
    }
}