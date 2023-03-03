
public class SetOperatorNode implements INode{
	
	public KeyWords operator;
	public VariableNode left;
	public INode right;
	
	public SetOperatorNode(TokenReader tokenReader) throws CustomError{
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsSetOperatorKeyWord(operator)) 
			throw new CustomError("ERROR: unexpected keyword found");
		left = new VariableNode(tokenReader);
		right = NumericExpr.assignNumericNode(tokenReader);
		tokenReader.read(TokenType.CLOSE_ROUND);
			
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
