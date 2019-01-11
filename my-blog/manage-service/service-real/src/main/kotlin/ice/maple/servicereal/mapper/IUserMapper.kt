package ice.maple.servicereal.mapper

import ice.maple.manageservice.bo.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

/**
 * 用户mybatis映射
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-11 16:27
 */

@Mapper
interface IUserMapper{

    @Select("select user_id userId,username,password,test -> \"\$.name\" from user")
    fun getUsers():Array<User>

    @Select("select * from user")
    fun getUsers1():Array<User>
}