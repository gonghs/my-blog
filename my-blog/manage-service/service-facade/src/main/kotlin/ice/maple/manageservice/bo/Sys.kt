package ice.maple.manageservice.bo

import java.io.Serializable

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 16:27
 */

class SysUser(var code: String, var name: String, var password: String):Serializable {
    var roles: Array<SysRole> = emptyArray();
}

class SysRole(var code: String, var name: String):Serializable {
    var permissions: Array<SysPermission> = emptyArray();
}

class SysPermission(var code: String, var name: String, var url: String):Serializable