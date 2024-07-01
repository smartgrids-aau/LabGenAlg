import java.util.ArrayList;
import java.util.Random;

public class HuntAndKill {

    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        Cell currentCell = grid.randomCell(seed);
        while(currentCell != null) {
            ArrayList<Cell> unvisitedNeighbours = new ArrayList<>();
            for(int i = 0; i < currentCell.neighbors().size(); i++) {
                if(currentCell.neighbors().get(i).links().isEmpty()) {
                    unvisitedNeighbours.add(currentCell.neighbors().get(i));
                }
            }
            if(!unvisitedNeighbours.isEmpty()) {
                Cell neighbour = unvisitedNeighbours.get(random.nextInt(unvisitedNeighbours.size()));
                currentCell.link(neighbour, true);
                currentCell = neighbour;
            } else {
                currentCell = null;

                for(int i = 0; i < grid.getRows(); i++) {
                    for(int j = 0; j < grid.getColumns(); j++) {
                        ArrayList<Cell> visitedNeighbours = new ArrayList<>();
                        for(int k = 0; k < grid.getCell(i, j).neighbors().size(); k++) {
                            if(!grid.getCell(i, j).neighbors().get(k).links().isEmpty()) {
                                visitedNeighbours.add(grid.getCell(i, j).neighbors().get(k));
                            }
                        }
                        if(grid.getCell(i, j).links().isEmpty() && !visitedNeighbours.isEmpty()) {
                            currentCell = grid.getCell(i, j);
                            Cell neighbour = visitedNeighbours.get(random.nextInt(visitedNeighbours.size()));
                            currentCell.link(neighbour, true);
                        }
                    }
                }
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {
        Random random = new Random(seed);
        Cell currentCell = grid.randomCell(seed);
        while(currentCell != null) {
            ArrayList<Cell> unvisitedNeighbours = new ArrayList<>();
            for(int i = 0; i < currentCell.neighbors().size(); i++) {
                if(currentCell.neighbors().get(i).links().isEmpty()) {
                    unvisitedNeighbours.add(currentCell.neighbors().get(i));
                }
            }
            if(!unvisitedNeighbours.isEmpty()) {
                Cell neighbour = unvisitedNeighbours.get(random.nextInt(unvisitedNeighbours.size()));
                currentCell.link(neighbour, true);
                currentCell = neighbour;
            } else {
                currentCell = null;

                for(int i = 0; i < grid.getRows(); i++) {
                    for(int j = 0; j < grid.getColumns(); j++) {
                        ArrayList<Cell> visitedNeighbours = new ArrayList<>();
                        for(int k = 0; k < grid.getCell(i, j).neighbors().size(); k++) {
                            if(!grid.getCell(i, j).neighbors().get(k).links().isEmpty()) {
                                visitedNeighbours.add(grid.getCell(i, j).neighbors().get(k));
                            }
                        }
                        if(grid.getCell(i, j).links().isEmpty() && !visitedNeighbours.isEmpty()) {
                            currentCell = grid.getCell(i, j);
                            Cell neighbour = visitedNeighbours.get(random.nextInt(visitedNeighbours.size()));
                            currentCell.link(neighbour, true);
                        }
                    }
                }
            }
        }
    }
}
