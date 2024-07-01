import java.util.ArrayList;
import java.util.Random;

public class Wilsons{

    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        ArrayList<Cell> unvisited = new ArrayList<>(grid.size());
        for(int i = 0; i < grid.getRows(); i++) {
            for(int j = 0; j < grid.getColumns(); j++) {
                unvisited.add(grid.getCell(i, j));
            }
        }
        Cell first = unvisited.get(random.nextInt(unvisited.size()));
        unvisited.remove(first);
        while(!unvisited.isEmpty()) {
            Cell currentCell = unvisited.get(random.nextInt(unvisited.size()));
            ArrayList<Cell> path = new ArrayList<>();
            path.add(currentCell);

            while(unvisited.contains(currentCell)) {
                currentCell = currentCell.neighbors().get(random.nextInt(currentCell.neighbors().size()));
                int position = path.indexOf(currentCell);
                if(position != -1) {
                    path.subList(2, path.size()).clear();
                    currentCell = path.get(1);
                } else {
                    path.add(currentCell);
                }
            }
            for(int i = 0; i < path.size() - 1; i++) {
                path.get(i).link(path.get(i + 1), true);
                unvisited.remove(path.get(i));
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {
        Random random = new Random(seed);
        ArrayList<Cell> unvisited = new ArrayList<>(grid.size());
        for(int i = 0; i < grid.getRows(); i++) {
            for(int j = 0; j < grid.getColumns(); j++) {
                unvisited.add(grid.getCell(i, j));
            }
        }
        Cell first = unvisited.get(random.nextInt(unvisited.size()));
        unvisited.remove(first);
        while(!unvisited.isEmpty()) {
            Cell currentCell = unvisited.get(random.nextInt(unvisited.size()));
            ArrayList<Cell> path = new ArrayList<>();
            path.add(currentCell);

            while(unvisited.contains(currentCell)) {
                currentCell = currentCell.neighbors().get(random.nextInt(currentCell.neighbors().size()));
                int position = path.indexOf(currentCell);
                if(position != -1) {
                    path.subList(2, path.size()).clear();
                    currentCell = path.get(1);
                } else {
                    path.add(currentCell);
                }
            }
            for(int i = 0; i < path.size() - 1; i++) {
                path.get(i).link(path.get(i + 1), true);
                unvisited.remove(path.get(i));
            }
        }
    }
}
