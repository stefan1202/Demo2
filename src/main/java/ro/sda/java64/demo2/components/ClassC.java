package ro.sda.java64.demo2.components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class ClassC implements CommandLineRunner, ApplicationContextAware {
    private  ClassD classD;
    private BondInterface bondInterface;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Initializing postconstruct " + classD);
        System.out.println("Am luat din context beanul " + bondInterface.getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.classD = applicationContext.getBean(ClassD.class);
        this.bondInterface = (BondInterface) applicationContext.getBean("Dorel");
    }
}
