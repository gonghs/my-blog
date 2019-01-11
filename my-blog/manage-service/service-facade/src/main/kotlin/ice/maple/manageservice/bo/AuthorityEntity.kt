package ice.maple.manageservice.bo

/**
 * 存储权限相关的数据库实体
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-11 16:29
 */
data class User(var userId:String,var password:String,var username:String,var test:String?){

    var id:Long = 0
    constructor(id:Long, userId:String, username:String, password:String,test:String?) : this(userId,username,password,test){
        this.id = id
    }
}