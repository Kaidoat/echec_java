package Piece;

public class Fou extends Piece {
  public Fou(Couleur couleur, int x, int y) {
    super(couleur, x, y);
  }

  @Override
  public boolean mouvementValide(int newX, int newY, Echequier echiquier) {
    return Math.abs(newX - x) == Math.abs(newY - y);
  }
}
