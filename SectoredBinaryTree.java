import java.util.Random;

public class SectoredBinaryTree {

    public static long on(Grid grid) {

        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);

        int yLength = grid.getGrid().length;
        int xLength = grid.getGrid()[0].length;

        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {

                Cell currentCell = grid.getCell(i, j);
                int link;
                if (i < (yLength / 2) && j < (xLength / 2)) {
                    link = random.nextInt(2);

                    if (link == 0) {
                        currentCell.link(currentCell.getEast(), true);
                    } else {
                        currentCell.link(currentCell.getSouth(), true);
                    }

                } else if (i < (yLength / 2) && !(j < (xLength / 2))) {
                    if (currentCell.linked(currentCell.getWest())) {
                        currentCell.link(currentCell.getSouth(), true);
                    } else {
                        link = random.nextInt(2);

                        if (link == 0) {
                            currentCell.link(currentCell.getWest(), true);
                        } else {
                            currentCell.link(currentCell.getSouth(), true);
                        }
                    }

                } else if (!(i < (yLength / 2)) && j < (xLength / 2)) {
                    if (currentCell.linked(currentCell.getNorth())) {
                        currentCell.link(currentCell.getEast(), true);
                    } else {
                        link = random.nextInt(2);

                        if (link == 0) {
                            currentCell.link(currentCell.getNorth(), true);
                        } else {
                            currentCell.link(currentCell.getEast(), true);
                        }
                    }
                } else if (!(i < (yLength / 2)) && !(j < (xLength / 2)) && !(i == yLength / 2 && j == xLength / 2)) {
                    if (currentCell.linked(currentCell.getNorth())) {
                        currentCell.link(currentCell.getWest(), true);
                    } else if (currentCell.linked(currentCell.getWest())) {
                        currentCell.link(currentCell.getNorth(), true);
                    } else {
                        link = random.nextInt(2);

                        if (link == 0) {
                            currentCell.link(currentCell.getNorth(), true);
                        } else {
                            currentCell.link(currentCell.getWest(), true);
                        }
                    }
                }
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {

        Random random = new Random(seed);

        int yLength = grid.getGrid().length;
        int xLength = grid.getGrid()[0].length;

        for (int i = 0; i < yLength; i++) {
            for (int j = 0; j < xLength; j++) {

                Cell currentCell = grid.getCell(i, j);
                int link;
                if (i < (yLength / 2) && j < (xLength / 2)) {
                    link = random.nextInt(2);

                    if (link == 0) {
                        currentCell.link(currentCell.getEast(), true);
                    } else {
                        currentCell.link(currentCell.getSouth(), true);
                    }

                } else if (i < (yLength / 2) && !(j < (xLength / 2))) {
                    if (currentCell.linked(currentCell.getWest())) {
                        currentCell.link(currentCell.getSouth(), true);
                    } else {
                        link = random.nextInt(2);

                        if (link == 0) {
                            currentCell.link(currentCell.getWest(), true);
                        } else {
                            currentCell.link(currentCell.getSouth(), true);
                        }
                    }

                } else if (!(i < (yLength / 2)) && j < (xLength / 2)) {
                    if (currentCell.linked(currentCell.getNorth())) {
                        currentCell.link(currentCell.getEast(), true);
                    } else {
                        link = random.nextInt(2);

                        if (link == 0) {
                            currentCell.link(currentCell.getNorth(), true);
                        } else {
                            currentCell.link(currentCell.getEast(), true);
                        }
                    }
                } else if (!(i < (yLength / 2)) && !(j < (xLength / 2)) && !(i == yLength / 2 && j == xLength / 2)) {
                    if (currentCell.linked(currentCell.getNorth())) {
                        currentCell.link(currentCell.getWest(), true);
                    } else if (currentCell.linked(currentCell.getWest())) {
                        currentCell.link(currentCell.getNorth(), true);
                    } else {
                        link = random.nextInt(2);

                        if (link == 0) {
                            currentCell.link(currentCell.getNorth(), true);
                        } else {
                            currentCell.link(currentCell.getWest(), true);
                        }
                    }
                }
            }
        }
    }
}

/*} else if (!(i < (yLength / 2)) && !(j < (xLength / 2)) && !(i == yLength / 2 && j == xLength / 2)) {
        if (currentCell.linked(currentCell.getNorth()) && !currentCell.linked(currentCell.getWest())) {
        currentCell.link(currentCell.getWest(), true);
        } else if (!currentCell.linked(currentCell.getNorth()) && currentCell.linked(currentCell.getWest())) {
        currentCell.link(currentCell.getNorth(), true);
        } else if (!currentCell.linked(currentCell.getNorth()) && !currentCell.linked(currentCell.getWest())) {
link = random.nextInt(2);

                        if (link == 0) {
        currentCell.link(currentCell.getNorth(), true);
        } else {
        currentCell.link(currentCell.getWest(), true);
        }
        }
        }*/