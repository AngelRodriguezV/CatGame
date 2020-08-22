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
  /**
   * Funcion principal del juego
   * @param args
   */
  public static void main(String[] args) {
    //Instanceamos una View
    View view = new View();
    //Instanceamos un Player
    Player currentPlayer;
    //Insatanceamos una tabla
    Table table = new Table();
    //Instanceamos un Queue de Player
    Queue<Player> queue = new LinkedList<Player>();
    //Agregamos los jugadores al Queue
    queue.add(new Player("PLAYER 1",'x'));
    queue.add(new Player("PLAYER 2",'o'));
    currentPlayer = queue.peek();
    //X y Y capturaran las cordenadas del View
    int x = 0;
    int y = 0;
    //HAcemos visible al View
    view.setVisible(true);
    //Bucle principal
    while (!table.gameOver()) {
      if (!table.isEmptyTable()) {
        try {
          currentPlayer = queue.peek();
          x = view.getPositionX();
          y = view.getPositionY();
          if (!table.isEmptyBox(x,y)){
            table.add(currentPlayer.getSymbol(),x,y);
            view.setCurrentImage(currentPlayer.getNumber());
            System.out.println(currentPlayer.getName());
            System.out.println(table.print());
            queue.add(queue.poll());
          }
          else
            throw new Exception();
        }
        catch (Exception e) {
        }
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

}