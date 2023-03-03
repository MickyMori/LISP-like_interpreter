import java.util.ArrayList;

public class BlockOperatorNode implements INode{
	
	public KeyWords operator;
	public ArrayList<INode> statement_list;
	
	public BlockOperatorNode(TokenReader tokenReader) throws CustomError{
		tokenReader.read(TokenType.OPEN_ROUND);
		operator=(KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(!StringEval.IsBlockOperatorKeyWord(operator))
			throw new CustomError("ERROR: unexpected keyword found");
		this.statement_list = new ArrayList<INode>();
		if(!TokenType.OPEN_ROUND.equals(tokenReader.nextType()))
			throw new CustomError("ERROR: unexpected token found");
		while(TokenType.OPEN_ROUND.equals(tokenReader.nextType()))
		{
			this.statement_list.add(Statement.assignStatementNode(tokenReader));
		}
		tokenReader.read(TokenType.CLOSE_ROUND);
	}
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
}
