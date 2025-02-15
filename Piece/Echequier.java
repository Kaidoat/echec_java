package Piece;

import java.util.HashMap;
import java.util.Map;

public class Echequier {
  private final int MAX_CASE=8;
  private Map<String, Piece> plateau = new HashMap<>();



  public Echequier(){
    initialiserEchequier();
  }

  private void initialiserEchequier(){

    for (int i = 0; i< MAX_CASE; i++){
      plateau.put(getKey(i, 1), new Pion(Couleur.BLANC,i,1));
      plateau.put(getKey(i, 6), new Pion(Couleur.NOIR,i,6));

    }
    plateau.put(getKey(4, 0), new Roi(Couleur.BLANC,4,0));
    plateau.put(getKey(4, 7), new Roi(Couleur.NOIR,4,7));
    plateau.put(getKey(3, 0), new Reine(Couleur.BLANC,3,0));
    plateau.put(getKey(3, 7), new Reine(Couleur.NOIR,3,7));

    // TOUR
    plateau.put(getKey(0, 7), new Tour(Couleur.NOIR,0,7));
    plateau.put(getKey(7, 7), new Tour(Couleur.NOIR,7,7));

    plateau.put(getKey(0, 0), new Tour(Couleur.BLANC,0,0));
    plateau.put(getKey(7, 0), new Tour(Couleur.BLANC,7,0));

    // Cavalier
    plateau.put(getKey(1, 7), new Cavalier(Couleur.NOIR,1,7));
    plateau.put(getKey(6, 7), new Cavalier(Couleur.NOIR,6,7));

    plateau.put(getKey(1, 0), new Cavalier(Couleur.BLANC,1,0));
    plateau.put(getKey(6, 0), new Cavalier(Couleur.BLANC,6,0));

    //fou
    plateau.put(getKey(2, 7), new Fou(Couleur.NOIR,2,7));
    plateau.put(getKey(5, 7), new Fou(Couleur.NOIR,5,7));

    plateau.put(getKey(2, 0), new Fou(Couleur.BLANC,2,0));
    plateau.put(getKey(5, 0), new Fou(Couleur.BLANC,5,0));
  }

  public boolean deplacerPiece(int x, int y, int newX, int newY){
    String key = getKey(x,y);
    String newKey = getKey(newX, newY);

    if(plateau.containsKey(key)){
      Piece piece = plateau.get(key);
      if (piece.mouvementValide(newX, newY, this)){

        plateau.remove(key);
        plateau.put(newKey, piece);
        piece.deplacer(newX,newY);
        return true;

      }
    }
    return false;
  }

  public Piece getPiece(int x, int y){
    return plateau.get(getKey(x,y));

  }
  private String getKey(int x, int y){
    return x + "," + y;
  }

}


