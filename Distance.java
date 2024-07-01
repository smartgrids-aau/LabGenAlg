import java.util.HashMap;

public class Distance {

    private Cell root;
    private HashMap<Cell, Integer> distances;

    public Distance(Cell root) {
        this.root = root;
        distances = new HashMap<>();
        distances.put(root, 0);
    }

    public Integer getDistances(Cell cell) {
        return distances.get(cell);
    }
    public void setDistances(Cell cell, int distance) {
        distances.put(cell, distance);
    }
}
