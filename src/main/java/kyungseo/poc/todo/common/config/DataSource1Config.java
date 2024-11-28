package kyungseo.poc.todo.common.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSource1Config {

    // 데이터 소스 빈 정의
    @Bean(name = "ds1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource dataSource() {
        return org.springframework.boot.jdbc.DataSourceBuilder.create().build();
    }

    // 트랜잭션 매니저 빈 정의
    @Bean(name = "ds1TransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("ds1DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
