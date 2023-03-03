
public class IfOperatorNode implements INode{
	
	public KeyWords operator;
	public INode left;
	public INode central;
	public INode right;
	
	public IfOperatorNode(TokenReader tokenReader) throws CustomError{
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsIfOperatorKeyWord(operator))
			throw new CustomError("ERROR: unexpected keyword found");
		left = BooleanExpr.assignBooleanNode(tokenReader);
		central = new Program(tokenReader);
		right = new Program(tokenReader);
		tokenReader.read(TokenType.CLOSE_ROUND);
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
