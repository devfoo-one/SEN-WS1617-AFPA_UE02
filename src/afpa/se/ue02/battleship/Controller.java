package afpa.se.ue02.battleship;

public class Controller {

    private static Object createPlayField() {
        // TODO implement static playfield generation
        return new Object(); //TODO change me
    }

    public static void main(String[] args) {
        Game game = new Game(createPlayField());
        game.play();
    }

}
