import java.util.Random;

public class CheckbackBinaryTree2x2 {

    public static long on(Grid grid) {

        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);

        int xOdd = grid.getGrid().length % 2;
        int yOdd = grid.getGrid()[0].length % 2;
        int xLength = grid.getGrid().length - xOdd;
        int yLength = grid.getGrid()[0].length - yOdd;

        for (int i = 0; i < xLength - 1; i = i + 2) {
            for (int j = 0; j < yLength - 1; j = j + 2) {

                int smallMaze = random.nextInt(4);

                Cell first = grid.getCell(i, j);
                Cell second = grid.getCell(i, j + 1);
                Cell third = grid.getCell(i + 1, j + 1);
                Cell fourth = grid.getCell(i + 1, j);

                if (smallMaze == 0) {
                    first.link(second, true);
                    second.link(third, true);
                    third.link(fourth, true);
                } else if (smallMaze == 1) {
                    second.link(third, true);
                    third.link(fourth, true);
                    fourth.link(first, true);
                } else if (smallMaze == 2) {
                    third.link(fourth, true);
                    fourth.link(first, true);
                    first.link(second, true);
                } else {
                    fourth.link(first, true);
                    first.link(second, true);
                    second.link(third, true);
                }

                int link;
                if (i < (xLength - 2) && j < (yLength - 2)) {
                    link = random.nextInt(4);

                    if (link == 0) {
                        second.link(second.getEast(), true);
                    } else if (link == 1) {
                        third.link(third.getEast(), true);
                    } else if (link == 2) {
                        third.link(third.getSouth(), true);
                    } else {
                        fourth.link(fourth.getSouth(), true);
                    }
                } else if (i < (xLength - 2) && !(j < (yLength - 2))) {
                    if (first.linked(first.getWest()) || fourth.linked(fourth.getWest())) {
                        link = random.nextInt(2);

                        if (link == 0) {
                            third.link(third.getSouth(), true);
                        } else {
                            fourth.link(fourth.getSouth(), true);
                        }
                    } else {
                        link = random.nextInt(4);

                        if (link == 0) {
                            third.link(third.getSouth(), true);
                        } else if (link == 1) {
                            fourth.link(fourth.getSouth(), true);
                        } else if (link == 2) {
                            first.link(first.getWest(), true);
                        } else {
                            fourth.link(fourth.getWest(), true);
                        }
                    }
                } else if (!(i < (xLength - 2)) && j < (yLength - 2)) {
                    if (first.linked(first.getNorth()) || second.linked(second.getNorth())) {
                        link = random.nextInt(2);

                        if (link == 0) {
                            second.link(second.getEast(), true);
                        } else {
                            third.link(third.getEast(), true);
                        }
                    } else {
                        link = random.nextInt(4);

                        if (link == 0) {
                            second.link(second.getEast(), true);
                        } else if (link == 1) {
                            third.link(third.getEast(), true);
                        } else if (link == 2) {
                            first.link(first.getNorth(), true);
                        } else {
                            second.link(second.getNorth(), true);
                        }
                    }
                }
            }
        }
        if (xOdd == 1) {
            for (int i = 0; i < xLength; i++) {
                Cell currentCell = grid.getCell(i, yLength - 1 + yOdd);
                int link = random.nextInt(2);
                if ( link == 0) {
                    currentCell.link(currentCell.getSouth(),true);
                } else {
                    currentCell.link(currentCell.getWest(),true);
                }
            }
        }
        if (yOdd == 1) {
            for (int j = 0; j < yLength; j++) {
                Cell currentCell = grid.getCell(xLength - 1 + xOdd, j);
                int link = random.nextInt(2);
                if ( link == 0) {
                    currentCell.link(currentCell.getNorth(),true);
                } else {
                    currentCell.link(currentCell.getEast(),true);
                }
            }
        }
        if ((xOdd + yOdd) > 0) {
            Cell corner = grid.getCell(xLength - 1 + xOdd, yLength - 1 + yOdd);
            if (!(corner.linked(corner.getNorth()) || corner.linked(corner.getWest()))) {
                int link = random.nextInt(2);
                if (link == 0) {
                    corner.link(corner.getNorth(), true);
                } else {
                    corner.link(corner.getWest(), true);
                }
            } else if (corner.linked(corner.getNorth())) {
                corner.getNorth().link(corner.getNorth().getWest(), true);
            } else if (corner.linked(corner.getWest())) {
                corner.getWest().link(corner.getWest().getNorth(), true);
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {

        Random random = new Random(seed);

        int xOdd = grid.getGrid().length % 2;
        int yOdd = grid.getGrid()[0].length % 2;
        int xLength = grid.getGrid().length - xOdd;
        int yLength = grid.getGrid()[0].length - yOdd;

        for (int i = 0; i < xLength - 1; i = i + 2) {
            for (int j = 0; j < yLength - 1; j = j + 2) {

                int smallMaze = random.nextInt(4);

                Cell first = grid.getCell(i, j);
                Cell second = grid.getCell(i, j + 1);
                Cell third = grid.getCell(i + 1, j + 1);
                Cell fourth = grid.getCell(i + 1, j);

                if (smallMaze == 0) {
                    first.link(second, true);
                    second.link(third, true);
                    third.link(fourth, true);
                } else if (smallMaze == 1) {
                    second.link(third, true);
                    third.link(fourth, true);
                    fourth.link(first, true);
                } else if (smallMaze == 2) {
                    third.link(fourth, true);
                    fourth.link(first, true);
                    first.link(second, true);
                } else {
                    fourth.link(first, true);
                    first.link(second, true);
                    second.link(third, true);
                }

                int link;
                if (i < (xLength - 2) && j < (yLength - 2)) {
                    link = random.nextInt(4);

                    if (link == 0) {
                        second.link(second.getEast(), true);
                    } else if (link == 1) {
                        third.link(third.getEast(), true);
                    } else if (link == 2) {
                        third.link(third.getSouth(), true);
                    } else {
                        fourth.link(fourth.getSouth(), true);
                    }
                } else if (i < (xLength - 2) && !(j < (yLength - 2))) {
                    if (first.linked(first.getWest()) || fourth.linked(fourth.getWest())) {
                        link = random.nextInt(2);

                        if (link == 0) {
                            third.link(third.getSouth(), true);
                        } else {
                            fourth.link(fourth.getSouth(), true);
                        }
                    } else {
                        link = random.nextInt(4);

                        if (link == 0) {
                            third.link(third.getSouth(), true);
                        } else if (link == 1) {
                            fourth.link(fourth.getSouth(), true);
                        } else if (link == 2) {
                            first.link(first.getWest(), true);
                        } else {
                            fourth.link(fourth.getWest(), true);
                        }
                    }

                } else if (!(i < (xLength - 2)) && j < (yLength - 2)) {
                    if (first.linked(first.getNorth()) || second.linked(second.getNorth())) {
                        link = random.nextInt(2);

                        if (link == 0) {
                            second.link(second.getEast(), true);
                        } else {
                            third.link(third.getEast(), true);
                        }
                    } else {
                        link = random.nextInt(4);

                        if (link == 0) {
                            second.link(second.getEast(), true);
                        } else if (link == 1) {
                            third.link(third.getEast(), true);
                        } else if (link == 2) {
                            first.link(first.getNorth(), true);
                        } else {
                            second.link(second.getNorth(), true);
                        }
                    }
                }
            }
        }
        if (xOdd == 1) {
            for (int i = 0; i < xLength; i++) {
                Cell currentCell = grid.getCell(i, yLength - 1 + yOdd);
                int link = random.nextInt(2);
                if ( link == 0) {
                    currentCell.link(currentCell.getSouth(),true);
                } else {
                    currentCell.link(currentCell.getWest(),true);
                }
            }
        }
        if (yOdd == 1) {
            for (int j = 0; j < yLength; j++) {
                Cell currentCell = grid.getCell(xLength - 1 + xOdd, j);
                int link = random.nextInt(2);
                if ( link == 0) {
                    currentCell.link(currentCell.getNorth(),true);
                } else {
                    currentCell.link(currentCell.getEast(),true);
                }
            }
        }
        if ((xOdd + yOdd) > 0) {
            Cell corner = grid.getCell(xLength - 1 + xOdd, yLength - 1 + yOdd);
            if (!(corner.linked(corner.getNorth()) || corner.linked(corner.getWest()))) {
                int link = random.nextInt(2);
                if (link == 0) {
                    corner.link(corner.getNorth(), true);
                } else {
                    corner.link(corner.getWest(), true);
                }
            } else if (corner.linked(corner.getNorth())) {
                corner.getNorth().link(corner.getNorth().getWest(), true);
            } else if (corner.linked(corner.getWest())) {
                corner.getWest().link(corner.getWest().getNorth(), true);
            }
        }
    }
}

