package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solver {
    /**
     * Liste des bouteilles
     */
    private ArrayList<Bottle> listBottle;


    /**
     * Constructeur de la classe Solver
     * @param listBottle
     */
    public Solver(ArrayList<Bottle> listBottle){
     this.listBottle = listBottle;
    }

    /**
     * La méthode satisfies permet de savoir si les contraintes définie sur certaines bouteille
     * soit respecté.
     * @param contrains
     * @return
     */
    public boolean satisfies(Map<Bottle, Integer> contrains){
        for (Map.Entry<Bottle, Integer> contrain : contrains.entrySet()){
            if (contrain.getKey().getUsedCapacity() != contrain.getValue()){
                return false;
            }
        }
        return true;
    }


    /**
     *La méthode possibleMoves() retourne la liste des mouvements potentiels dans la configuration actuelle :
     *  vider toute bouteille non-vide, remplir toute bouteille toute bouteille non-pleine, transverser depuis
     *  toute bouteille non-vide vers toute bouteille non-pleine.
     * @return
     */
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


    /**
     * La méthode reset vide chauqe bouteille de la liste des bouteilles
     */
   public void reset(){
        for (Bottle bottle : listBottle){
            bottle.setUsedCapacity(0);
        }
   }


    /**
     * La méthode solver permet d'essayer tous les mouvement depuis la configuration initiale.
     * @param contraints
     * @return
     */
   public Move solve(Map<Bottle, Integer> contraints){
        for (Move move : this.possibleMoves()){
            this.reset();
            move.display();
            move.apply();
            if (this.satisfies(contraints)){
                return move;
            }
        }
        this.reset();
        return null;
    }



}
