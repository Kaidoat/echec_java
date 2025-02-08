package Piece;

public class Cavalier extends Piece {
  public Cavalier(Couleur couleur, int x, int y) {
    super(couleur, x, y);
  }

  @Override
  public boolean mouvementValide(int newX, int newY, Echequier echiquier) {
    return (Math.abs(newX - x) == 2 && Math.abs(newY - y) == 1) ||
      (Math.abs(newX - x) == 1 && Math.abs(newY - y) == 2);
  }
}
