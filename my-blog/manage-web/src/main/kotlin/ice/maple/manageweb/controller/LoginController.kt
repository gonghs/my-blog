package ice.maple.manageweb.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-02 16:27
 */
@Controller
class LoginController{

    @RequestMapping(value= ["/"])
    fun home(): String{
        return "home"
    }

    @RequestMapping(value= ["/user"])
    fun welcome(): String{
        return "user"
    }

    @RequestMapping(value= ["/admin"])
    fun admin(): String{
        return "admin"
    }

    @RequestMapping(value= ["/login"])
    fun login(): String{
        return "login"
    }


    @RequestMapping(value= ["/403"])
    fun error403(): String{
        return "403"
    }
}