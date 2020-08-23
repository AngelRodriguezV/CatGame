import java.util.LinkedList;
import java.util.Queue;
/**
 * Esta clase tiene el main principal
 * <li>Repository on Github 
 * <li>https://github.com/AngelRodriguezV/CatGame
 * @author AngelRodriguezV
 * @version 1.0
 */
public class Game {
  //Variables de clase
  public View view;
  public Table table;
  public Player currentPlayer;
  public Queue<Player> players;
  public Player player1;
  public Player player2;
  /**
   * Constructor por defecto
   */
  public Game(){
    view = new View();
    table = new Table();
    players = new LinkedList<>();
    player1 = new Player("Player 1", 'x');
    player2 = new Player("Player 2", 'o');
    players.add(player1);
    players.add(player2);
    currentPlayer = players.peek();
  }
  /**
   * Iniciar juego uno contra uno
   */
  public void OneOnOne(){
    while (!table.gameOver()){
      if (!table.isEmptyTable()){
          try {
            currentPlayer = players.peek();
            table.add(currentPlayer.getSymbol(), view.getPositionX(), view.getPositionY());
            view.setCurrentImage(currentPlayer.getNumber());
            System.out.println(currentPlayer.getName());
            System.out.println(table.print());
            players.add(players.poll());
          } catch (Exception e) {}
      }
      else break;
    }
    view.lockButtons();
    //Verificar quien gano
    if (table.gameOver())
      System.out.print("El ganador es:" + currentPlayer.getName());
    else
      System.out.print("Empate");
  }

  /**
   * Funcion principal del juego
   * @param args
   */
  public static void main(String[] args) {
    Game game = new Game();
    game.view.setVisible(true);
    game.OneOnOne();
  }

  
}