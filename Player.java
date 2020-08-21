public class Player {
    String name;
    char symbol;
    int number;
  
    public Player(String name, char symbol, int number) {
      this.name = name;
      this.symbol = symbol;
      this.number = number;
    }
  
    public String getName() {
      return name;
    }
  
    public char getSymbol() {
      return symbol;
    }
    
    public int getNumber(){
      return number;
    }
  }
  