class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
			
			if (args.length > 1 && args[1].equals("-i")) {
				System.out.println("Executando no modo interpretador!!!\n");
				Interpretador backend_Interpretador = new Interpretador(arv);
				String resultado = backend_Interpretador.interpreta();
				System.out.println(resultado);
				return;
			}

			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);
			System.out.println(codigo);

		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
