
public class RelationOperatorNode implements INode {
	
	public KeyWords operator;
	public INode left;
	public INode right;
	
	public RelationOperatorNode(TokenReader tokenReader) throws CustomError{
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsRelationOperatorKeyWord(operator))
			throw new CustomError("ERROR: unexpected keyword found");	
		left = NumericExpr.assignNumericNode(tokenReader);
		right = NumericExpr.assignNumericNode(tokenReader);
		tokenReader.read(TokenType.CLOSE_ROUND);
			
	}
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
