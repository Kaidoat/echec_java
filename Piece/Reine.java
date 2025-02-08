package Piece;

public class Reine extends Piece{

  public Reine (Couleur couleur, int x, int y){
    super(couleur, x, y);
  }

  public boolean mouvementValide (int newX, int newY, Echequier echequier){
    return (x == newX || y==newY) || (Math.abs(newX - x) ==Math.abs(newY - y));

  }
}
