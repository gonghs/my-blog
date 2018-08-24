package ice.maple.manageweb

import ice.maple.manageservice.service.IHelloService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ManageWebApplicationTests {
    @Autowired
    private var helloService: IHelloService? = null

    @Test
    fun contextLoads() {
        val a = helloService!!.hello()
        println(a)
    }

}