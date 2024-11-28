
package kyungseo.poc.todo.common.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = { "classpath:application.properties" }, ignoreResourceNotFound = false)
public class EnvironmentAwareConfig implements EnvironmentAware {

    private static Environment env;

    @Override
    public void setEnvironment(final Environment env) {
        EnvironmentAwareConfig.env = env;
    }

    public static String getProperty(String key) {
        return env.getProperty(key);
    }

}
