
package kyungseo.poc.todo.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.google.common.collect.ImmutableMap;
import com.zaxxer.hikari.HikariConfig;


public abstract class DatabaseConfig extends HikariConfig {

    public static final String DATASOURCE1_NAME          = "ds1";
    public static final String REPOSITORY_PACKAGE_PREFIX = "kyungseo.poc.todo.**.repository";
    public static final String ENTITY_PACKAGE_PREFIX     = "kyungseo.poc.todo.**.entity";

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String hibernateDialect;

    // 주의! Production 환경인 경우 무조건 'none' 값으로 설정할 것!
    @Value("${spring.jpa.properties.hibernate.hbm2ddl.auto}")
    private String hibernateDdlAuto;

    @Value("${spring.jpa.properties.hibernate.format_sql}")
    private String hibernateFormatSql;

    @Value("${spring.jpa.show-sql}")
    private String showSql;

    protected void setConfigureEntityManagerFactory(LocalContainerEntityManagerFactoryBean factory) {
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaPropertyMap(ImmutableMap.of(
                "hibernate.hbm2ddl.auto", hibernateDdlAuto,
                "hibernate.dialect", hibernateDialect,
                "hibernate.show_sql", showSql,
                "hibernate.format_sql", hibernateFormatSql
        ));
        factory.afterPropertiesSet();
    }

}