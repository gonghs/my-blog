package ice.maple.manageservice

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ManageServiceApplicationTests {
    @Value("\${info.name}")
    private val name:String? = null
    @Value("\${info.sex}")
    private val sex:String? = null
    @Test
    fun contextLoads() {
        println(name)
        println(sex)
    }

}