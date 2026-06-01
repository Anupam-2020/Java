package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        Car car = applicationContext.getBean(Car.class); // with the help of applicationContext car's object is given by bean.xml.
        car.drive();
    }
}
