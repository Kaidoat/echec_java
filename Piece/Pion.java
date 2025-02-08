package Piece;

public class Pion extends Piece {
  public Pion(Couleur couleur, int x, int y) {
    super(couleur, x, y);
  }

  @Override
  public boolean mouvementValide(int newX, int newY, Echequier echiquier) {
    int direction = (couleur == Couleur.BLANC) ? -1 : 1;
    return newX == x && newY == y + direction;
  }
}
