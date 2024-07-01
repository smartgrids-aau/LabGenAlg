import java.util.ArrayList;
import java.util.Random;

public class RecursiveBacktracker {

    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        Cell startingCell = grid.randomCell(seed);
        ArrayList<Cell> stack = new ArrayList<>();
        stack.add(0, startingCell);

        while(!stack.isEmpty()) {
            Cell currentCell = stack.get(0);
            ArrayList<Cell> neighbours = new ArrayList<>();
            for(int i = 0; i < currentCell.neighbors().size(); i++) {
                if(currentCell.neighbors().get(i).links().isEmpty()) {
                    neighbours.add(0, currentCell.neighbors().get(i));
                }
            }
            if(neighbours.isEmpty()) {
                stack.remove(0);
            } else {
                Cell neighbour;
                neighbour = neighbours.get(random.nextInt(neighbours.size()));
                currentCell.link(neighbour, true);
                stack.add(0, neighbour);
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {
        Random random = new Random(seed);
        Cell startingCell = grid.randomCell(seed);
        ArrayList<Cell> stack = new ArrayList<>();
        stack.add(0, startingCell);

        while(!stack.isEmpty()) {
            Cell currentCell = stack.get(0);
            ArrayList<Cell> neighbours = new ArrayList<>();
            for(int i = 0; i < currentCell.neighbors().size(); i++) {
                if(currentCell.neighbors().get(i).links().isEmpty()) {
                    neighbours.add(0, currentCell.neighbors().get(i));
                }
            }
            if(neighbours.isEmpty()) {
                stack.remove(0);
            } else {
                Cell neighbour;
                neighbour = neighbours.get(random.nextInt(neighbours.size()));
                currentCell.link(neighbour, true);
                stack.add(0, neighbour);
            }
        }
    }

}
