import java.util.ArrayList;
import java.util.Random;

public class SimplifedPrims {

    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        ArrayList<Cell> active = new ArrayList<>();
        active.add(grid.randomCell(seed));

        while(!active.isEmpty()) {
            Cell currentCell = active.get(random.nextInt(active.size()));
            ArrayList<Cell> availableNeighbours = new ArrayList<>();
            for(int i = 0; i < currentCell.neighbors().size(); i++) {
                if (currentCell.neighbors().get(i).links().isEmpty()) {
                    availableNeighbours.add(currentCell.neighbors().get(i));
                }
            }
            if(!availableNeighbours.isEmpty()) {
                Cell neighbour;
                neighbour = availableNeighbours.get(random.nextInt(availableNeighbours.size()));
                currentCell.link(neighbour, true);
                active.add(neighbour);
            } else {
                active.remove(currentCell);
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {
        Random random = new Random(seed);
        ArrayList<Cell> active = new ArrayList<>();
        active.add(grid.randomCell(seed));

        while(!active.isEmpty()) {
            Cell currentCell = active.get(random.nextInt(active.size()));
            ArrayList<Cell> availableNeighbours = new ArrayList<>();
            for(int i = 0; i < currentCell.neighbors().size(); i++) {
                if (currentCell.neighbors().get(i).links().isEmpty()) {
                    availableNeighbours.add(currentCell.neighbors().get(i));
                }
            }
            if(!availableNeighbours.isEmpty()) {
                Cell neighbour;
                neighbour = availableNeighbours.get(random.nextInt(availableNeighbours.size()));
                currentCell.link(neighbour, true);
                active.add(neighbour);
            } else {
                active.remove(currentCell);
            }
        }
    }
}
