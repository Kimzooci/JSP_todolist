
package kyungseo.poc.todo.jsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "kyungseo.poc.todo")
public class TodoApplication extends SpringBootServletInitializer {

    // web container 외부에 배포하는 경우 하단 주석 처리 -->
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TodoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(TodoApplication.class);
    }

}