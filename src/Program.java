
public class Program implements INode{
	
	INode statementBlock;
	
	public Program(TokenReader tokenReader) {
		if(tokenReader.getSecond(tokenReader).getType() != TokenType.KEYWORD)
			throw new CustomError("ERROR: unexpected token found");
		KeyWords type =(KeyWords) tokenReader.getSecond(tokenReader).getToken();
		if(StringEval.IsStatementOperatorKeyWord(type))
			statementBlock = Statement.assignStatementNode(tokenReader);
		else if(StringEval.IsBlockOperatorKeyWord(type))
			statementBlock  = new BlockOperatorNode(tokenReader);
		else
			throw new CustomError("ERROR: unexpected keyword found");
	}

	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
	

}
