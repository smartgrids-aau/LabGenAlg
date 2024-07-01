import java.util.ArrayList;
import java.util.Random;

public class BinaryTree {

    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        for(int i = 0; i < grid.getGrid().length; i++) {
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                ArrayList<Cell> neighbours = new ArrayList<>();
                if(grid.getGrid()[i][j].getNorth() != null) {
                    neighbours.add(grid.getGrid()[i][j].getNorth());
                }
                if(grid.getGrid()[i][j].getEast() != null) {
                    neighbours.add(grid.getGrid()[i][j].getEast());
                }
                if(!neighbours.isEmpty()) {
                    int index = (int) (random.nextInt(neighbours.size()));
                    Cell neighbour = neighbours.get(index);
                    grid.getGrid()[i][j].link(neighbour, true);
                }
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {

        Random random = new Random(seed);
        for(int i = 0; i < grid.getGrid().length; i++) {
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                ArrayList<Cell> neighbours = new ArrayList<>();
                if(grid.getGrid()[i][j].getNorth() != null) {
                    neighbours.add(grid.getGrid()[i][j].getNorth());
                }
                if(grid.getGrid()[i][j].getEast() != null) {
                    neighbours.add(grid.getGrid()[i][j].getEast());
                }
                if(!neighbours.isEmpty()) {
                    int index = (int) (random.nextInt(neighbours.size()));
                    Cell neighbour = neighbours.get(index);
                    grid.getGrid()[i][j].link(neighbour, true);
                }
            }
        }
    }
}
