import java.util.Random;

public class AldousBroder {

    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        Cell currentCell = grid.randomCell(seed);
        int unvisited = grid.size() - 1;

        while(unvisited > 0) {
            int index = random.nextInt(currentCell.neighbors().size());
            Cell neighbour = currentCell.neighbors().get(index);

            if(neighbour.getMap().isEmpty()) {
                currentCell.link(neighbour, true);
                unvisited--;
            }

            currentCell = neighbour;

        }
        return seed;
    }
    public static void on(Grid grid, long seed) {
        Random random = new Random(seed);
        Cell currentCell = grid.randomCell(seed);
        int unvisited = grid.size() - 1;

        while(unvisited > 0) {
            int index = random.nextInt(currentCell.neighbors().size());
            Cell neighbour = currentCell.neighbors().get(index);

            if(neighbour.getMap().isEmpty()) {
                currentCell.link(neighbour, true);
                unvisited--;
            }

            currentCell = neighbour;

        }

    }
}
