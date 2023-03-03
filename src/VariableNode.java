
public class VariableNode implements INode {

		public String name;
		
		public VariableNode(TokenReader tokenReader) {
			this.name = (String)tokenReader.read(TokenType.VARIABLE).getToken();
		}
		
		public void accept(NodeVisitor visitor) {
			visitor.visit(this);
		}
	}


