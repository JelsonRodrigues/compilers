import java.io.*;

enum TokenType{ NUM, SOMA, MULT, SUB, DIV, APar, FPar, EOF};

public record Token(String lexema, TokenType token){};

class AnaliseLexica {

	BufferedReader arquivo;
	String nextString = "";

	AnaliseLexica(String a) throws Exception
	{
		
	 	this.arquivo = new BufferedReader(new FileReader(a));
		
	}

	boolean checkStringIsNumeric(String input) {
		for (char character : input.toCharArray()) {
			if (character < '0' || character > '9'){
				return false;
			}	
		}
		return true;
	}

	// Remove new line, space and tabs
	String getNextValidCharacterAsString() throws Exception {
		int currchar1;
		do {
			currchar1 = (char) arquivo.read();
		} while (currchar1 == '\n' || currchar1 == ' ' || currchar1 == '\t' || currchar1 == '\r');
		return Character.toString(currchar1);
	}

	Token getNextToken() throws Exception
	{	
		// Token token;
		int eof = -1;
		String currchar1;
		String current_string = "";

		if (nextString.isEmpty()) {
			do {
				currchar1 = getNextValidCharacterAsString();
				current_string += currchar1;
			} while (checkStringIsNumeric(currchar1));
			
			// Remove op and store on nextString
			if (current_string.length() > 1) {
				nextString = current_string.substring(current_string.length() - 1, current_string.length());
				current_string = current_string.substring(0, current_string.length() -1);
			}

			if((short)currchar1.toCharArray()[0] != eof && currchar1.toCharArray()[0] !=10)
			{
				return tokenFromString(current_string);
			}
			else 
			{
				arquivo.close();
				return (new Token(current_string,TokenType.EOF));
			}
		}
		else 
		{
			Token nextToken = tokenFromString(nextString);
			nextString = "";
			return nextToken;
		}
		
	}

	Token tokenFromString(String string) throws Exception{
		if (checkStringIsNumeric(string))
		{
				return (new Token (string, TokenType.NUM));
		}
		else
		{
			switch (string)
			{
				case "(":
					return (new Token (string,TokenType.APar));
				case ")":
					return (new Token (string,TokenType.FPar));
				case "+":
					return (new Token (string,TokenType.SOMA));
				case "*":
					return (new Token (string,TokenType.MULT));
				case "-":
					return (new Token (string,TokenType.SUB));
				case "/":
					return (new Token (string,TokenType.DIV));
				default: throw (new Exception("Sequencia de caracteres inválida: " + (string)));
			}
	}
}
}
