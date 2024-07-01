import java.util.*;

public class Ellers {

    private static class RowState {

        HashMap<Integer, ArrayList<Cell>> cellsInSet;
        ArrayList<Integer> setForCell;
        int nextSet;

        public RowState(int startingSet) {
            cellsInSet = new HashMap<>();
            setForCell = new ArrayList<>();
            this.nextSet = startingSet;
        }
        public void record(int set, Cell cell) {
            setForCell.add(cell.getColumn(), set);
            if(cellsInSet.get(set) == null) {
                cellsInSet.put(set, new ArrayList<>());
            }
            cellsInSet.get(set).add(cell);
        }
        public int setFor(Cell cell) {

            if (setForCell.get(cell.getColumn()) != null) {
                record(nextSet, cell);
                nextSet++;
            }
            return setForCell.get(cell.getColumn());
        }
        public void merge(int winner, int loser) {
            for(int i = 0; i < cellsInSet.get(loser).size(); i++) {
                setForCell.add(cellsInSet.get(loser).get(i).getColumn(), winner);
                cellsInSet.get(winner).add(cellsInSet.get(loser).get(i));
            }
            cellsInSet.remove(loser);
        }
        public RowState next() {
            return new RowState(nextSet);
        }
    }
    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        RowState rowState = new RowState(0);

        for(int row = 0; row < grid.getRows(); row++) {
            for(int i = 1; i < grid.getColumns(); i++) {
                int set = rowState.setFor(grid.getCell(row, i));
                int priorSet = rowState.setFor(grid.getCell(row, i).getWest());
                boolean shouldLink = (set != priorSet && grid.getCell(row, i).getSouth() == null || random.nextDouble() < 0.5);
                if(shouldLink) {
                    grid.getCell(row, i).link(grid.getCell(row, i).getWest(), true);
                    rowState.merge(priorSet, set);
                }
            }
            if(row != grid.getRows() - 1) {
                RowState nextRow = rowState.next();
                Object[] cellsInSetKeysArray = rowState.cellsInSet.keySet().toArray();
                for(int i = 0; i < rowState.cellsInSet.size(); i++) {
                    ArrayList<Cell> actualSet = rowState.cellsInSet.get((int) cellsInSetKeysArray[i]);
                    Collections.shuffle(actualSet);
                    for(int j = 0; j < actualSet.size(); j++) {
                        if(j == 0 || random.nextDouble() < (double) 1 / 3) {
                            actualSet.get(j).link(actualSet.get(j).getSouth(), true);
                            nextRow.record(rowState.setFor(actualSet.get(j)), actualSet.get(j).getSouth());
                        }
                    }
                }
                rowState = nextRow;
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {
        Random random = new Random(seed);
        RowState rowState = new RowState(0);

        for(int row = 0; row < grid.getRows(); row++) {
            for(int i = 1; i < grid.getColumns(); i++) {
                int set = rowState.setFor(grid.getCell(row, i));
                int priorSet = rowState.setFor(grid.getCell(row, i).getWest());
                boolean shouldLink = (set != priorSet && grid.getCell(row, i).getSouth() == null || random.nextDouble() < 0.5);
                if(shouldLink) {
                    grid.getCell(row, i).link(grid.getCell(row, i).getWest(), true);
                    rowState.merge(priorSet, set);
                }
            }
            if(row != grid.getRows() - 1) {
                RowState nextRow = rowState.next();
                Object[] cellsInSetKeysArray = rowState.cellsInSet.keySet().toArray();
                for(int i = 0; i < rowState.cellsInSet.size(); i++) {
                    ArrayList<Cell> actualSet = rowState.cellsInSet.get((int) cellsInSetKeysArray[i]);
                    Collections.shuffle(actualSet);
                    for(int j = 0; j < actualSet.size(); j++) {
                        if(j == 0 || random.nextDouble() < (double) 1 / 3) {
                            actualSet.get(j).link(actualSet.get(j).getSouth(), true);
                            nextRow.record(rowState.setFor(actualSet.get(j)), actualSet.get(j).getSouth());
                        }
                    }
                }
                rowState = nextRow;
            }
        }
    }
}
