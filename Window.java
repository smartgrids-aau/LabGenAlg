import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame{

    //private static final long serialVersionUID = 3L;

    private static final int SIZE = 300;
    private static final int MIN = 4;
    private static final int MAX = 1000;
    private long seed;

    public Window() throws NumberFormatException{
        super("Maze Generator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(SIZE, SIZE);
        this.setLocationRelativeTo(null);
        JLabel label = new JLabel("Number of rows/columns:");
        label.setBounds(50, 40, 200, 20);
        JTextField textField = new JTextField();
        textField.setBounds(230, 40, 40, 20);
        JLabel labelSeed = new JLabel("Seed:");
        labelSeed.setBounds(50, 75, 200, 20);
        JTextField textFieldSeed = new JTextField();
        textFieldSeed.setBounds(130, 75, 150, 20);
        this.add(label);
        this.add(textField);
        this.add(labelSeed);
        this.add(textFieldSeed);
        String[] algorithms = {"Aldous-Broder", "Binary Tree", "Hunt-and-Kill",
                "Kruskal's", "Recursive Backtracker", "Sidewinder",
                "Simplified Prim's", "True Prim's", "Wilson's",
                "Alternating Binary Tree", "Checkback Binary Tree", "Checkback Binary Tree 2*2",
                "Sectored Checkback Binary Tree", "Sectored Checkback Binary Tree 2*2", "Snail", "Policsek"};
        JComboBox<String> comboBox = new JComboBox<>(algorithms);
        comboBox.setBounds(50, 115,180,20);
        JButton button = new JButton("Generate");
        button.setBounds(85,175,125,20);
        JButton buttonSeed = new JButton("Get Seed!");
        buttonSeed.setBounds(85,200,125,20);
        JCheckBox checkBox = new JCheckBox("Colorize");
        checkBox.setBounds(85, 150, 150, 20);
        this.add(comboBox);
        this.add(button);
        this.add(buttonSeed);
        this.add(checkBox);
        this.setLayout(null);
        this.setVisible(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int numberOfRowsAndColumns = Integer.parseInt(textField.getText());
                    if(numberOfRowsAndColumns < MIN || MAX < numberOfRowsAndColumns) {
                        throw new NumberFormatException();
                    }
                    String str = textFieldSeed.getText();
                    if (!str.isEmpty()) {
                        seed = Long.parseLong(textFieldSeed.getText());
                    }
                    Grid grid = new Grid(numberOfRowsAndColumns, numberOfRowsAndColumns);
                    int index = comboBox.getSelectedIndex();
                    switch (index) {
                        case 0:
                            if (str.isEmpty()) {
                                seed = AldousBroder.on(grid);
                            } else {
                                AldousBroder.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 1:
                            if (str.isEmpty()) {
                                seed = BinaryTree.on(grid);
                            } else {
                                BinaryTree.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 2:
                            if (str.isEmpty()) {
                                seed = HuntAndKill.on(grid);
                            } else {
                                HuntAndKill.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 3:
                            if (str.isEmpty()) {
                                seed = Kruskals.on(grid);
                            } else {
                                Kruskals.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 4:
                            if (str.isEmpty()) {
                                seed = RecursiveBacktracker.on(grid);
                            } else {
                                RecursiveBacktracker.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 5:
                            if (str.isEmpty()) {
                                seed = Sidewinder.on(grid);
                            } else {
                                Sidewinder.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 6:
                            if (str.isEmpty()) {
                                seed = SimplifedPrims.on(grid);
                            } else {
                                SimplifedPrims.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 7:
                            if (str.isEmpty()) {
                                seed = TruePrims.on(grid);
                            } else {
                                TruePrims.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 8:
                            if (str.isEmpty()) {
                                seed = Wilsons.on(grid);
                            } else {
                                Wilsons.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 9:
                            if (str.isEmpty()) {
                                seed = AlternatingBinaryTree.on(grid);
                            } else {
                                AlternatingBinaryTree.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 10:
                            if (str.isEmpty()) {
                                seed = CheckbackBinaryTree.on(grid);
                            } else {
                                CheckbackBinaryTree.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 11:
                            if (str.isEmpty()) {
                                seed = CheckbackBinaryTree2x2.on(grid);
                            } else {
                                CheckbackBinaryTree2x2.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 12:
                            if (str.isEmpty()) {
                                seed = SectoredBinaryTree.on(grid);
                            } else {
                                SectoredBinaryTree.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 13:
                            if (str.isEmpty()) {
                                seed = SectoredBinaryTree2x2.on(grid);
                            } else {
                                SectoredBinaryTree2x2.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 14:
                            if (str.isEmpty()) {
                                seed = Snail.on(grid);
                            } else {
                                Snail.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;
                        case 15:
                            if (str.isEmpty()) {
                                seed = Policsek.on(grid);
                            } else {
                                Policsek.on(grid, seed);
                            }
                            new ShowTime(grid, numberOfRowsAndColumns, checkBox.isSelected());
                            break;

                    }
                } catch (Exception ex) {
                    //ex.printStackTrace();
                    JFrame frame = new JFrame("Not a valid input!");
                    frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    JLabel panel = new JLabel("Number of Rows/Columns need to be an integer between " + MIN + " and " + MAX + " !");
                    JLabel panel2 = new JLabel("Seed need to be unset or a long!");
                    panel.setBounds(75,20,400,20);
                    panel2.setBounds(170, 40, 400, 20);
                    frame.add(panel);
                    frame.add(panel2);
                    frame.setSize(500, 120);
                    frame.setLayout(null);
                    frame.setVisible(true);
                }
            }
        });
        buttonSeed.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldSeed.setText(String.valueOf(seed));
            }
        });
    }

}