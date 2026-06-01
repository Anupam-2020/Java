package org.example;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // applicationContext (IOC Container) => follows eager initialization (meaning => Object is created immediately at startup, then only it calls the beans.xml file classes).
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
      Car car = applicationContext.getBean(Car.class);
      car.drive(); // Note:- constructor injection happens during object creation. And setter injection happens after object creation.

//      beanfactory (IOC Container) => follows lazy initialization (meaning => beanFactory creates object of beans.xml classes only when required or when we ask for getBean().
//      BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));
//      Car car = beanFactory.getBean(Car.class);
//      car.drive();
    }
}
