package kyungseo.poc.todo.common.util;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;


@Component
public class MessageSourceUtil {

    private final MessageSource messageSource;

    // Spring 의존성 주입을 위한 생성자
    public MessageSourceUtil(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(String code, Object... args) {
        return this.messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
