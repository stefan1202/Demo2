package ro.sda.java64.demo2.components;

import org.springframework.stereotype.Component;

@Component(value = "Dorel")
public class TypeBBond implements BondInterface{
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
