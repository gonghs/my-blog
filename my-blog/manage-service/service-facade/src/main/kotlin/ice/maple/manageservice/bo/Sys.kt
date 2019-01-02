package ice.maple.manageservice.bo

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 16:27
 */

class SysUser(var code: String, var name: String, var password: String) {
    var roles: Array<SysRole> = emptyArray();
}

class SysRole(var code: String, var name: String) {
    var permissions: Array<SysPermission> = emptyArray();
}

class SysPermission(var code: String, var name: String, var url: String)