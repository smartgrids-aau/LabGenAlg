import java.util.Random;

public class CheckbackBinaryTree {

    public static long on(Grid grid) {

        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);

        int yLength = grid.getGrid().length;
        int xLength = grid.getGrid()[0].length;

        for (int i = 0; i < yLength - 1; i++) {
            for (int j = 0; j < xLength - 1; j++) {

                int index = random.nextInt(2);
                Cell currentCell = grid.getCell(i, j);

                if (index == 0) {
                    currentCell.link(currentCell.getEast(), true);
                } else {
                    currentCell.link(currentCell.getSouth(), true);
                }
            }
        }
        for (int i = 0; i < yLength - 2; i++) {
            Cell currentCell = grid.getCell(i, xLength - 1);
            if (currentCell.linked(currentCell.getWest())) {
                currentCell.link(currentCell.getSouth(), true);
            } else {
                int index = random.nextInt(2);
                if (index == 0) {
                    currentCell.link(currentCell.getWest(), true);
                } else {
                    currentCell.link(currentCell.getSouth(), true);
                }
            }
        }
        for (int j = 0; j < xLength - 2; j++) {
            Cell currentCell = grid.getCell(yLength - 1, j);
            if (currentCell.linked(currentCell.getNorth())) {
                currentCell.link(currentCell.getEast(), true);
            } else {
                int index = random.nextInt(2);
                if (index == 0) {
                    currentCell.link(currentCell.getEast(), true);
                } else {
                    currentCell.link(currentCell.getNorth(), true);
                }
            }
        }
        Cell corner = grid.getCell(yLength - 1, xLength - 1);
        corner.link(corner.getNorth(), true);
        corner.link(corner.getWest(), true);

        return seed;
    }
    public static void on(Grid grid, long seed) {

        Random random = new Random(seed);

        int yLength = grid.getGrid().length;
        int xLength = grid.getGrid()[0].length;

        for (int i = 0; i < yLength - 1; i++) {
            for (int j = 0; j < xLength - 1; j++) {

                int index = random.nextInt(2);
                Cell currentCell = grid.getCell(i, j);

                if (index == 0) {
                    currentCell.link(currentCell.getEast(), true);
                } else {
                    currentCell.link(currentCell.getSouth(), true);
                }
            }
        }
        for (int i = 0; i < yLength - 2; i++) {
            Cell currentCell = grid.getCell(i, xLength - 1);
            if (currentCell.linked(currentCell.getWest())) {
                currentCell.link(currentCell.getSouth(), true);
            } else {
                int index = random.nextInt(2);
                if (index == 0) {
                    currentCell.link(currentCell.getWest(), true);
                } else {
                    currentCell.link(currentCell.getSouth(), true);
                }
            }
        }
        for (int j = 0; j < xLength - 2; j++) {
            Cell currentCell = grid.getCell(yLength - 1, j);
            if (currentCell.linked(currentCell.getNorth())) {
                currentCell.link(currentCell.getEast(), true);
            } else {
                int index = random.nextInt(2);
                if (index == 0) {
                    currentCell.link(currentCell.getEast(), true);
                } else {
                    currentCell.link(currentCell.getNorth(), true);
                }
            }
        }
        Cell corner = grid.getCell(yLength - 1, xLength - 1);
        corner.link(corner.getNorth(), true);
        corner.link(corner.getWest(), true);
    }
}

