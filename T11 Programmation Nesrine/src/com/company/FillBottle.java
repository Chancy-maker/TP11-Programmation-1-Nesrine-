package com.company;

public class FillBottle implements Move{
    private Bottle bottle;

    public FillBottle(Bottle bottle){
        this.bottle = bottle;
    }

    @Override
    public void apply() {
        bottle.setUsedCapacity(bottle.getCapacity());
    }

    @Override
    public void display() {
        System.out.println("Fill Bottle" + this.bottle.getName());
    }
}
