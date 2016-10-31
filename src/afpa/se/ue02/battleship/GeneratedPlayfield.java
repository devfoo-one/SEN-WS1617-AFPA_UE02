package afpa.se.ue02.battleship;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class GeneratedPlayfield {
    static List<List<Integer>> getPlayfield() {
        List<List<Integer>> playfield = new ArrayList<>();
        playfield.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 1, 1, 1, 1, 1)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1, 1)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0, 1, 1)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0, 1, 1)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 0, 0, 1, 1)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0, 0, 0, 1, 1)));
        playfield.add(new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 1, 0, 1, 1)));
        return playfield;
    }
}
