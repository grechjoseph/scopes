package com.jg.scopes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopesConfiguration {

    /**
     * By default, a bean is of scope SINGLETON. This means that only one instance of the Bean is created throughout the
     * whole runtime. Whenever a bean of the same type is request, the same instance is always returned.
     */
    @Bean
    @Qualifier("defaultBean")
    public ScopeObject defaultBean() {
        log.info("***** Creating defaultBean.");
        return ScopeObject.builder().build();
    }

    /**
     * Scope SINGLETON means that only one instance of the Bean is created throughout the
     * whole runtime. Whenever a bean of the same type is request, the same instance is always returned.
     */
    @Bean
    @Scope("singleton")
    @Qualifier("singletonBean")
    public ScopeObject singletonBean() {
        log.info("***** Creating singletonBean.");
        return ScopeObject.builder().build();
    }

    /**
     * A Scope PROTOTYPE bean creates a new instance each time a reference to the Bean is made.
     */
    @Bean
    @Scope("prototype")
    @Qualifier("prototypeBean")
    public ScopeObject prototypeBean() {
        log.info("***** Creating prototypeBean.");
        return ScopeObject.builder().build();
    }

    /**
     * A Scope "refresh" or @RefreshScope bean is re-initialized whenever /actuator/refresh is called
     * (requires Spring Cloud and Spring Actuator to work).
     */
    @Bean
    @RefreshScope
    @Qualifier("refreshBean")
    public ScopeObject refreshBean() {
        log.info("***** Creating refreshBean.");
        return ScopeObject.builder().build();
    }

}
