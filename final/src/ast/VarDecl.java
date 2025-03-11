package ast;

public class VarDecl{
   public String type;
   public String var;
   
   public VarDecl(String type,String var){
   	this.type = type;
   	this.var = var;
   }

   public String toString() {
      String out;

      out = switch (type) {
         case "FLOAT" -> "f32";
         case "BOOL" -> "bool";
         case "VOID" -> "unit";
         default -> throw new RuntimeException("No translation for type");
      };

      out += " " + var;

      return out;
   }
}
