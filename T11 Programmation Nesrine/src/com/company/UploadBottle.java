package com.company;

public class UploadBottle implements Move{

    private Bottle bottle1;
    private Bottle bottle2;

    public UploadBottle(Bottle bottle1, Bottle bottle2){
        this.bottle1 = bottle1;
        this.bottle2 = bottle2;
    }

    @Override
    public void apply() {
        bottle1.upload(bottle2);
    }

    @Override
    public void display() {
        System.out.println("upload bottle " + bottle1.getName() + " into " + bottle2.getName());
    }
}
