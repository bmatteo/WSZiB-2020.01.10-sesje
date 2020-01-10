package pl.edu.wszib.controlles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.wszib.SessionObject;
import pl.edu.wszib.model.User;

import javax.annotation.Resource;

@Controller
public class SimpleController {

    @Resource(name = "sessionObject")
    SessionObject sessionObject;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainSite() {
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String authorization(@ModelAttribute User user) {
        if(user.getLogin().equals("admin") && user.getPass().equals("admin")) {
            System.out.println("zalogowano !!");
            this.sessionObject.setUser(user);
            return "redirect:/page";
        }

        return "loginPage";
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String page(Model model) {
        if(this.sessionObject.getUser() == null) {
            return "redirect:/login";
        }

        model.addAttribute("login", this.sessionObject.getUser().getLogin());
        return "page";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        this.sessionObject.setUser(null);
        return "redirect:/login";
    }
}
