package ice.maple.servicereal

import ice.maple.servicereal.dao.UserDao
import org.junit.Test
import org.slf4j.LoggerFactory
import javax.inject.Inject


class ServiceRealApplicationTests :BaseTest(){
    private val log = LoggerFactory.getLogger(this.javaClass)
    @Inject
    lateinit var userDao: UserDao


    @Test
    fun contextLoads() {

    }

    @Test
    fun userDaoTest(){
        userDao.queryByName("maple")
    }
}