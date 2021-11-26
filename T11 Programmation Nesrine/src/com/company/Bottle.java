package com.company;

/**
 * La classe Bottle permet de representer des bouteille d'eau
 */
public class Bottle {


    // Nom de la bouteille
    private String name;
    //capacity global de la bouteille
    private int globalCapacity;
    //Capacié utilisé de la bouteille
    private int usedCapacity;

    /**
     * Constructeur de la classe Bottle
     * @param name
     * @param capacity
     */
    public Bottle(String name, int capacity){
        this.name=name;
        this.globalCapacity=capacity;
        this.usedCapacity=0;
    }

    /**
     * getter de la propriété capacity
     * @return
     */
    public int getCapacity() {
        return globalCapacity;
    }

    /**
     * getter de la propriété name
     * @return
     */
    public String getName() {
        return name;
    }

    public int getUsedCapacity(){
        return this.usedCapacity;
    }

    /**
     * La méthode isFilled() permet de savoir si la bouteille est vide ou elle est remplie
     * @return
     */
    public boolean isFilled() {
        if (globalCapacity == usedCapacity) {
            return true;
        } else {
            return false;
        }

    }

    public boolean isEmpty(){
        if (usedCapacity==0){
            return true;
        }
        else {
            return false;
        }
    }

    public void setUsedCapacity(int usedCapacity){
        this.usedCapacity = usedCapacity;
    }

    /**
     * La méthode remainCapacity retourne la capacity disponible dans une bouteille
     * @return
     */
    public int remainingCapacity(){
        int remainingCapacity = this.globalCapacity-this.usedCapacity;
        return remainingCapacity;
    }

    /**
     * La méthode upload() permet de verser le contenu d'une bouteille dans une autre, tant l'autre de soit pas
     * remplie et que l'autre ne soit pas vide
     * @param bottle1
     */
    public void upload(Bottle bottle1){
        if (isEmpty()==false){
            while (isEmpty()==false && bottle1.isFilled()==false){
                this.usedCapacity -= 1;
                bottle1.usedCapacity +=1;
            }
        }
    }


    public String toString(){
        return name + ":" + usedCapacity + "/" + globalCapacity;
    }


}
