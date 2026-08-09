package com.anupam.SpringBeanLifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class BeanLifecycleClass implements BeanNameAware, InitializingBean, DisposableBean, BeanPostProcessor {
    public BeanLifecycleClass() {
        System.out.println("1. Constructor: Bean Initialized.");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("2. BeanNameAware: Bean registered under the name: " + name);
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("3. @PostConstruct: Preparing class drivers.");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("4. InitializingBean: Initializing a specific connection pool size.");
    }

    public void customInit() {
        System.out.println("5. Custom Init Method: Executing final configuration checks.");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("6. @PreDestroy: Closing all active connection streams.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("7. DisposableBean: Disposing the parent connection pool instance.");
    }

    public void customDestroy() {
        System.out.println("8. Custom Destroy Method: Releasing residual memory handles.");
    }
}
