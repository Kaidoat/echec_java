package Piece;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import java.util.HashMap;
import java.util.Map;

public class EchequierUI extends GridPane {
  private static final int TAILLE_CASE = 75;
  private Echequier echequier;
  private Map<Piece, ImageView> imagesPieces = new HashMap<>();
  private final int MAX_CASE = 8;
  private Piece pieceSelectionne = null;

  public EchequierUI() {
    this.echequier = new Echequier();
    dessinerEchequier();
    placerPieces();
    gererClics();;
  }

  private void dessinerEchequier(){
    for(int l=0; l< MAX_CASE; l++){
      for (int c = 0; c < MAX_CASE; c++){
        Rectangle caseEchequier = new Rectangle(TAILLE_CASE,TAILLE_CASE);
        if ((l+c)% 2 == 0){
          caseEchequier.setFill(Color.WHITE);
        }else{
          caseEchequier.setFill(Color.GRAY);
        }
        this.add(caseEchequier,c,l);

      }

    }
  }

  private void placerPieces(){

    for(int x = 0; x < MAX_CASE; x++){
      for(int y=0; y<MAX_CASE; y++){
        Piece piece = echequier.getPiece(x,y);

        if (piece != null ){
          ImageView pieceImage = new ImageView(getImagePiece(piece));
          pieceImage.setFitWidth(TAILLE_CASE);
          pieceImage.setFitHeight(TAILLE_CASE);
          imagesPieces.put(piece, pieceImage);
          this.add(pieceImage, x, y );
        }
      }
    }
  }

  private Image getImagePiece(Piece piece){

    String nomFichier = switch (piece.getClass().getSimpleName()){

      case "Roi"-> "roi";
        case "Reine"-> "reine";
          case "Tour"-> "tour";
            case "Fou"-> "fou";
              case "Cavalier"-> "cavalier";
                case "Pion"-> "pion";
                default -> "";

    };
    nomFichier += piece.getCouleur() == Couleur.BLANC ? "_blanc.png": "_noir.png";
    return new Image(getClass().getResourceAsStream("/image/"+ nomFichier));
  }
  private void mettreAJourPlateau(){
    this.getChildren().removeIf(node-> node instanceof ImageView);
    placerPieces();
  }

  private void gererClics() {
    this.setOnMouseClicked(event -> {
      int colonne = (int) (event.getX() / TAILLE_CASE);
      int ligne = (int) (event.getY() / TAILLE_CASE);

      if (pieceSelectionne == null) {
        pieceSelectionne = echequier.getPiece(colonne, ligne);
      } else {
        if (echequier.deplacerPiece(pieceSelectionne.x, pieceSelectionne.y, colonne, ligne)) {
          mettreAJourPlateau();
        }
        pieceSelectionne = null;
      }
    });
  }


}
