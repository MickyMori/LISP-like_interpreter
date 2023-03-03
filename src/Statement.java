
public class Statement {
	
	public static INode assignStatementNode(TokenReader tokenReader) {
		if(tokenReader.getSecond(tokenReader).getType() != TokenType.KEYWORD)
			throw new CustomError("ERROR: unexpected token found");
		KeyWords type = (KeyWords)tokenReader.getSecond(tokenReader).getToken();
		switch(type) {
			case SET:
				return new SetOperatorNode(tokenReader);
			
			case PRINT:
				return new PrintOperatorNode(tokenReader);
			
			case INPUT:
				return new InputOperatorNode(tokenReader);
				
			case IF:
				return new IfOperatorNode(tokenReader);
						
			case WHILE:
				return new WhileOperatorNode(tokenReader);
			
			default:
				throw new CustomError("ERROR: unexpected keyword found");
		}

	}

}
