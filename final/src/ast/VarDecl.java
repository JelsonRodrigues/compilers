package ast;

public class VarDecl{
   public String type;
   public String var;
   
   public VarDecl(String type,String var){
   	this.type = type;
   	this.var = var;
   }

   public String toString() {
      String out = "let mut ";

      out += var;

      out += lugosiToRustType(type);

      out += ";";

      return out;
   }

   private String lugosiToRustType(String lugosiType) throws RuntimeException {
		return switch (lugosiType) {
			case "FLOAT" -> ": f32";
			case "BOOL" -> ": bool";
			case "VOID" -> ": ()";
			default -> throw new RuntimeException("No translation for type");
	   };
}
}
