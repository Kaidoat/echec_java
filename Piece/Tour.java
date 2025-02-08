package Piece;

public class Tour extends Piece {
  public Tour(Couleur couleur, int x, int y) {
    super(couleur, x, y);
  }

  @Override
  public boolean mouvementValide(int newX, int newY, Echequier echiquier) {
    return x == newX || y == newY;
  }
}
