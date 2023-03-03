
public class NumberNode implements INode{
	
	public int value;

	public NumberNode(TokenReader tokenReader) {
		this.value = (int)tokenReader.read(TokenType.NUMBER).getToken();
	}
	
	public void accept(NodeVisitor visitor) {
		visitor.visit(this);
	}
}

