package spring_mvc_hibernate.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    // класс - конфигурация для всех Сервлетов (общий или корневой контекст)
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }


    // класс - конфигурация для Сервлета
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{
                WebConfig.class
        };
    }

    // url за который отвечает DispatcherServlet. Если “/”, то за все
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


    // чтобы работали запросы Patch и Delete
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new HiddenHttpMethodFilter()};
    }

}