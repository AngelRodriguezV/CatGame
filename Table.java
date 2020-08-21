public class Table{
    char[][] table;
    boolean fullBoard;
    boolean gameOver;
    public Table(){
      table = new char[3][3];
    }
  
    public void add(char element, int x, int y){
      table[x][y] = element;
      fullBoard = false;
      gameOver = false;
    }
  
    public String print(){
      String aux = "";
      for (int j = 0; j < 3; j++) {
        for (int i = 0; i < 3; i++)  {
          if (table[j][i] == 'x' || table[j][i] == 'o')
            aux += "[" + table[j][i] + "]";
          else
            aux += "[ ]";
        }
        aux += "\n";
      }
      return aux;
    }
  
    public boolean isEmptyTable(){
      int aux = 0;
      for (int j = 0; j < 3; j++)
        for (int i = 0; i < 3; i++)
          if (table[j][i] == 'o' || table[j][i] == 'x')
            aux++;
      if (aux == 9)
        return true;
      return false;
    }
  
    public boolean gameOver(){
      if (gameOver != true) {
        check('o');
        check('x');
      }
      return gameOver;
    }
  
    public boolean isEmptyBox(int x, int y){
      if(table[x][y] == 'x' || table[x][y] == 'o')
        return true;
      return false;
    }
  
    public void check(char symbol){
      for (int n = 0; n < 3; n++) {
        if (table[n][0] == symbol && table[n][1] == symbol && table[n][2] == symbol)
          gameOver = true;
      }
      for (int n = 0; n < 3; n++) {
        if (table[0][n] == symbol && table[1][n] == symbol && table[2][n] == symbol)
          gameOver = true;
      }
      if (table[0][0] == symbol && table[1][1] == symbol && table[2][2] == symbol)
        gameOver = true;
      if (table[2][0] == symbol && table[1][1] == symbol && table[0][2] == symbol)
        gameOver = true;
    }
  }
  