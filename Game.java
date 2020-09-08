import java.util.LinkedList;
import java.util.Queue;

import javax.swing.ImageIcon;
/**
 * Esta clase tiene el main principal
 * <li>Repository on Github 
 * <li>https://github.com/AngelRodriguezV/CatGame
 * @author AngelRodriguezV
 * @version 1.1
 */
public class Game {
  //Variables de clase
  public View view;
  public Table table;
  public Player currentPlayer;
  public Queue<Player> players;
  public Player player1;
  public Player player2;
  public Player machine;
  /**
   * Constructor por defecto
   */
  public Game(){
    view = new View();
    table = new Table();
    players = new LinkedList<>();
    player1 = new Player("Player 1", 'x', new ImageIcon("image/x.png"));
    player2 = new Player("Player 2", 'o', new ImageIcon("image/o.png"));
    machine = new Player("Machine", 'x', new ImageIcon("image/x.png"));
    currentPlayer = players.peek();
  }
  /**
   * Iniciar juego uno contra uno
   */
  public void OneOnOne(){
    while (!table.gameOver() && view.getActive()){
      if (!table.isEmptyTable()){
          try {
            currentPlayer = players.peek();
            table.add(view.getPositionX(), view.getPositionY(), currentPlayer.getSymbol());
            view.printImage(view.getPositionX(), view.getPositionY(), currentPlayer.getImage());
            System.out.println(currentPlayer.getName());
            System.out.println(table.toString());
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
   * Iniciar juego contra la maquina
   */
  public void counterMachine(){
    while (!table.gameOver() && view.getActive()){
      if (!table.isEmptyTable()){
          try {
            currentPlayer = players.peek();
            if (currentPlayer.equals(player2)){
              table.add(view.getPositionX(), view.getPositionY(), currentPlayer.getSymbol());
              view.printImage(view.getPositionX(), view.getPositionY(), currentPlayer.getImage());
            }
            else{
              int auxX = (int)(Math.random() * 6);
              int auxY = (int)(Math.random() * 6);
              table.add(auxX, auxY, currentPlayer.getSymbol());
              view.printImage(auxX, auxY, currentPlayer.getImage());
            }
            System.out.println(currentPlayer.getName());
            System.out.println(table.toString());
            players.add(players.poll());
          } catch (Exception e) {}
      }
      else break;
    }
    view.lockButtons();
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
    game.view.lockButtons();
    while (true){
      String option = game.view.getOption();
      switch (option) {
        case "OneOnOne":
          System.out.println("\n---NUEVA PARTIDA UNO VS UNO---");
            game.players.clear();
            game.players.add(game.player1);
            game.players.add(game.player2);
            game.table.restartTable();
            game.OneOnOne();
          break;
        case "Machine":
            System.out.println("\n---NUEVA PARTIDA CONTRA LA MAQUINA---");
            game.players.clear();
            game.players.add(game.machine);
            game.players.add(game.player2);
            game.table.restartTable();
            game.counterMachine();
          break;
      }
    }
  }

  
}