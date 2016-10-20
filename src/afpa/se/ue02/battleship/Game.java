package afpa.se.ue02.battleship;

public class Game {

    private Object playField;  //TODO choose type

    public Game(Object playField) {
        if (playField != null) {
            this.playField = playField;
        } else {
            throw new IllegalArgumentException("Game field must not be empty!");
        }
    }

    public void play() {
        while(true) {
            //TODO game
        }
    }
}
