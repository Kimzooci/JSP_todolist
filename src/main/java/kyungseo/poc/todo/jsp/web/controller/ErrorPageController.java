package kyungseo.poc.todo.jsp.web.controller;

import kyungseo.poc.todo.common.util.MessageSourceUtil;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController {

    private final MessageSourceUtil messageSourceUtil;

    // @Lazy를 필드에 적용
    public ErrorPageController(@Lazy MessageSourceUtil messageSourceUtil) {
        this.messageSourceUtil = messageSourceUtil;
    }

    @RequestMapping("/error")
    public String handleError() {
        String errorMessage = messageSourceUtil.getMessage("error.page.notfound");
        System.out.println("Error Message: " + errorMessage);
        return "error";
    }
}
