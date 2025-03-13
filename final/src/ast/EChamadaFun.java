package ast;

import java.util.ArrayList;

public class EChamadaFun extends Exp{
	public String fun;
	public ArrayList<Exp> args;
	
	public EChamadaFun(String fun, ArrayList<Exp> args)
	{
	  this.fun = fun;
	  this.args = args;
	} 
	public String toString() {
		String out = fun + "(";

		for (var arg : args){
			out += arg.toString() + ",";
		}
		out += ")";
		return out;

	}
}
