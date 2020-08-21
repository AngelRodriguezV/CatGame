import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame{
    
    private JPanel panel;
    private JButton box1;
    private JButton box2;
    private JButton box3;
    private JButton box4;
    private JButton box5;
    private JButton box6;
    private JButton box7;
    private JButton box8;
    private JButton box9;
    private ImageIcon[] images;
    private int currentImage;
    private int positionX;
    private int positionY;
    
    public View(){
        setTitle("Cat Game");
        setSize(616, 639);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        images = new ImageIcon[3];
        loadImages();
        currentImage = 0;
        createPanel();
        createButtons();
        positionX = 0;
        positionY = 0;
    }

    private void loadImages(){
        images[0] = new ImageIcon("image/x.png");
        images[1] = new ImageIcon("image/o.png");
        images[2] = new ImageIcon("image/box.png");
    }

    public void setCurrentImage(final int n) {
        currentImage = n;
    }

    public int getCurrentImage() {
        return currentImage;
    }

    public int getPositionX(){
        return positionX;
    }

    public int getPositiony(){
        return positionY;
    }

    private void createPanel() {
        panel = new JPanel();
        setLayout(null);
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 600);
        panel.setBackground(Color.BLACK);
        getContentPane().add(panel);
    }

    private void printImage(final int x, final int y) {
        panel.updateUI();
        final JLabel label = new JLabel();
        label.setBounds(x, y, 200, 200);
        label.setIcon(images[currentImage]);
        panel.add(label);
    }

    private void createButtons() {
        box1 = new JButton();
        box2 = new JButton();
        box3 = new JButton();
        box4 = new JButton();
        box5 = new JButton();
        box6 = new JButton();
        box7 = new JButton();
        box8 = new JButton();
        box9 = new JButton();
        createBox(box1, 0, 0);
        createBox(box2, 200, 0);
        createBox(box3, 400, 0);
        createBox(box4, 0, 200);
        createBox(box5, 200, 200);
        createBox(box6, 400, 200);
        createBox(box7, 0, 400);
        createBox(box8, 200, 400);
        createBox(box9, 400, 400);
    }
        

    private void createBox(JButton b, int x, int y){
        b.setBounds(x, y, 200, 200);
        b.setIcon(images[2]);
        b.setOpaque(true);
        b.setEnabled(true);
        panel.add(b);

        final ActionListener actionBox = new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                panel.remove(b);
                printImage(b.getX(), b.getY());
                positionX = b.getX() / 200;
                positionY = b.getY() / 200;
            }
        };
        b.addActionListener(actionBox);
    }
    
    public static void main(final String[] args) {
        final View prueba = new View();
        prueba.setVisible(true);
    }
}