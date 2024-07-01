import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowTime extends JFrame {

    //private static final long serialVersionUID = 1L;
    private static final int BIGSIZE = 782;
    private final Grid grid;

    public ShowTime(Grid grid, int numberOfRowsAndColumns, boolean colorize) throws IOException {
        super("Maze Generator");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        if (numberOfRowsAndColumns > 23) {
            this.setSize(BIGSIZE, BIGSIZE);
        } else {
            this.setSize(numberOfRowsAndColumns * 34, numberOfRowsAndColumns * 34);
        }
        this.setLocationRelativeTo(null);
        this.grid = grid;
        GridLayout gridLayout = new GridLayout(this.grid.getRows(), this.grid.getColumns());
        this.setLayout(gridLayout);
        // Coloring
        Distance dis = null;
        int maxDis = 0;
        if (colorize) {
            dis = this.grid.getCell(this.grid.getRows() / 2, this.grid.getColumns() / 2).distance();
            for (int i = 0; i < this.grid.getRows(); i++) {
                for (int j = 0; j < this.grid.getColumns(); j++) {
                    if (maxDis < dis.getDistances(this.grid.getCell(i, j))) {
                        maxDis = dis.getDistances(this.grid.getCell(i, j));
                    }
                }
            }
        }
        //Coloring End
        for(int i = 0; i < this.grid.getRows(); i++) {
            for(int j = 0; j < this.grid.getColumns(); j++) {
                try {
                    if (colorize) {
                        this.add(new Icon(this.pathFinder(this.grid.getCell(i, j)), dis.getDistances(this.grid.getCell(i, j)), maxDis));
                        //System.out.println(dis.getDistances(this.grid.getCell(i, j)));
                    } else {
                        this.add(new Icon(this.pathFinder(this.grid.getCell(i, j))));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.setVisible(true);
    }

    public class Icon extends JLabel {

        //private static final long serialVersionUID = 2L;

        private final ImageIcon imageIcon;

        public Icon(String path) throws IOException {
            super();
            imageIcon = new ImageIcon(path);

        }
        public Icon(String path, int distance, int maxDistance) throws IOException {
            super();
            Image image = null;
            try {
                image = ImageIO.read(new File(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
            BufferedImage buffered = (BufferedImage) image;
            changeColor(buffered, Color.WHITE, /*Color.BLUE,*/ distance, maxDistance);
            imageIcon = new ImageIcon(buffered);

        }
        public void changeColor(BufferedImage bufferedImage, Color oldColor,/* Color newColor,*/ int distance, int maxDistance) {
            int oldRGB = oldColor.getRGB();
            float intensity = (float) (maxDistance - distance) / maxDistance;
            int dark = (int) (255 * intensity);
            int bright = (int) (128 + (127 * intensity));
            Color newColor = new Color(dark, dark, bright); //blue
            //Color newColor = new Color(dark, bright, bright); //bright blue
            //Color newColor = new Color(dark, bright, dark); //green
            //Color newColor = new Color(bright, dark, dark); //red
            //Color newColor = new Color(bright, dark, bright); //violet
            //Color newColor = new Color(bright, bright, dark); //olive green
            //Color newColor = new Color(bright, bright, bright); //grey
            //Color newColor = new Color(dark, dark, dark); //black
            int newRGB = newColor.getRGB();
            for (int i = 0; i < bufferedImage.getWidth(); i++) {
                for (int j = 0; j < bufferedImage.getHeight(); j++) {
                    if (bufferedImage.getRGB(i, j) == oldRGB) {
                        bufferedImage.setRGB(i, j, newRGB);
                    }
                }
            }
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(this.imageIcon.getImage(), 0, 0,
                    getWidth(), getHeight(), this);
        }
    }

    private String pathFinder(Cell cell) {

        String path = "tiles/maze_";
        if (cell.linked(cell.getNorth()))
            path += "n";

        if (cell.linked(cell.getSouth()))
            path += "s";

        if (cell.linked(cell.getWest()))
            path += "w";

        if (cell.linked(cell.getEast()))
            path += "e";

        if (path.equals("tiles/maze_"))
            path = "0";

        return path + ".png";
    }
}
