package afpa.se.ue02.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GeneratedPlayfield {
    private static final GeneratedPlayfield instance = new GeneratedPlayfield();
    private static List<List<Integer>> playfield;

    private GeneratedPlayfield() {
        playfield = new ArrayList<>();
        playfield.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 0)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 1, 0)));
    }

    static List<List<Integer>> getPlayfield() {
        return playfield;
    }
}
