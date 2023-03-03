
public class PrintOperatorNode implements INode {
	
	public KeyWords operator;
	public INode son;
	
	public PrintOperatorNode(TokenReader tokenReader) {
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsPrintOperatorKeyWord(operator)) 
			throw new CustomError("ERROR: unexpected keyword found");
		son = NumericExpr.assignNumericNode(tokenReader);
		tokenReader.read(TokenType.CLOSE_ROUND);
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
