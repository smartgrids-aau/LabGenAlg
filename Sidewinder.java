import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

public class Sidewinder {

    public static long on(Grid grid){
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);

        for(int i = 0; i < grid.getGrid().length; i++) {
            ArrayList<Cell> run = new ArrayList<>();
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                Cell currentCell = grid.getCell(i, j);
                run.add(currentCell);
                if(currentCell.getNorth() == null) {
                    if(currentCell.getEast() != null) {
                        currentCell.link(currentCell.getEast(), true);
                    }
                } else if(currentCell.getEast() == null || random.nextDouble() < 0.5) {
                    //int min = 0;
                    //int max = run.size() - 1;
                    //int index = (int) (Math.random() * (max - min + 1) + min);
                    int index = (random.nextInt(run.size()));
                    run.get(index).link(run.get(index).getNorth(), true);
                    run.clear();
                } else {
                    currentCell.link(currentCell.getEast(), true);
                }
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed){
        Random random = new Random(seed);

        for(int i = 0; i < grid.getGrid().length; i++) {
            ArrayList<Cell> run = new ArrayList<>();
            for(int j = 0; j < grid.getGrid()[i].length; j++) {
                Cell currentCell = grid.getCell(i, j);
                run.add(currentCell);
                if(currentCell.getNorth() == null) {
                    if(currentCell.getEast() != null) {
                        currentCell.link(currentCell.getEast(), true);
                    }
                } else if(currentCell.getEast() == null || random.nextDouble() < 0.5) {
                    //int min = 0;
                    //int max = run.size() - 1;
                    //int index = (int) (Math.random() * (max - min + 1) + min);
                    int index = (random.nextInt(run.size()));
                    run.get(index).link(run.get(index).getNorth(), true);
                    run.clear();
                } else {
                    currentCell.link(currentCell.getEast(), true);
                }
            }
        }
    }

}
