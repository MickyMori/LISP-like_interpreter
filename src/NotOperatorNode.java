
public class NotOperatorNode implements INode{

	public KeyWords operator;
	public INode son;
	
	public NotOperatorNode(TokenReader tokenReader) throws CustomError{
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsNotOperatorKeyWord(operator))
			throw new CustomError("ERROR: unexpected keyword found");
		son = BooleanExpr.assignBooleanNode(tokenReader);
		tokenReader.read(TokenType.CLOSE_ROUND);
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
