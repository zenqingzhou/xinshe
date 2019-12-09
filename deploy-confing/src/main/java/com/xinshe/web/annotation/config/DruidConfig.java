package com.xinshe.web.annotation.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${xinshe.database.url}")
    private String dbUrl;

    @Value("${xinshe.database.user}")
    private String username;

    @Value("${xinshe.database.password}")
    private String password;

    @Value("${xinshe.database.driverClass}")
    private String driverClassName;

    @Value("${xinshe.database.dbIinitialSize}")
    private int initialSize;

    @Value("${xinshe.database.dbMinIdle}")
    private int minIdle;

    @Value("${xinshe.database.dbMaxActive}")
    private int maxActive;

    @Value("${xinshe.database.maxWait}")
    private int maxWait;

    @Value("${xinshe.database.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${xinshe.database.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${xinshe.database.validationQuery}")
    private String validationQuery;

    @Value("${xinshe.database.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${xinshe.database.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${xinshe.database.testOnReturn}")
    private boolean testOnReturn;

    @Value("${xinshe.database.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${xinshe.database.filters}")
    private String filters;

//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean reg = new ServletRegistrationBean();
//        reg.setServlet(new StatViewServlet());
//        reg.addUrlMappings("/druid/*");
//        reg.addInitParameter("loginUsername", "druid");
//        reg.addInitParameter("loginPassword", "jiajian123456");
//        return reg;
//    }
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        filterRegistrationBean.addInitParameter("profileEnable", "true");
//        filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
//        filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");
//        return filterRegistrationBean;
//    }

    @Bean
    public DataSource druidDataSource(){
        DruidDataSource datasource = new DruidDataSource();

        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
//        WallConfig wallConfig = new WallConfig();
//        wallConfig.setDir("META-INF/druid/wall/postgre");
//        WallFilter wallFilter = new WallFilter();
//        wallFilter.setDbType("postgresql");
//        wallFilter.setConfig(wallConfig);
//        try {
//            List<Filter> wallFilters = new ArrayList<>();
//            wallFilters.add(wallFilter);
//            datasource.setProxyFilters(wallFilters);
//            datasource.setFilters(filters);
//        } catch (Exception e) {
//            logger.error("druid configuration initialization filter", e);
//        }
        return datasource;
    }
}
