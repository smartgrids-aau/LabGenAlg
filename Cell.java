import java.util.*;

public class Cell {

    private int row;
    private int column;
    private Cell north;
    private Cell south;
    private Cell west;
    private Cell east;
    private Distance distance;
    private boolean visited = false;

    private HashMap<Cell, Boolean> map;
    private ArrayList<Cell> list;
    private ArrayList<Cell> unVisitedNeighbours;

    public Cell(int row, int column) {
        this.row = row;
        this.column = column;
        this.map = new HashMap<>();
    }

    public void setNorth(Cell n) {
        this.north = n;
    }
    public void setSouth(Cell s) {
        this.south = s;
    }
    public void setWest(Cell w) {
        this.west = w;
    }
    public void setEast(Cell e) {
        this.east = e;
    }
    public Cell getNorth() {
        return this.north;
    }
    public Cell getSouth() {
        return this.south;
    }
    public Cell getWest() {
        return this.west;
    }
    public Cell getEast() {
        return this.east;
    }
    public int getColumn(){
        return column;
    }
    public HashMap<Cell, Boolean> getMap() {
        return map;
    }
    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void link(Cell c, boolean bidi) {
        map.put(c, true);
        if (bidi) {
            c.link(this, false);
        }
    }

    public void unlink(Cell c, boolean bidi) {
        map.remove(c);
        if (bidi) {
            c.unlink(this, false);
        }
    }

    public ArrayList<Cell> links() {
        return new ArrayList<>(map.keySet());
    }

    public boolean linked(Cell c) {
        return map.containsKey(c);
    }

    public ArrayList<Cell> neighbors() {
        list = new ArrayList<Cell>();
        if(north != null) {
            list.add(north);
        }
        if(south != null) {
            list.add(south);
        }
        if(west != null) {
            list.add(west);
        }
        if(east != null) {
            list.add(east);
        }
        return list;
    }

    public ArrayList<Cell> unVisitedNeighbors() {
        unVisitedNeighbours = new ArrayList<Cell>();
        if(north != null && !north.getVisited()) {
            unVisitedNeighbours.add(north);
        }
        if(south != null && !south.getVisited()) {
            unVisitedNeighbours.add(south);
        }
        if(west != null && !west.getVisited()) {
            unVisitedNeighbours.add(west);
        }
        if(east != null && !east.getVisited()) {
            unVisitedNeighbours.add(east);
        }
        return unVisitedNeighbours;
    }

    public Distance distance() {
        distance = new Distance(this);
        ArrayList<Cell> frontier = new ArrayList<>();
        frontier.add(this);
        while(!frontier.isEmpty()) {
            ArrayList<Cell> newFrontier = new ArrayList<>();
            for (int i = 0; i < frontier.size(); i++) {
                for (int j = 0; j < frontier.get(i).links().size(); j++) {
                    Integer unvisitedDistance = distance.getDistances(frontier.get(i).links().get(j));
                    Cell unvisited = frontier.get(i).links().get(j);
                    if (unvisitedDistance == null) {
                        Integer before = distance.getDistances(frontier.get(i));
                        distance.setDistances(unvisited, before + 1);
                        newFrontier.add(unvisited);
                    }
                }
            }
            frontier = newFrontier;
        }
        return distance;
    }

}
