package com.company;

public class EmptyBottle implements Move{

    private Bottle bottle;

    public EmptyBottle(Bottle bottle){
        this.bottle=bottle;
    }

    public void display(){
        System.out.println("Empty Bottle" + this.bottle.getName());
    }

    @Override
    public void apply() {
        bottle.setUsedCapacity(0);
    }
}
