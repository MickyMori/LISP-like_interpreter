
public class WhileOperatorNode implements INode{

	public KeyWords operator;
	public INode left;
	public INode right;
	
	public WhileOperatorNode(TokenReader tokenReader) throws CustomError{
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsWhileOperatorKeyWord(operator))
			throw new CustomError("ERROR: unexpected keyword found");
		left = BooleanExpr.assignBooleanNode(tokenReader);
		right = new Program(tokenReader);
		tokenReader.read(TokenType.CLOSE_ROUND);
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
}
