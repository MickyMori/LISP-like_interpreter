
public class NumericExpr {

	public static INode assignNumericNode(TokenReader tokenReader) {
		TokenType type = tokenReader.nextType();
		switch(type) {
			case OPEN_ROUND:
				return new NumericOperatorNode(tokenReader);
				
			case NUMBER:
				return new NumberNode(tokenReader);
				
			case VARIABLE:
				return new VariableNode(tokenReader);
				
			default:
				throw new CustomError("ERROR: unexpected token found");
		}
	
	}
	
}