package ice.maple.manageweb.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

/**
 * TODO
 *
 * @author maple
 * @version V1.0
 * @since 2019-01-02 16:27
 */
@Controller
class LoginController{

    @GetMapping("/login")
    fun login():String{
        return "login.html"
    }

    @GetMapping("/login-error")
    fun loginError(model:Model):String{
        model.addAttribute("loginError",true)
        return "login.html"
    }
}