package ice.maple.servicereal.database

import ice.maple.servicereal.BaseTest
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import java.util.*

/**
 * 用户表jdbc测试
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-11 14:06
 */
class UserTest : BaseTest() {
    @Autowired
    private lateinit var jdbcTemplate: JdbcTemplate

    @Test
    fun testQuery() {
        val sql = "select * from user"
        val list = jdbcTemplate.queryForList(sql)
        list.forEach { it.forEach{ println("${it.key}:${it.value}")} }
    }
}