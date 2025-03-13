package ast;

import java.util.ArrayList;

public class Fun{
	public String nome;
	public ArrayList<ParamFormalFun> params;
	public String retorno;
	public ArrayList<VarDecl> vars;
	public ArrayList<Comando> body;
	
	public Fun(String nome,ArrayList<ParamFormalFun> params, String retorno,ArrayList<VarDecl> vars,ArrayList<Comando> body)
	{
		this.nome = nome;
		this.params = params;
		this.retorno = retorno;
		this.vars = vars;
		this.body = body;
	}

	public String toString() {
		var out = "pub fn " + nome + "(";
		
		for (var param: params) {
			out += param.toString()+",";
		}
		
		out += ") -> " + Fun.lugosiToRustType(retorno) + " {\n";

		for (var var : vars) {
			out += var.toString() + "\n";
		}

		for (var com : body) {
			out += com.toString() + "\n";
		}
		
		out += "\n}";
		return out;
	}

	public static String lugosiToRustType(String lugosiType) throws RuntimeException {
		return switch (lugosiType) {
			case "FLOAT" -> "f32";
			case "BOOL" -> "bool";
			case "VOID" -> "()";
			default -> throw new RuntimeException("No translation for type");
	 };	
	}

}
