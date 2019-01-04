package ice.maple.servicereal.dao

import ice.maple.manageservice.bo.SysPermission
import ice.maple.manageservice.bo.SysRole
import ice.maple.manageservice.bo.SysUser
import org.apache.commons.logging.LogFactory
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository


/**
 * 用户权限实现类
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 14:25
 */

@Component
open class UserDao{
    private var log = LogFactory.getLog(this.javaClass)
    private val admin:SysRole = SysRole("admin","管理员")
    private val developer:SysRole = SysRole("developer","开发者")

    init{
        developer.permissions = Array(4) {i
            -> SysPermission("userIndex$i","个人中心$i","/user$i/index.html") }
        admin.permissions = Array(4) {i
            -> SysPermission("userIndex$i","个人中心$i","/user$i/index.html") }
    }

    fun queryByName(userName:String):SysUser?{
        log.info("搜索用户")
        return when(userName){
            "merry" -> SysUser("merry","玛丽","\$2a\$06\$HAuVMEJ.Kb4BH3bT4XtzZOz0tbBM7HZYIfEp/EdsygqEdbPkY6zka").apply {
                this.roles = Array(1){_ -> admin}
            }
            "maple" -> SysUser("maple","枫","\$2a\$06\$HAuVMEJ.Kb4BH3bT4XtzZOz0tbBM7HZYIfEp/EdsygqEdbPkY6zka").apply {
                this.roles = Array(1){_ -> developer}
            }
            else -> null
        }
    }
}

fun main(args: Array<String>) {
    val username:String? = "maple"
    val name:String = username!!.toString()
    var sysUser:SysUser? = UserDao().queryByName(name)
    println(sysUser)
}