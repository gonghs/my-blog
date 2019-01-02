package ice.maple.servicereal.dao

import ice.maple.manageservice.bo.SysPermission
import ice.maple.manageservice.bo.SysRole
import ice.maple.manageservice.bo.SysUser
import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Repository


/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 14:25
 */

@Slf4j
@Repository
open class UserDao{
    private val log = LoggerFactory.getLogger(this.javaClass)
    private val admin:SysRole = SysRole("admin","管理员")
    private val developer:SysRole = SysRole("developer","开发者")

    init{
        developer.permissions = Array(4) {i
            -> SysPermission("userIndex$i","个人中心$i","/user$i/index.html") }
    }

    fun queryByName(userName:String):SysUser?{
        log.info("搜索用户")
        return when(userName){
            "merry" -> SysUser("merry","玛丽","\$2a\$10\$EIfFrWGINQzP.tmtdLd2hurtowwsIEQaPFR9iffw2uSKCOutHnQEm").apply {
                this.roles = Array(1){_ -> admin}
            }
            "maple" -> SysUser("maple","枫","\$2a\$10\$EIfFrWGINQzP.tmtdLd2hurtowwsIEQaPFR9iffw2uSKCOutHnQEm").apply {
                this.roles = Array(1){_ -> developer}
            }
            else -> null
        }
    }
}