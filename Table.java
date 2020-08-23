/**
 * Esta clase administra la tabla endonde se registran el
 * tiro de cada jugador en la tabla, proporcionando metodos 
 * para verificar si hay casillas disponibles entre otras.
 * <li>Repository on Github 
 * <li>https://github.com/AngelRodriguezV/CatGame
 * @author AngelRodriguezV
 * @version 1.0
 */
public class Table{
  //Variables de Clase
  private char[][] table;
  //Si la tabla esta llena
  private boolean fullBoard;
  //Si el juego ya acabo
  private boolean gameOver;
  /**
   * Costructor por defecto de Table
   */
  public Table(){
    table = new char[3][3];
    fullBoard = false;
    gameOver = false;
  }
  
  /**
   * Agrega el symbolo del jugador a la tabla
   * 
   * @param symbol es el simbolo del jugador
   * @param x      la cordenada en x a posicionar
   * @param y      la cordenada en y a posicionar
   * @throws Exception
   */
  public void add(char symbol, int x, int y) throws Exception {
    if (!isEmptyBox(x, y))
      table[y][x] = symbol;
    else
      throw new Exception();
  }
  /**
   * Obtiene los datos de la tabla con un formato
   * @return los datos de la tabla
   */
  public String print(){
    //Variable auxiliar
    //En aux se va a ir contatenando los datos
    String aux = "";
    //for anidado para recorrer la tabla
    for (int j = 0; j < 3; j++){
      for (int i = 0; i < 3; i++){
        if (table[j][i] == 'x' || table[j][i] == 'o')
          aux += "[" + table[j][i] + "]";
        else
          aux += "[ ]";
      }
      aux += "\n";
    }
    return aux;
  }
  /**
   * Saber si la tabla esta vacia
   * @return false si esta vacia 
   * <li>true si esta lleno
   */
  public boolean isEmptyTable(){
    //Variable auxiliar
    //aux nos ayudara a saber si esta llena la tabla
    int aux = 0;
    //Un for anidado para recorrer la tabla
    for (int j = 0; j < 3; j++)
      for (int i = 0; i < 3; i++)
        if (table[j][i] == 'o' || table[j][i] == 'x')
          aux++;//sumamos uno por cada casilla llena
    //si aux es igual a 9 entonces esta llena
    if (aux == 9)
      return true;
    return false;
  }
  /**
   * Checa si hay un Ganador
   * @return true si hay un ganador
   * <li>false si aun no hay ganador
   */
  public boolean gameOver(){
    //Verificamos si hay jugadas de los jugadores
    check('o');
    check('x');
    return gameOver;
  }
  /**
   * Verifica que no este ocupada una casilla determinada
   * @param x es la cordenada en x
   * @param y es la cordenada en y
   * @return true si esta ocupada
   * <li>false si no esta ocupada
   */
  public boolean isEmptyBox(int x, int y){
    //verifica si esta ocupada la posicion
    if(table[y][x] == 'x' || table[y][x] == 'o')
      return true;
    return false;
  }
  /**
   * Verifica si hay una jugada ganada
   * @param symbol es el simbolo de ultimo jugador en tirar
   */
  private void check(char symbol){
    //Checa si hay una jugada en horizontal
    for (int n = 0; n < 3; n++){
      if (table[n][0] == symbol && table[n][1] == symbol && table[n][2] == symbol)
        gameOver = true;
    }
    //Checa si hay una jugada en vertical
    for (int n = 0; n < 3; n++){
      if (table[0][n] == symbol && table[1][n] == symbol && table[2][n] == symbol)
        gameOver = true;
    }
    //Checan si hay una jugada en diagonal
    if (table[0][0] == symbol && table[1][1] == symbol && table[2][2] == symbol)
      gameOver = true;
    if (table[2][0] == symbol && table[1][1] == symbol && table[0][2] == symbol)
      gameOver = true;
  }
  /**
   * reinicia la tabla
   */
  public void restartTable(){
    table = new char[3][3];
  }
}
  