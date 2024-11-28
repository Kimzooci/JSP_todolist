
package kyungseo.poc.todo.common.config;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggerAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Pointcut("execution(* kyungseo.poc.todo..*Service.*(..))" +
	      " or execution(* kyungseo.poc.todo..*Repository.*(..))" +
	      " or execution(* kyungseo.poc.todo..*Mapper.*(..))")
	public void loggingPointcut() {}

	@Before("loggingPointcut()")
	public void beforeLogging(final JoinPoint joinPoint) {
	    LOGGER.debug("Before: {}", joinPoint);
		if (ArrayUtils.isNotEmpty(joinPoint.getArgs())) {
		    LOGGER.debug("Arguments: {}",
					Arrays.stream(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(",")));
		}
	}

	@AfterReturning(pointcut = "loggingPointcut()", returning = "result")
	public void returnLogging(final JoinPoint joinPoint, @Nullable final Object result) {
	    LOGGER.debug("Completed: {}", joinPoint);
		if (result != null) {
		    LOGGER.debug("Result: {}", result.toString());
		}
	}

}
