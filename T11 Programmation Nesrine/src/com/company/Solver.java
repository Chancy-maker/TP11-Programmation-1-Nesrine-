package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solver {
    private ArrayList<Bottle> listBottle;

    public Solver(ArrayList<Bottle> listBottle){
     this.listBottle = listBottle;
    }

    public boolean satisfies(Map<Bottle, Integer> contrains){
        for (Map.Entry<Bottle, Integer> contrain : contrains.entrySet()){
            if (contrain.getKey().getUsedCapacity() != contrain.getValue()){
                return false;
            }
        }
        return true;
    }

   public List<Move> possibleMoves() {
        List<Move> moves = new ArrayList<>();
        for(Bottle bottle: listBottle){
            if (!bottle.isEmpty()){
                moves.add(new EmptyBottle(bottle));
            }
            if (!bottle.isFilled()){
                moves.add(new FillBottle(bottle));
            }
        }
        for (Bottle source : listBottle){
            for (Bottle sink : listBottle){
                if (source.isEmpty() || sink.isFilled() || source==sink){
                    continue;
                }
                moves.add(new UploadBottle(source,sink));
            }
        }
        return moves;
   }

   public void reset(){
        for (Bottle bottle : listBottle){
            bottle.setUsedCapacity(0);
        }
   }

   public Move solve(Map<Bottle, Integer> contraints){
        for (Move move : this.possibleMoves()){
            this.reset();
            move.apply();
            if (this.satisfies(contraints)){
                return move;
            }
        }
        this.reset();
        return null;
    }



}
