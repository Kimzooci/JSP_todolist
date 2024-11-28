package kyungseo.poc.todo.common.config;

import kyungseo.poc.todo.common.util.MessageSourceUtil;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {

    private final MessageSource messageSource;

    public MessageConfig(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Bean(name = "customMessageSourceUtil") // 빈 이름 변경
    public MessageSourceUtil customMessageSourceUtil() {
        return new MessageSourceUtil(messageSource);
    }

    
}
