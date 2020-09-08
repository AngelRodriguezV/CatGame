import java.awt.Color;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/**
 * Esta clase contiene la interfaz Grafica del juego con la
 * que el usuario va a interacctuar
 * <li>Repository on Github 
 * <li>https://github.com/AngelRodriguezV/CatGame
 * @author AngelRodriguezV
 * @version 1.1
 * @see JFrame
 */
public class View extends JFrame{
    //Variables de clase
    private JPanel panel;
    private JButton[] buttons;
    private ImageIcon image;
    private int positionX;
    private int positionY;
    private JMenuBar menu;
    private JMenu inicio;
    private JMenuItem item1;
    private JMenuItem item2;
    private String option;
    /**
     * Crea una View por defecto
     */
    public View(){ 
        setTitle("Cat Game");
        setSize(616, 662);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        image = new ImageIcon("image/box.png");
        buttons = new JButton[9];
        createPanel();
        createButtons();
        positionX = -1;
        positionY = -1;
        createMenu();
        option = "Stop";
    }
    /**
     * Obtiene la cordenada de X
     * @return La posicion en X
     */
    public int getPositionX(){
        return positionX;
    }
    /**
     * Obtiene la cordenada de Y
     * @return La posicion en Y
     */
    public int getPositionY(){
        return positionY;
    }
    /**
     * Crea el panel por defecto
     */
    private void createPanel() {
        panel = new JPanel();
        setLayout(null);
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 600);
        panel.setBackground(Color.BLACK);
        getContentPane().add(panel);
    }
    /**
     * Imprime la imagen del jugador
     * @param x cordenada en X
     * @param y cordenada en Y
     * @param image la imagen del jugador
     */
    public void printImage(int x, int y, ImageIcon image) {
        panel.updateUI();
        final JLabel label = new JLabel();
        label.setBounds(x * 200, y * 200, 200, 200);
        label.setIcon(image);
        panel.add(label);
    }
    /**
     * Crea los botones
     */
    private void createButtons() {
        for (int m = 0;m < 9; m++)
            buttons[m] = new JButton();
        int ij = 0;
        for (int i = 0; i <= 400; i+=200)
            for (int j = 0; j <= 400; j+=200){
                createBox(buttons[ij], j, i);
                ij++;
            }
    }
    /**
     * Configura el boton y su funcion 
     * @param b un JButton a configurar
     * @param x cordenada en x para el boton
     * @param y cordenada en Y para el boton
     */
    private void createBox(JButton b, int x, int y){
        b.setBounds(x, y, 200, 200);
        b.setIcon(image);
        b.setOpaque(true);
        b.setEnabled(true);
        panel.add(b);

        ActionListener actionBox = new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent ae) {
                positionX = b.getX() / 200;
                positionY = b.getY() / 200;
                panel.remove(b);
            }
        };
        b.addActionListener(actionBox);
    }
    
    /**
     * Bloquea los botones 
     */
    public void lockButtons(){
        for (int i = 0; i < 9; i++)
            buttons[i].setEnabled(false);
        option = "Stop";
    }

    /**
     * Crea el menu, con sus respectivas funciones
     */
    private void createMenu(){
        menu = new JMenuBar();
        add(menu);
        setJMenuBar(menu);
        inicio = new JMenu("Inicio");
        menu.add(inicio);
        item1 = new JMenuItem("Nueva Partida");
        item2 = new JMenuItem("Maquina");
        inicio.add(item1);
        inicio.add(item2);
        ActionListener actionItem1 = new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent ae) {
                panel.removeAll();
                panel.updateUI();
                createButtons();
                positionX = -1;
                positionY = -1;
                option = "OneOnOne";
            }
        };
        item1.addActionListener(actionItem1);
        ActionListener actionItem2 = new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent ae) {
                panel.removeAll();
                panel.updateUI();
                createButtons();
                positionX = -1;
                positionY = -1;
                option = "Machine";
            }
        };
        item2.addActionListener(actionItem2);
    }

    /**
     * Obtenemos la opcion del menu
     * @return la opcion del menu
     */
    public String getOption(){
        return option;
    }


    public static void main(final String[] args) {
        final View prueba = new View();
        prueba.setVisible(true);
    }
}