package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

       Bottle bottle1 = new Bottle("b1",5);
       Bottle bottle2 = new Bottle("b2",3);
       ArrayList<Bottle> bottles = new ArrayList<>();
       bottles.add(bottle1);
       bottles.add(bottle2);
       Map<Bottle, Integer> contraints = new HashMap<>();
       contraints.put(bottle1,4);

       Solver solver = new Solver(bottles);
       Move solution = solver.solve(contraints);
       if (solution == null){
           System.out.println("No solution");
       }else {
           solution.display();
       }




    }
}
