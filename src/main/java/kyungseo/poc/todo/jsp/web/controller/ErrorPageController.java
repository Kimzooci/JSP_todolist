package kyungseo.poc.todo.jsp.web.controller;

import kyungseo.poc.todo.common.util.MessageSourceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {

    private final MessageSourceUtil messageSourceUtil;

    public ErrorPageController(MessageSourceUtil messageSourceUtil) {
        this.messageSourceUtil = messageSourceUtil;
    }

    @RequestMapping("/error")
    public String handleError() {
        String errorMessage = messageSourceUtil.getMessage("error.page.notfound");
        System.out.println("Error Message: " + errorMessage);
        return "error";
    }
}
