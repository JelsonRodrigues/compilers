import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class MaquinaPilha {
  public static void main(String args[]) throws IOException {
    if (args[0] == null) {
      System.err.println("Nenhum arquivo de origem inserido");
    }

    var memory = new Stack<Integer>();
    
    var arquivo = new BufferedReader(new FileReader(args[0]));
    while (true) {
      var read_line = arquivo.readLine();
      if (read_line == null || read_line.length() == 0) {
        break;
      }
      var line = read_line.split(" ");
      
      // Only operand that has more than one parameter is the PUSH
      if (line.length == 0) {
        return;
      }
      
      switch (line[0]) {
        case "PUSH" -> {
          assert line.length > 1;
          memory.push(Integer.parseInt(line[1]));
        }
        case "PRINT" -> System.out.println(memory.pop());
        default -> {
          var v1 = memory.pop();
          var v2 = memory.pop();
          switch (line[0]) {
            case "DIV" -> memory.push(v2 / v1);
            case "SUM" -> memory.push(v1 + v2);
            case "SUB" -> memory.push(v2 - v1);
            case "MULT" -> memory.push(v1 * v2);
            default -> System.err.println("Operador inesperado: " + line[0]);
          };
          }
        
      }
    }
    arquivo.close();

  }
}
