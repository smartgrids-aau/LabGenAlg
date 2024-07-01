import java.util.Random;


public class Snail { //23*23 4297449167656385616

    public static long on(Grid grid) {

        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);

        int sum = grid.getRows() * grid.getColumns();
        int middleX;
        int middleY;
        if (grid.getRows() % 2 == 0) {
            middleX = (grid.getRows() / 2) - 1;
        } else {
            middleX = grid.getRows() / 2;
        }
        if (grid.getColumns() % 2 == 0) {
            middleY = (grid.getColumns() / 2) - 1;
        } else {
            middleY = grid.getColumns() / 2;
        }
        Cell currentCell = grid.getCell(middleY, middleX);
        int inner = 1;
        int counter = 1;
        int changeDirection = 0;
        int direction = 0;
        for (int i = 0; i < sum - 1; i++) {
            Cell next = currentCell;
            while (!currentCell.getVisited()) {
                currentCell.setVisited(true);
                int index = random.nextInt(currentCell.neighbors().size());
                Cell neighbour = currentCell.neighbors().get(index);
                if(!neighbour.getVisited()) {
                    currentCell.link(neighbour, true);
                    currentCell = neighbour;
                } else {
                    currentCell = next;
                }
            }
            if (direction == 0) {
                if (!currentCell.getSouth().getVisited()) {
                    currentCell.link(currentCell.getSouth(), true);
                }
                currentCell = currentCell.getSouth();
            } else if (direction == 1) {
                if (!currentCell.getEast().getVisited()) {
                    currentCell.link(currentCell.getEast(), true);
                }
                currentCell = currentCell.getEast();
            } else if (direction == 2) {
                if (!currentCell.getNorth().getVisited()) {
                    currentCell.link(currentCell.getNorth(), true);
                }
                currentCell = currentCell.getNorth();
            } else {
                if (!currentCell.getWest().getVisited()) {
                    currentCell.link(currentCell.getWest(), true);
                }
                currentCell = currentCell.getWest();
            }
            if (i == changeDirection) {
                changeDirection += counter;
                inner++;
                if (inner == 2) {
                    inner = 0;
                    counter++;
                }
                if (direction < 3) {
                    direction++;
                } else {
                    direction = 0;
                }
            }
        }
        return seed;
    }

    public static void on(Grid grid, long seed) {

        Random random = new Random(seed);

        int sum = grid.getRows() * grid.getColumns();
        int middleX;
        int middleY;
        if (grid.getRows() % 2 == 0) {
            middleX = (grid.getRows() / 2) - 1;
        } else {
            middleX = grid.getRows() / 2;
        }
        if (grid.getColumns() % 2 == 0) {
            middleY = (grid.getColumns() / 2) - 1;
        } else {
            middleY = grid.getColumns() / 2;
        }
        Cell currentCell = grid.getCell(middleX, middleY);
        int inner = 1;
        int counter = 1;
        int changeDirection = 0;
        int direction = 0;
        for (int i = 0; i < sum - 1; i++) {
            Cell next = currentCell;
            while (!currentCell.getVisited()) {
                currentCell.setVisited(true);
                int index = random.nextInt(currentCell.neighbors().size());
                Cell neighbour = currentCell.neighbors().get(index);
                if(!neighbour.getVisited()) {
                    currentCell.link(neighbour, true);
                    currentCell = neighbour;
                } else {
                    currentCell = next;
                }
            }
            if (direction == 0) {
                if (!currentCell.getSouth().getVisited()) {
                    currentCell.link(currentCell.getSouth(), true);
                }
                currentCell = currentCell.getSouth();
            } else if (direction == 1) {
                if (!currentCell.getEast().getVisited()) {
                    currentCell.link(currentCell.getEast(), true);
                }
                currentCell = currentCell.getEast();
            } else if (direction == 2) {
                if (!currentCell.getNorth().getVisited()) {
                    currentCell.link(currentCell.getNorth(), true);
                }
                currentCell = currentCell.getNorth();
            } else {
                if (!currentCell.getWest().getVisited()) {
                    currentCell.link(currentCell.getWest(), true);
                }
                currentCell = currentCell.getWest();
            }
            if (i == changeDirection) {
                changeDirection += counter;
                inner++;
                if (inner == 2) {
                    inner = 0;
                    counter++;
                }
                if (direction < 3) {
                    direction++;
                } else {
                    direction = 0;
                }
            }
        }
    }
}