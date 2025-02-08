package Piece;

public class Roi extends Piece{

  public Roi (Couleur couleur, int x, int y){
    super(couleur, x, y);
  }
  @Override
  public boolean mouvementValide(int newX, int newY, Echequier Echequier) {
    return Math.abs(newX - x )<= 1 && Math.abs (newY - y)<=1 ;
  }
}
