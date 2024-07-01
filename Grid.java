import java.util.Random;

public class Grid {

    private int rows;
    private int columns;
    private Cell[][] grid;

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = prepareGrid();
        configureCells();
    }

    public Cell[][] prepareGrid() {
        Cell[][] c = new Cell[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                c[i][j] = new Cell(i, j);
            }
        }
        return c;
    }

    public void configureCells() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                grid[i][j].setNorth(customArrayAccessor(i-1, j));
                grid[i][j].setSouth(customArrayAccessor(i+1, j));
                grid[i][j].setWest(customArrayAccessor(i, j-1));
                grid[i][j].setEast(customArrayAccessor(i, j+1));
            }
        }
    }

    public Cell customArrayAccessor(int row, int column) {
        Cell c = null;
        if(0 <= row && row < rows && 0 <= column && column < columns) {
            c = grid[row][column];
        }
        return c;
    }

    public Cell randomCell() {
        int row;
        int column;
        row = (int) (Math.random() * rows);
        column = (int) (Math.random() * grid[row].length);
        return this.grid[row][column];
    }

    public Cell randomCell(long seed) {
        Random random = new Random(seed);
        int row;
        int column;
        row = (int) (random.nextDouble() * rows);
        column = (int) (random.nextDouble() * grid[row].length);
        return this.grid[row][column];
    }

    public int size() {
        return rows * columns;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Cell getCell(int row, int column) {
        return this.grid[row][column];
    }
}
