package afpa.se.ue02.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private static List<List<Integer>> createPlayField() {
        List<List<Integer>> playfield = new ArrayList<>();
        playfield.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 1, 0)));
        return playfield;
    }

    public static void main(String[] args) {
        Game game = new Game(createPlayField());
//        Game game = new Game(GeneratedPlayfield.getPlayfield());
        game.play();
    }

}
