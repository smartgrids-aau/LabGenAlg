import java.util.ArrayList;
import java.util.Random;

public class AlternatingBinaryTree { //15*15 7409984521044416637

    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        for(int i = grid.getGrid().length - 1; i > 0; i--) {
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                Cell currentCell = grid.getCell(i, j);
                ArrayList<Cell> neighbours = new ArrayList<>();
                neighbours.add(grid.getGrid()[i][j].getNorth());
                if(i % 2 == 0) {
                    if(grid.getGrid()[i][j].getEast() != null) {
                        neighbours.add(grid.getGrid()[i][j].getEast());
                    }
                    int index = random.nextInt(neighbours.size());
                    Cell neighbour = neighbours.get(index);
                    currentCell.link(neighbour, true);
                }
                else{
                    if(grid.getGrid()[i][j].getWest() != null) {
                        neighbours.add(grid.getGrid()[i][j].getWest());
                    }
                    int index = random.nextInt(neighbours.size());
                    Cell neighbour = neighbours.get(index);
                    currentCell.link(neighbour, true);
                }
            }
        }
        for(int j = 0; j < grid.getGrid()[0].length - 1; j++) {
            Cell currentCell = grid.getCell(0, j);
            currentCell.link(currentCell.getEast(), true);
        }
        return seed;
    }

    public static void on(Grid grid, long seed) {
        Random random = new Random(seed);
        for(int i = grid.getGrid().length - 1; i > 0; i--) {
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                Cell currentCell = grid.getCell(i, j);
                ArrayList<Cell> neighbours = new ArrayList<>();
                neighbours.add(grid.getGrid()[i][j].getNorth());
                if(i % 2 == 0) {
                    if(grid.getGrid()[i][j].getEast() != null) {
                        neighbours.add(grid.getGrid()[i][j].getEast());
                    }
                    int index = random.nextInt(neighbours.size());
                    Cell neighbour = neighbours.get(index);
                    currentCell.link(neighbour, true);
                }
                else{
                    if(grid.getGrid()[i][j].getWest() != null) {
                        neighbours.add(grid.getGrid()[i][j].getWest());
                    }
                    int index = random.nextInt(neighbours.size());
                    Cell neighbour = neighbours.get(index);
                    currentCell.link(neighbour, true);
                }
            }
        }
        for(int j = 0; j < grid.getGrid()[0].length - 1; j++) {
            Cell currentCell = grid.getCell(0, j);
            currentCell.link(currentCell.getEast(), true);
        }
    }
}