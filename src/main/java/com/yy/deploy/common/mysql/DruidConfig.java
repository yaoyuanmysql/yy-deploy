//package com.yy.deploy.common.mysql;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import com.alibaba.druid.wall.WallConfig;
//import com.alibaba.druid.wall.WallFilter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.sql.DataSource;
//
///**
// * druid数据源配置类
// *
// * @author yuanyao@wistronits.com
// * create on 2019-07-24 15:42
// */
//@Configuration
//public class DruidConfig {
//
//
//    /**
//     * 将所有前缀为spring.datasource下的配置项都加载到DataSource中
//     *
//     * @return druid数据源
//     */
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Bean
//    public DataSource druidDataSource() {
//        return new DruidDataSource();
//    }
//
//    /**
//     * 新增过滤器
//     */
//    @Bean
//    public WallFilter wallFilter(){
//        WallFilter wallFilter = new WallFilter();
//        wallFilter.setConfig(wallConfig());
//        return wallFilter;
//    }
//
//    /**
//     * 新增执行多条语句配置
//     * @return
//     */
//    @Bean
//    public WallConfig wallConfig(){
//        WallConfig wallConfig = new WallConfig();
//        //允许一次执行多条语句
//        wallConfig.setMultiStatementAllow(true);
//        //允许一次执行多条语句
//        wallConfig.setNoneBaseStatementAllow(true);
//        return wallConfig;
//    }
//
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//        // 添加IP白名单
//        servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
//        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
//        servletRegistrationBean.addInitParameter("deny", "127.0.0.1");
//        // 添加控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        // 是否能够重置数据
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//    }
//
//    /**
//     * 配置服务过滤器
//     *
//     * @return 返回过滤器配置对象
//     */
//    @Bean
//    public FilterRegistrationBean statFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
//        // 添加过滤规则
//        filterRegistrationBean.addUrlPatterns("/*");
//        // 忽略过滤格式
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,");
//        return filterRegistrationBean;
//    }
//
//
//}
