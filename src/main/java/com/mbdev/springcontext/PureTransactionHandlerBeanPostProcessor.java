package com.mbdev.springcontext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class PureTransactionHandlerBeanPostProcessor implements BeanPostProcessor {

    private Map<String, Class<?>> beanMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if(beanClass.isAnnotationPresent(PureTransactional.class)) {
            beanMap.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> beanClass = beanMap.get(beanName);
        if(beanClass != null ){
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("Opening Transaction");
                    long before = System.nanoTime();
                    Object result = method.invoke(bean, args);
                    long after = System.nanoTime();
                    System.out.println((after-before) / 1000);
                    System.out.println("Close Transaction");
                    return result;
                }
            });
        }
        return bean;
    }
}
