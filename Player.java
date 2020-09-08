import javax.swing.ImageIcon;

/**
 * Esta clase contendra los datos del jugador
 * <li>Repository on Github 
 * <li>https://github.com/AngelRodriguezV/CatGame
 * @author AngelRodriguezV
 * @version 1.0
 */
public class Player {
  //Variables de clase
  private String name;
  private char symbol;
  private ImageIcon image;
  /**
   * Costrucctor de Player
   * <li>Los Symbolos permitidos son 'x' y 'o'
   * <li>Los numeros permitidos son '0' y '1'
   * <li>Para el symbol 'x' debe ir con el number '0'
   * <li>Y para el symbol 'o' el number '1'
   * @param name el nombre del jugador
   * @param symbol el simbolo que lo representa
   * @param image la imagen de jugador
   */
  public Player(String name, char symbol,ImageIcon image) {
    this.name = name;
    this.symbol = symbol;
    this.image = image;
  }
  /**
   * Obtenemos el nombre del jugador
   * @return el nombre del jugador
   */
  public String getName() {
    return name;
  }
  /**
   * Obtenemos el simbolo del jugador
   * @return el simbolo del jugador
   */
  public char getSymbol() {
    return symbol;
  }
  /**
   * Obtenemos el numero del jugador
   * @return el numero del jugador
   */
  public ImageIcon getImage(){
    return image;
  }
}
  