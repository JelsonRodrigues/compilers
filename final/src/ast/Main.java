package ast;

import java.util.ArrayList;

public class Main{

	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> coms;
	
	public Main(ArrayList<VarDecl> vars,ArrayList<Comando> coms)
	{
		this.vars = vars;
		this.coms = coms;
	}

	public String toString() {
		String out = "pub fn main() -> () {\n";

		for (VarDecl var : vars) {
			out = out + var.toString() + "\n";
		}
		
		for (Comando com : coms) {
			out = out + com.toString() + "\n";
		}

		out = out + "\n}";

		return out;
	}

}
