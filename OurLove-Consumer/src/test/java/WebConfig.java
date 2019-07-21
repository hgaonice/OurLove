/*
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

*/
/**
 * @Author: GH
 * @Date: 2019/7/16 2:24
 * @Version 1.0
 *//*

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    */
/**
     * 解决跨域请求
     * @param registry
     *//*

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        */
/*registry.addMapping("/demo/**").allowedOrigins("http://domain2.com")
                .allowedMethods("PUT", "DELETE")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);*//*

//        registry.addMapping("/**");
    }

    */
/**
     * 解决 swagger-ui无法显示问题
     * https://www.jianshu.com/p/840320d431a1
     * @param registry
     *//*

   */
/* @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }*//*

}*/
