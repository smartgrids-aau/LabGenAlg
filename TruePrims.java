import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class TruePrims {

    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        ArrayList<Cell> active = new ArrayList<>();
        active.add(grid.randomCell(seed));
        HashMap<Cell, Integer> costs = new HashMap<>();
        for(int i = 0; i < grid.getRows(); i++) {
            for(int j = 0; j < grid.getColumns(); j++) {
                costs.put(grid.getCell(i, j), random.nextInt(100));
            }
        }

        while(!active.isEmpty()) {
            Cell currentCell = active.get(0);
            for(int i = 0; i + 1 < active.size(); i++) {
                if(costs.get(active.get(i)) < costs.get(active.get(i + 1))) {
                    currentCell = active.get(i);
                } else {
                    currentCell = active.get(i + 1);
                }
            }
            ArrayList<Cell> availableNeighbours = new ArrayList<>();
            for(int i = 0; i < currentCell.neighbors().size(); i++) {
                if (currentCell.neighbors().get(i).links().isEmpty()) {
                    availableNeighbours.add(currentCell.neighbors().get(i));
                }
            }
            if(!availableNeighbours.isEmpty()) {
                Cell neighbour = availableNeighbours.get(0);
                for(int i = 0; i + 1 < availableNeighbours.size(); i++) {
                    if(costs.get(availableNeighbours.get(i)) < costs.get(availableNeighbours.get(i + 1))) {
                        neighbour = availableNeighbours.get(i);
                    } else {
                        neighbour = availableNeighbours.get(i + 1);
                    }
                }
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
        HashMap<Cell, Integer> costs = new HashMap<>();
        for(int i = 0; i < grid.getRows(); i++) {
            for(int j = 0; j < grid.getColumns(); j++) {
                costs.put(grid.getCell(i, j), random.nextInt(100));
            }
        }

        while(!active.isEmpty()) {
            Cell currentCell = active.get(0);
            for(int i = 0; i + 1 < active.size(); i++) {
                if(costs.get(active.get(i)) < costs.get(active.get(i + 1))) {
                    currentCell = active.get(i);
                } else {
                    currentCell = active.get(i + 1);
                }
            }
            ArrayList<Cell> availableNeighbours = new ArrayList<>();
            for(int i = 0; i < currentCell.neighbors().size(); i++) {
                if (currentCell.neighbors().get(i).links().isEmpty()) {
                    availableNeighbours.add(currentCell.neighbors().get(i));
                }
            }
            if(!availableNeighbours.isEmpty()) {
                Cell neighbour = availableNeighbours.get(0);
                for(int i = 0; i + 1 < availableNeighbours.size(); i++) {
                    if(costs.get(availableNeighbours.get(i)) < costs.get(availableNeighbours.get(i + 1))) {
                        neighbour = availableNeighbours.get(i);
                    } else {
                        neighbour = availableNeighbours.get(i + 1);
                    }
                }
                currentCell.link(neighbour, true);
                active.add(neighbour);
            } else {
                active.remove(currentCell);
            }
        }
    }
}
