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
    
    public static void main(String[] args) {
        View view = new View();
        Player currentPlayer;
        Table table = new Table();
        Queue<Player> queue = new LinkedList<Player>();

        queue.add(new Player("PLAYER 1",'x', 0));
        queue.add(new Player("PLAYER 2",'o', 1));
        currentPlayer = queue.peek();

        int x = 0;
        int y = 0;

        view.setVisible(true);

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

        if (table.gameOver())
            System.out.print("El ganador es:" + currentPlayer.getName());
        else
            System.out.print("Empate");

    }

}