
package kyungseo.poc.todo.jsp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String showWelcomePage(final HttpServletRequest request, final ModelMap model) {
        model.addAttribute("userName", "kyungseo");
        return "welcome";
    }

}
