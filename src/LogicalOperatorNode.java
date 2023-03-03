
public class LogicalOperatorNode implements INode{

	public KeyWords operator;
	public INode left;
	public INode right;
	
	public LogicalOperatorNode(TokenReader tokenReader) throws CustomError{
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsLogicalOperatorKeyWord(operator))
			throw new CustomError("ERROR: unexpected keyword found");
		left = BooleanExpr.assignBooleanNode(tokenReader);
		right = BooleanExpr.assignBooleanNode(tokenReader);
		tokenReader.read(TokenType.CLOSE_ROUND);
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
}
