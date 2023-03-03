
public class BooleanConstNode implements INode{
	
	public boolean value;
	
	public BooleanConstNode(TokenReader tokenReader) {
		
		KeyWords temp = (KeyWords) tokenReader.read(TokenType.KEYWORD).getToken();
		if(temp==KeyWords.TRUE)
			this.value=true;
		else if(temp==KeyWords.FALSE)
			this.value=false;
		else
			throw new CustomError("ERROR: unexpected keyword found");
			
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
	
}
