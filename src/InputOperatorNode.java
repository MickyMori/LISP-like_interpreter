
public class InputOperatorNode implements INode{
	
	public KeyWords operator;
	public VariableNode son;
	
	public InputOperatorNode(TokenReader tokenReader) {
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsInputOperatorKeyWord(operator)) 
			throw new CustomError("ERROR: unexpected keyword found");
		son = new VariableNode(tokenReader);
		tokenReader.read(TokenType.CLOSE_ROUND);
		
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}

}
