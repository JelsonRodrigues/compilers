package ast;


public class CReadInput extends Comando{
	public int linha;
	public String var;
	
	
	public CReadInput(int linha,String var)
	{
	  this.linha = linha;
	  this.var = var;
	} 

	public String toString() {
		String out = "let mut _" + var + " = String::new();";
		out += "std::io::stdin().read_line(&mut _"+var+").expect(\"error reading user input\"); "+var+" = _"+var+".trim().parse().unwrap();";
		return out;
	}

}
