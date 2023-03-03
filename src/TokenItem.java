
public class TokenItem {
	
	private final Object token;
	private final TokenType type;
	
	public TokenItem(Object token, TokenType type) {
		this.token = token;
		this.type = type;
	}
	
	public TokenType getType() {
		return this.type;
		
	}
	
	public Object getToken() {
		return this.token;
	}
}
