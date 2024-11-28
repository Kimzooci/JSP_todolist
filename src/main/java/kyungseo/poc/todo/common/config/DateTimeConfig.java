
package kyungseo.poc.todo.common.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.Formatter;

import kyungseo.poc.todo.common.AppConstants;


@Configuration
public abstract class DateTimeConfig {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Bean
    public Formatter<LocalDate> localDateFormatter() {
        return new Formatter<LocalDate>() {
            @Override
            public LocalDate parse(String text, Locale locale) {
                LOGGER.debug(text);
                return LocalDate.parse(text, DateTimeFormatter.ofPattern(AppConstants.DATE_FORMAT, locale));
            }

            @Override
            public String print(LocalDate object, Locale locale) {
                LOGGER.debug(object.toString());
                return DateTimeFormatter.ISO_DATE.format(object);
            }
        };
    }

    @Bean
    public Formatter<LocalDateTime> localDateTimeFormatter() {
        return new Formatter<LocalDateTime>() {
            @Override
            public LocalDateTime parse(String text, Locale locale) {
                LOGGER.debug(text);
                return LocalDateTime.parse(text, DateTimeFormatter.ofPattern(AppConstants.DATETIME_FORMAT, locale));
            }

            @Override
            public String print(LocalDateTime object, Locale locale) {
                LOGGER.debug(object.toString());
                return DateTimeFormatter.ISO_DATE_TIME.format(object);
            }
        };
    }

    @Bean
    public Formatter<Date> DateFormatter() {
        return new Formatter<Date>() {
            @Override
            public Date parse(String text, Locale locale) throws ParseException {
                LOGGER.debug(text);
                SimpleDateFormat dt = new SimpleDateFormat(AppConstants.DATETIME_FORMAT, locale);
                return dt.parse(text);
            }

            @Override
            public String print(Date object, Locale locale) {
                LOGGER.debug(object.toString());
                return new SimpleDateFormat(AppConstants.DATETIME_FORMAT).format(object);
            }
        };
    }

}

