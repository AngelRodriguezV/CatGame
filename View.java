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
 * @version 1.0
 * @see JFrame
 */
public class View extends JFrame{
    //Variables de clase
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
    private JMenuBar menu;
    private JMenu inicio;
    private JMenuItem item1;
    private JMenuItem item2;
    private String option;
    private boolean activeBoard;
    /**
     * Crea una View por defecto
     */
    public View(){ 
        setTitle("Cat Game");
        setSize(616, 662);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        images = new ImageIcon[3];
        loadImages();
        currentImage = 0;
        createPanel();
        createButtons();
        positionX = -1;
        positionY = -1;
        createMenu();
        option = "OneOnOne";
        activeBoard = true;
    }
    /**
     * Cambia el estado de la tabla
     * @param b un booleano
     */
    public void setActiveBoard(boolean b){
        activeBoard = b;
    }
    /**
     * Obtienes el estado de la tabla
     */
    public boolean getActiveBoard(){
        return activeBoard;
    }
    /**
     * Metodo para cargar las imagenes en el arreglo
     */
    private void loadImages(){
        images[0] = new ImageIcon("image/x.png");
        images[1] = new ImageIcon("image/o.png");
        images[2] = new ImageIcon("image/box.png");
    }
    /**
     * Establece el numero de la imagen actual del arreglo
     * <ul>
     * <li> 0 para establecer la imagen x
     * <li> 1 para establecer la imagen o
     * </ul>
     * @param n Numero entero       
     */
    public void setCurrentImage(int n) {
        currentImage = n;
    }
    /**
     * Obtiene el numero de la imagen actual
     * @return Un numero 0 o 1
     */
    public int getCurrentImage() {
        return currentImage;
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
     * Imprime la imagen actual del jugador
     * @param x cordenada en X
     * @param y cordenada en Y
     */
    private void printImage(int x, int y) {
        panel.updateUI();
        final JLabel label = new JLabel();
        label.setBounds(x, y, 200, 200);
        label.setIcon(images[currentImage]);
        panel.add(label);
    }
    /**
     * Crea los botones
     */
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
    /**
     * Configura el boton y su funcion 
     * @param b un JButton a configurar
     * @param x cordenada en x para el boton
     * @param y cordenada en Y para el boton
     */
    private void createBox(JButton b, int x, int y){
        b.setBounds(x, y, 200, 200);
        b.setIcon(images[2]);
        b.setOpaque(true);
        b.setEnabled(true);
        panel.add(b);

        ActionListener actionBox = new ActionListener() {
            @Override
            public void actionPerformed( ActionEvent ae) {
                positionX = b.getX() / 200;
                positionY = b.getY() / 200;
                panel.remove(b);
                printImage(b.getX(), b.getY());
            }
        };
        b.addActionListener(actionBox);
    }
    /**
     * Bloquea los botones 
     */
    public void lockButtons(){
        box1.setEnabled(false);
        box2.setEnabled(false);
        box3.setEnabled(false);
        box4.setEnabled(false);
        box5.setEnabled(false);
        box6.setEnabled(false);
        box7.setEnabled(false);
        box8.setEnabled(false);
        box9.setEnabled(false);
        activeBoard = false;
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
                currentImage = 0;
                positionX = -1;
                positionY = -1;
                option = "OneOnOne";
                activeBoard = true;;
            }
        };
        item1.addActionListener(actionItem1);
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