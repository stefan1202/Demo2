package ro.sda.java64.demo2.components;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TypeABond implements BondInterface{
    public TypeABond() {
        System.out.println("Constructig " + this.getClass().getName() );
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
