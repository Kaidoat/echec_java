package Piece;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EchequierUI extends GridPane {
  private static final int TAILLE_CASE = 75;
  private final int MAX_CASE = 8;

  public EchequierUI() {
    dessinerEchequier();
  }

  private void dessinerEchequier(){
    for(int l=0; l< MAX_CASE; l++){
      for (int c = 0; c < MAX_CASE; c++){
        Rectangle caseEchequier = new Rectangle(TAILLE_CASE,TAILLE_CASE);
        if ((l+c)% 2 == 0){
          caseEchequier.setFill(Color.WHITE);
        }else{
          caseEchequier.setFill(Color.BLACK);
        }
        this.add(caseEchequier,c,l);

      }

    }
  }
}
