package kyungseo.poc.todo.jsp.web.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import kyungseo.poc.todo.common.AppConstants;
import kyungseo.poc.todo.common.util.MessageSourceUtil;

@Controller
public class ErrorPageController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final MessageSourceUtil messageSource;

    // 생성자 추가
    public ErrorPageController(MessageSourceUtil messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping("/common/error/{code}")
    public String error(final Model model, @PathVariable(required = false) final String code) {
        LOGGER.info(">> ErrorPageController > 에러 발생!");

        model.addAttribute("title",
                this.messageSource.getMessage("error.page.title"));
        model.addAttribute("description",
                this.messageSource.getMessage("error.page.desc." + Optional.ofNullable(code).orElseGet(() -> "500")));
        // model.addAttribute("url", request.getRequestURL());

        return AppConstants.ERROR_VIEW_NAME;
    }
}
