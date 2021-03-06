package afpa.se.ue02.codeGen;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeGen {

    private static final String INFILE_PATH = "playfield.txt";
    private static final String OUTFILE_PATH = "src/afpa/se/ue02/battleship/GeneratedPlayfield.java";

    /**
     * Reads a text-file line by line and returns a list of lines.
     * WARNING: Filters all characters but digits!
     *
     * @param path Path to file
     * @return List, where each element represents one line of the file.
     */
    private static List<String> readNumberFile(String path) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String currentLine;
            int lineCounter = 0;
            int lengthOfFirstLine = 0;
            while ((currentLine = br.readLine()) != null) {
                lineCounter++;
                if (lineCounter > 26) {
                    throw new IllegalArgumentException("Modell enthält zu viele Zeilen.");
                }
                if (lineCounter == 1) {
                    lengthOfFirstLine = currentLine.length();
                }
                if (currentLine.length() != lengthOfFirstLine || currentLine.length() > 9) {
                    throw new IllegalArgumentException(String.format("Zeile %d des Modells besitzt eine falsche Länge.", lineCounter));
                }
                if (currentLine.matches("[0-1]+")) {
                    lines.add(currentLine);
                } else {
                    throw new IllegalArgumentException(String.format("Zeile %d des Modells enthält ungültige Zeichen.", lineCounter));
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Writes a text file from a list of strings.
     *
     * @param lines List of Strings
     * @param path  Filepath
     */
    private static void writeFile(List<String> lines, String path) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (String line : lines) {
                bw.write(line);
                bw.write(System.getProperty("line.separator"));
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        final List<String> linesOutfile = new ArrayList<>();
        final List<String> linesInfile = readNumberFile(INFILE_PATH);
        linesOutfile.add("package afpa.se.ue02.battleship;");
        linesOutfile.add("import java.util.ArrayList;");
        linesOutfile.add("import java.util.Arrays;");
        linesOutfile.add("import java.util.List;");
        linesOutfile.add("class GeneratedPlayfield {");
        linesOutfile.add("static List<List<Integer>> getPlayfield() {");
        linesOutfile.add("List<List<Integer>> playfield = new ArrayList<>();");

        if (linesInfile.size() == 0) {
            throw new IllegalArgumentException("Modell ist leer.");
        }

        for (String line : linesInfile) {
            StringBuilder lineBuilder = new StringBuilder("playfield.add(new ArrayList<>(Arrays.asList(");
            List<String> cells = Arrays.asList(line.split(""));
            for (String cell : cells) {
                lineBuilder.append(cell);
                lineBuilder.append(",");
            }
            lineBuilder.deleteCharAt(lineBuilder.length() - 1);  // remove last comma
            lineBuilder.append(")));");
            linesOutfile.add(lineBuilder.toString());
        }
        linesOutfile.add("return playfield;");
        linesOutfile.add("}");
        linesOutfile.add("}");
        writeFile(linesOutfile, OUTFILE_PATH);
    }
}
