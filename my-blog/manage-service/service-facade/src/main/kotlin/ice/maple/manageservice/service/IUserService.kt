package ice.maple.manageservice.service

import ice.maple.manageservice.bo.SysUser

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2018-12-29 11:07
 */
interface IUserService{
    fun getUserByName(name:String):SysUser?
}