package ro.sda.java64.demo2.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClassA implements CommandLineRunner {

    private ClassB classB;

    public ClassA(ClassB classB) {
        this.classB = classB;
        System.out.println("Construiesc clasa A cu parametru");
    }

//    public ClassA() {
//        System.out.println("Construiesc obiectul ClassA");
//    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sunt in run in ClassA");
    }
}
