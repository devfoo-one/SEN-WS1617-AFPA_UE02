package afpa.se.ue02.battleship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

class Game {

    private List<List<Integer>> playField;
    private int shotsFired = 0;

    /**
     * Initialises a game with a given playfield.
     *
     * @param playField playfield
     */
    Game(List<List<Integer>> playField) {
        if (playField != null) {
            this.playField = playField;
        } else {
            throw new IllegalArgumentException("Playfield must not be empty!");
        }
    }

    /**
     * Shows a prompt and reads one line from the console.
     *
     * @param prompt Prompt to show
     * @return String
     */
    private String readFromConsole(String prompt) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(prompt);
        String input = null;
        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    /**
     * Checks if there are still ships on the playfield.
     *
     * @return true if so, false if not.
     */
    private boolean playfieldStillHasShips() {
        for (List<Integer> line : this.playField) {
            for (Integer x : line) {
                if (x == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks the state of a specific playfield cell and returns it
     *
     * @param row row
     * @param col column
     * @return cell state
     * @throws OutOfPlayFieldException if entered coordinates are not in the playfield.
     */
    private CELLSTATE checkPlayfieldCellForShip(int row, int col) throws OutOfPlayFieldException {
        int cell;
        try {
            cell = this.playField.get(row).get(col);
            switch (cell) {
                case 1:
                    return CELLSTATE.SHIP;
                case 2:
                    return CELLSTATE.WRECK;
                default:
                    return CELLSTATE.NOSHIP;
            }
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfPlayFieldException();
        }
    }

    /**
     * Sets a specific playfield cell to a given state
     *
     * @param row   row
     * @param col   column
     * @param state state
     */
    private void setPlayfieldCell(int row, int col, CELLSTATE state) {
        this.playField.get(row).set(col, state.getValue());
    }

    private CELLSTATE fireAtField(int row, int col) throws OutOfPlayFieldException {
        switch (checkPlayfieldCellForShip(row, col)) {
            case SHIP:
                setPlayfieldCell(row, col, CELLSTATE.WRECK);
                return CELLSTATE.SHIP;
            case WRECK:
                return CELLSTATE.WRECK;
        }
        return CELLSTATE.NOSHIP;
    }

    /**
     * Game
     */
    void play() {
        System.out.println("\"exit\" eingeben um das Spiel zu beenden.");
        while (playfieldStillHasShips()) {
            String charMap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String input = readFromConsole("Gib deine Schusskoordinaten in Form <Zeile><Spalte> ein: ");
            int row;
            int col;

            try {
                if (input.toLowerCase().equals("exit")) {
                    System.exit(0);
                }
                if (input.length() == 2) {
                    row = charMap.indexOf(Character.toUpperCase(input.charAt(0)));
                    col = Character.getNumericValue(input.charAt(1));
                    col--;  //map first element from 1 to 0, 2 to 1, ...
                } else throw new IllegalArgumentException("Ungültige Eingabe!");

            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
                continue;
            }

            try {
                this.shotsFired++;
                switch (fireAtField(row, col)) {
                    case NOSHIP:
                        System.out.println("kein Treffer");
                        break;
                    case SHIP:
                        System.out.println("Treffer");
                        break;
                    case WRECK:
                        System.out.println("Wrack");
                        break;
                }
            } catch (OutOfPlayFieldException e) {
                System.err.println("Fehler: Feld ausserhalb des Spielfeldes!");
            }
        }
        System.out.printf("Du hast das Spiel nach Abgabe von %d Schüssen gewonnen!%n", this.shotsFired);
    }

    /**
     * Represents the states of a playfield cell
     */
    private enum CELLSTATE {
        NOSHIP(0), SHIP(1), WRECK(2);

        private int value;

        CELLSTATE(int i) {
            this.value = i;
        }

        public int getValue() {
            return value;
        }
    }

    private class OutOfPlayFieldException extends Exception {
    }
}
