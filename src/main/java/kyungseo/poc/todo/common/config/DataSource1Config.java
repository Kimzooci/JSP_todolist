
 package kyungseo.poc.todo.common.config;

 import javax.persistence.EntityManagerFactory;
 import javax.sql.DataSource;
 
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Qualifier;
 import org.springframework.boot.context.properties.ConfigurationProperties;
 import org.springframework.boot.jdbc.DataSourceBuilder;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.context.annotation.Primary;
 import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
 import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
 import org.springframework.orm.jpa.JpaTransactionManager;
 import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
 import org.springframework.transaction.PlatformTransactionManager;
 import org.springframework.transaction.annotation.EnableTransactionManagement;
 
 @Configuration
 @EnableTransactionManagement
 @EnableJpaRepositories(
         entityManagerFactoryRef = "ds1EntityManagerFactory",
         transactionManagerRef = "ds1TransactionManager",
         basePackages = { "kyungseo.poc.todo.repository" } // 실제 repository 패키지 경로로 수정하세요.
 )
 public class DataSource1Config {
 
     private static final Logger LOGGER = LoggerFactory.getLogger(DataSource1Config.class);
 
     private static final String[] ENTITY_PACKAGES_TO_SCAN = { "kyungseo.poc.todo.entity" }; // 엔티티 경로 수정 필요.
 
     @Bean(name = "ds1DataSource")
     @ConfigurationProperties(prefix = "custom.datasource.ds1")
     public DataSource ds1DataSource() {
         LOGGER.info("Configuring DataSource: ds1DataSource");
         return new LazyConnectionDataSourceProxy(DataSourceBuilder.create().build());
     }
 
     @Bean(name = "ds1EntityManagerFactory")
     @Primary
     public EntityManagerFactory ds1EntityManagerFactory(
             @Qualifier("ds1DataSource") DataSource dataSource) {
         LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
         em.setDataSource(dataSource);
         em.setPackagesToScan(ENTITY_PACKAGES_TO_SCAN);
         em.setPersistenceUnitName("ds1PersistenceUnit");
 
         // JPA 속성 추가 (필요한 경우 설정)
         em.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "create");
         em.getJpaPropertyMap().put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
 
         em.afterPropertiesSet();
         return em.getObject();
     }
 
     @Bean(name = "ds1TransactionManager")
     @Primary
     public PlatformTransactionManager ds1TransactionManager(
             @Qualifier("ds1EntityManagerFactory") EntityManagerFactory entityManagerFactory) {
         return new JpaTransactionManager(entityManagerFactory);
     }
 
     @Bean
     public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
         return new PersistenceExceptionTranslationPostProcessor();
     }
 }
 