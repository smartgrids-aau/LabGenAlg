import java.util.*;

public class Kruskals {

    private static class State{
        private Grid grid;
        private ArrayList<Cell[]> neighbours;
        private HashMap<Cell, Integer> setForCell;
        private HashMap<Integer, ArrayList<Cell>> cellsInSet;

        public State(Grid grid){
            this.grid = grid;
            neighbours = new ArrayList<>();
            setForCell = new HashMap<>();
            cellsInSet = new HashMap<>();

            for(int i = 0; i < this.grid.getRows(); i++) {
                for(int j = 0; j < this.grid.getColumns(); j++) {
                    int set = setForCell.size();

                    setForCell.put(grid.getCell(i, j), set);
                    cellsInSet.put(set, new ArrayList<>());
                    cellsInSet.get(set).add(grid.getCell(i, j));
                    if(grid.getCell(i, j).getSouth() != null) {
                        //Cell[] cellPlusSouth = {grid.getCell(i, j), grid.getCell(i, j).getSouth()};
                        neighbours.add(new Cell[] {grid.getCell(i, j), grid.getCell(i, j).getSouth()});
                    }
                    if(grid.getCell(i, j).getEast() != null) {
                        //Cell[] cellPlusEast = {grid.getCell(i, j), grid.getCell(i, j).getEast()};
                        neighbours.add(new Cell[] {grid.getCell(i, j), grid.getCell(i, j).getEast()});
                    }
                }
            }
        }
        public boolean canMerge(Cell left, Cell right) {
            return !Objects.equals(setForCell.get(left), setForCell.get(right));
        }
        public void merge(Cell left, Cell right) {
            left.link(right, true);

            int winner = setForCell.get(left);
            int loser = setForCell.get(right);
            ArrayList<Cell> losers = new ArrayList<>();
            losers = cellsInSet.get(loser);
            for(int i = 0; i < losers.size(); i++) {
                cellsInSet.get(winner).add(losers.get(i));
                setForCell.put(losers.get(i), winner);
            }
            cellsInSet.remove(loser);
        }
    }
    public static long on(Grid grid) {
        Random random = new Random();
        long seed = random.nextLong();
        random.setSeed(seed);
        State state = new State(grid);
        Collections.shuffle(state.neighbours, random);

        while(!state.neighbours.isEmpty()) {
            Cell left = state.neighbours.get(state.neighbours.size() - 1)[0];
            Cell right = state.neighbours.get(state.neighbours.size() - 1)[1];
            state.neighbours.remove(state.neighbours.size() - 1);

            if(state.canMerge(left, right)) {
                state.merge(left, right);
            }
        }
        return seed;
    }
    public static void on(Grid grid, long seed) {
        Random random = new Random(seed);
        State state = new State(grid);
        Collections.shuffle(state.neighbours, random);

        while(!state.neighbours.isEmpty()) {
            Cell left = state.neighbours.get(state.neighbours.size() - 1)[0];
            Cell right = state.neighbours.get(state.neighbours.size() - 1)[1];
            state.neighbours.remove(state.neighbours.size() - 1);

            if(state.canMerge(left, right)) {
                state.merge(left, right);
            }
        }
    }

}
