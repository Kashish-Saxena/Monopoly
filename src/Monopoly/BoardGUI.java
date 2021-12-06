package Monopoly;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Box;
import java.awt.Color;
import java.io.*;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class BoardGUI extends JPanel implements Serializable {
    private int[][] boardPosition;
    JLabel[] players;
    JTextArea[] properties;
    int numPlayers;

    private int[][] boardPosition2;
    JLabel[] players2;
    JTextArea[] properties2;
    int numPlayers2;


    private String[] playerIcon = {"Players_Icons/playerOne.jpg", "Players_Icons/playerTwo.jpg", "Players_Icons/playerThree.jpg", "Players_Icons/playerFour.jpg", "Players_Icons/playerFive.jpg", "Players_Icons/playerSix.jpg"};

    public BoardGUI(int numPlayers)
    {
        this.numPlayers = numPlayers;
        this.boardPosition = new int[40][2];
        this.players = new JLabel[numPlayers];
        this.properties = new JTextArea[22];

        this.setSize(500, 500);
        this.setLayout(null);

        for(int x = 0; x < numPlayers; x++)
        {
            this.players[x] = new JLabel();
            this.players[x].setIcon(new ImageIcon(BoardGUI.class.getResource(playerIcon[x])));
            this.players[x].setSize(20, 20);
            this.movement(x, 0);
            this.players[x].setOpaque(true);
            this.add(this.players[x]);
        }


        Box createBox = Box.createVerticalBox();
        createBox.setBorder(new LineBorder(new Color(0, 0, 0)));
        createBox.setBounds(550, 550, 100, 100);
        add(createBox);

        Box property1 = Box.createVerticalBox();
        property1.setBorder(new LineBorder(new Color(0, 0, 0)));
        property1.setBounds(500, 550, 50, 100);
        add(property1);

        JLabel colourOne = new JLabel("");
        colourOne.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/purple.jpg")));
        property1.add(colourOne);

        properties[0] = new JTextArea();
        properties[0].setEditable(false);
        properties[0].setLineWrap(true);
        properties[0].setText("Property");
        property1.add(properties[0]);

        Box property2 = Box.createVerticalBox();
        property2.setBorder(new LineBorder(new Color(0, 0, 0)));
        property2.setBounds(450, 550, 50, 100);
        add(property2);


        Box property3 = Box.createVerticalBox();
        property3.setBorder(new LineBorder(new Color(0, 0, 0)));
        property3.setBounds(400, 550, 50, 100);
        add(property3);

        JLabel colourTwo = new JLabel("");
        colourTwo.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/purple.jpg")));
        property3.add(colourTwo);

        properties[1] = new JTextArea();
        properties[1].setEditable(false);
        properties[1].setLineWrap(true);
        properties[1].setText("Property");
        property3.add(properties[1]);

        Box property4 = Box.createVerticalBox();
        property4.setBorder(new LineBorder(new Color(0, 0, 0)));
        property4.setBounds(350, 550, 50, 100);
        add(property4);

        Box property5 = Box.createVerticalBox();
        property5.setBorder(new LineBorder(new Color(0, 0, 0)));
        property5.setBounds(300, 550, 50, 100);
        add(property5);


        Box property6 = Box.createVerticalBox();
        property6.setBorder(new LineBorder(new Color(0, 0, 0)));
        property6.setBounds(250, 550, 50, 100);
        add(property6);

        JLabel colourThree = new JLabel("");
        colourThree.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/blue.jpg")));
        property6.add(colourThree);

        properties[2] = new JTextArea();
        properties[2].setEditable(false);
        properties[2].setLineWrap(true);
        properties[2].setText("Property");
        property6.add(properties[2]);

        Box property7 = Box.createVerticalBox();
        property7.setBorder(new LineBorder(new Color(0, 0, 0)));
        property7.setBounds(200, 550, 50, 100);
        add(property7);

        Box property8 = Box.createVerticalBox();
        property8.setBorder(new LineBorder(new Color(0, 0, 0)));
        property8.setBounds(150, 550, 50, 100);
        add(property8);

        JLabel colourFour = new JLabel("");
        colourFour.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/blue.jpg")));
        property8.add(colourFour);

        properties[3] = new JTextArea();
        properties[3].setEditable(false);
        properties[3].setLineWrap(true);
        properties[3].setText("Property");
        property8.add(properties[3]);

        Box property9 = Box.createVerticalBox();
        property9.setBorder(new LineBorder(new Color(0, 0, 0)));
        property9.setBounds(100, 550, 50, 100);
        add(property9);

        JLabel colourFive = new JLabel("");
        colourFive.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/blue.jpg")));
        property9.add(colourFive);

        properties[4] = new JTextArea();
        properties[4].setEditable(false);
        properties[4].setLineWrap(true);
        properties[4].setText("Property");
        property9.add(properties[4]);

        Box property10 = Box.createHorizontalBox();
        property10.setBorder(new LineBorder(new Color(0, 0, 0)));
        property10.setBounds(0, 500, 100, 50);
        add(property10);

        properties[5] = new JTextArea();
        properties[5].setEditable(false);
        properties[5].setLineWrap(true);
        properties[5].setText("Property");
        property10.add(properties[5]);

        JLabel colourSix = new JLabel("");
        colourSix.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/magenta.jpg")));
        property10.add(colourSix);

        Box property11 = Box.createHorizontalBox();
        property11.setBorder(new LineBorder(new Color(0, 0, 0)));
        property11.setBounds(0, 450, 100, 50);
        add(property11);

        Box property12 = Box.createHorizontalBox();
        property12.setBorder(new LineBorder(new Color(0, 0, 0)));
        property12.setBounds(0, 400, 100, 50);
        add(property12);

        properties[6] = new JTextArea();
        properties[6].setEditable(false);
        properties[6].setLineWrap(true);
        properties[6].setText("Property");
        property12.add(properties[6]);

        JLabel colourSeven = new JLabel("");
        colourSeven.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/magenta.jpg")));
        property12.add(colourSeven);

        Box property13 = Box.createHorizontalBox();
        property13.setBorder(new LineBorder(new Color(0, 0, 0)));
        property13.setBounds(0, 350, 100, 50);
        add(property13);

        properties[7] = new JTextArea();
        properties[7].setEditable(false);
        properties[7].setLineWrap(true);
        properties[7].setText("Property");
        property13.add(properties[7]);

        JLabel colourEight = new JLabel("");
        colourEight.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/magenta.jpg")));
        property13.add(colourEight);

        Box property14 = Box.createHorizontalBox();
        property14.setBorder(new LineBorder(new Color(0, 0, 0)));
        property14.setBounds(0, 300, 100, 50);
        add(property14);

        Box property15 = Box.createHorizontalBox();
        property15.setBorder(new LineBorder(new Color(0, 0, 0)));
        property15.setBounds(0, 250, 100, 50);
        add(property15);

        properties[8] = new JTextArea();
        properties[8].setEditable(false);
        properties[8].setLineWrap(true);
        properties[8].setText("Property");
        property15.add(properties[8]);

        JLabel colourNine = new JLabel("");
        colourNine.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/orange.jpg")));
        property15.add(colourNine);

        Box property16 = Box.createHorizontalBox();
        property16.setBorder(new LineBorder(new Color(0, 0, 0)));
        property16.setBounds(0, 200, 100, 50);
        add(property16);

        Box property17 = Box.createHorizontalBox();
        property17.setBorder(new LineBorder(new Color(0, 0, 0)));
        property17.setBounds(0, 150, 100, 50);
        add(property17);

        properties[9] = new JTextArea();
        properties[9].setEditable(false);
        properties[9].setLineWrap(true);
        properties[9].setText("Property");
        property17.add(properties[9]);

        JLabel colourOne0 = new JLabel("");
        colourOne0.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/orange.jpg")));
        property17.add(colourOne0);

        Box property18 = Box.createHorizontalBox();
        property18.setBorder(new LineBorder(new Color(0, 0, 0)));
        property18.setBounds(0, 100, 100, 50);
        add(property18);

        properties[10] = new JTextArea();
        properties[10].setEditable(false);
        properties[10].setLineWrap(true);
        properties[10].setText("Property");
        property18.add(properties[10]);

        JLabel colourOne1 = new JLabel("");
        colourOne1.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/orange.jpg")));
        property18.add(colourOne1);

        Box property19 = Box.createVerticalBox();
        property19.setBorder(new LineBorder(new Color(0, 0, 0)));
        property19.setBounds(100, 0, 50, 100);
        add(property19);

        properties[11] = new JTextArea();
        properties[11].setEditable(false);
        properties[11].setLineWrap(true);
        properties[11].setText("Property");
        property19.add(properties[11]);

        JLabel colourOne2 = new JLabel("");
        colourOne2.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/red.jpg")));
        property19.add(colourOne2);

        Box property20 = Box.createVerticalBox();
        property20.setBorder(new LineBorder(new Color(0, 0, 0)));
        property20.setBounds(150, 0, 50, 100);
        add(property20);

        Box property21 = Box.createVerticalBox();
        property21.setBorder(new LineBorder(new Color(0, 0, 0)));
        property21.setBounds(200, 0, 50, 100);
        add(property21);

        properties[12] = new JTextArea();
        properties[12].setEditable(false);
        property21.add(properties[12]);
        properties[12].setLineWrap(true);
        properties[12].setText("Property");

        JLabel colourOne3 = new JLabel("");
        colourOne3.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/red.jpg")));
        colourOne3.setSize(50, 30);
        property21.add(colourOne3);

        Box property22 = Box.createVerticalBox();
        property22.setBorder(new LineBorder(new Color(0, 0, 0)));
        property22.setBounds(250, 0, 50, 100);
        add(property22);

        properties[13] = new JTextArea();
        properties[13].setEditable(false);
        properties[13].setLineWrap(true);
        properties[13].setText("Property");
        property22.add(properties[13]);

        JLabel colourOne4 = new JLabel("");
        colourOne4.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/red.jpg")));
        property22.add(colourOne4);

        Box property23 = Box.createVerticalBox();
        property23.setBorder(new LineBorder(new Color(0, 0, 0)));
        property23.setBounds(300, 0, 50, 100);
        add(property23);

        Box property24 = Box.createVerticalBox();
        property24.setBorder(new LineBorder(new Color(0, 0, 0)));
        property24.setBounds(350, 0, 50, 100);
        add(property24);

        properties[14] = new JTextArea();
        properties[14].setEditable(false);
        properties[14].setLineWrap(true);
        properties[14].setText("Property");
        property24.add(properties[14]);

        JLabel colourOne5 = new JLabel("");
        colourOne5.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/yellow.jpg")));
        property24.add(colourOne5);

        Box property25 = Box.createVerticalBox();
        property25.setBorder(new LineBorder(new Color(0, 0, 0)));
        property25.setBounds(400, 0, 50, 100);
        add(property25);

        properties[15] = new JTextArea();
        properties[15].setEditable(false);
        properties[15].setLineWrap(true);
        properties[15].setText("Property");
        property25.add(properties[15]);

        JLabel colourOne6 = new JLabel("");
        colourOne6.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/yellow.jpg")));
        property25.add(colourOne6);

        Box property26 = Box.createVerticalBox();
        property26.setBorder(new LineBorder(new Color(0, 0, 0)));
        property26.setBounds(450, 0, 50, 100);
        add(property26);

        Box property27 = Box.createVerticalBox();
        property27.setBorder(new LineBorder(new Color(0, 0, 0)));
        property27.setBounds(500, 0, 50, 100);
        add(property27);

        properties[16] = new JTextArea();
        properties[16].setEditable(false);
        properties[16].setLineWrap(true);
        properties[16].setText("Property");
        property27.add(properties[16]);

        JLabel colourOne7 = new JLabel("");
        colourOne7.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/yellow.jpg")));
        property27.add(colourOne7);


        Box property28 = Box.createHorizontalBox();
        property28.setBorder(new LineBorder(new Color(0, 0, 0)));
        property28.setBounds(550, 100, 100, 50);
        add(property28);

        JLabel colourOne8 = new JLabel("");
        colourOne8.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/green.jpg")));
        property28.add(colourOne8);

        properties[17] = new JTextArea();
        properties[17].setEditable(false);
        properties[17].setLineWrap(true);
        properties[17].setText("Property");
        property28.add(properties[17]);

        Box property29 = Box.createHorizontalBox();
        property29.setBorder(new LineBorder(new Color(0, 0, 0)));
        property29.setBounds(550, 150, 100, 50);
        add(property29);

        JLabel colourOne9 = new JLabel("");
        colourOne9.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/green.jpg")));
        property29.add(colourOne9);

        properties[18] = new JTextArea();
        properties[18].setEditable(false);
        properties[18].setLineWrap(true);
        properties[18].setText("Property");
        property29.add(properties[18]);

        Box property30 = Box.createHorizontalBox();
        property30.setBorder(new LineBorder(new Color(0, 0, 0)));
        property30.setBounds(550, 200, 100, 50);
        add(property30);

        Box property31 = Box.createHorizontalBox();
        property31.setBorder(new LineBorder(new Color(0, 0, 0)));
        property31.setBounds(550, 250, 100, 50);
        add(property31);

        JLabel colourTwo0 = new JLabel("");
        colourTwo0.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/green.jpg")));
        property31.add(colourTwo0);

        properties[19] = new JTextArea();
        properties[19].setEditable(false);
        properties[19].setLineWrap(true);
        properties[19].setText("Property");
        property31.add(properties[19]);

        Box property32 = Box.createHorizontalBox();
        property32.setBorder(new LineBorder(new Color(0, 0, 0)));
        property32.setBounds(550, 300, 100, 50);
        add(property32);


        Box property33 = Box.createHorizontalBox();
        property33.setBorder(new LineBorder(new Color(0, 0, 0)));
        property33.setBounds(550, 350, 100, 50);
        add(property33);

        Box property34 = Box.createHorizontalBox();
        property34.setBorder(new LineBorder(new Color(0, 0, 0)));
        property34.setBounds(550, 400, 100, 50);
        add(property34);

        JLabel colourTwo1 = new JLabel("");
        colourTwo1.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/darkBlue.jpg")));
        property34.add(colourTwo1);

        properties[20] = new JTextArea();
        properties[20].setEditable(false);
        properties[20].setLineWrap(true);
        properties[20].setText("Property");
        property34.add(properties[20]);

        Box property35 = Box.createHorizontalBox();
        property35.setBorder(new LineBorder(new Color(0, 0, 0)));
        property35.setBounds(550, 450, 100, 50);
        add(property35);

        Box property36 = Box.createHorizontalBox();
        property36.setBorder(new LineBorder(new Color(0, 0, 0)));
        property36.setBounds(550, 500, 100, 50);
        add(property36);

        JLabel colourTwo2 = new JLabel("");
        colourTwo2.setIcon(new ImageIcon(BoardGUI.class.getResource("/Monopoly/Colours/darkBlue.jpg")));
        property36.add(colourTwo2);

        properties[21] = new JTextArea();
        properties[21].setEditable(false);
        properties[21].setLineWrap(true);
        properties[21].setText("Property");
        property36.add(properties[21]);
    }

    public void movement(int player, int position)
    {
        if(position < 11 || (position > 19 && position < 31))
        {
            this.players[player].setBounds(this.boardPosition[position][0], this.boardPosition[position][1] + (player*21), 20, 20);
        }
        else
        {
            this.players[player].setBounds(this.boardPosition[position][0] + (player*21), this.boardPosition[position][1], 20, 20);
        }
    }

    /**
     * saves/serializes this BoardGUI object.
     */
    public void serializeBoardGUI (String filename){
        try {
            FileOutputStream fileOut = new FileOutputStream("saves/" + filename + "_game");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * loads/deserializes BoardGUI object.
     */
    public static BoardGUI deserializeBoardGUI(String filepath) {
        try {
            FileInputStream fileIn = new FileInputStream("saves/" +filepath+ "_game");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            BoardGUI gui = (BoardGUI) objectIn.readObject();
            objectIn.close();
            return gui;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void saveState(){
        this.boardPosition2 = boardPosition;
        this.players2 = players;
        this.properties2 = properties;
        this.numPlayers2 = numPlayers;
    }

    public void loadState(){
        boardPosition = this.boardPosition2;
        players = this.players2;
        properties = this.properties2;
        numPlayers = this.numPlayers2;
    }

}
