package Piece;

public abstract class Piece{

  protected Couleur couleur;
  protected int x,y;

  public Piece (Couleur couleur, int x, int y){
    this.couleur=couleur;
    this.x = x;
    this.y = y;
  }

  public Couleur getCouleur(){
    return couleur;
  }

  public abstract boolean mouvementValide(int newX,int newY, Echequier Echequier);

  public void deplacer(int newX, int newY){
    this.x = newX;
    this.y = newY;

  }
}
