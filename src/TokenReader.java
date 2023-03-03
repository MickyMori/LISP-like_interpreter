import java.util.*;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TokenReader {
	LinkedList<TokenItem> tokens;
	StringTokenizer st;
	
	
	public TokenReader(FileReader reader, File file) throws CustomError,IOException {
	    StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
	    LinkedList<TokenItem> tokens = new LinkedList<>();
	    int open=0;
	    int closed=0;
	    Path pfile = null;
	    try {
	    	pfile  = Path.of(file.toString());
	    } catch(InvalidPathException e) {
	    	throw new CustomError("ERROR");
	    }
	    String s = Files.readString(pfile);
	    st = new StringTokenizer(s);
	    

	    int currentToken = streamTokenizer.nextToken();
	    while (currentToken != StreamTokenizer.TT_EOF) {

	        if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
	        	int n = (int)streamTokenizer.nval;
	        	tokens.add(new TokenItem(n, TokenType.NUMBER));
	        }else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
	        	if(streamTokenizer.sval.matches("[a-zA-Z]+"))
	        	{
	        		String name = streamTokenizer.sval;
	        		try {
	        			tokens.add(new TokenItem(StringEval.Parse(name), TokenType.KEYWORD));
	        			
	        		}
	        		catch(IllegalArgumentException ex) {
	        			tokens.add(new TokenItem(name, TokenType.VARIABLE));
	        		}
	        	}
	        	else
	        		throw new CustomError("ERROR: found a string that isn't accepted");
	        } else {
	        	if((char) currentToken == '(')
	        	{
	        		tokens.add(new TokenItem((char) currentToken, TokenType.OPEN_ROUND));
	        		open++;
	        	}
	        	else if((char) currentToken == ')')
	        	{
	        		tokens.add(new TokenItem((char) currentToken, TokenType.CLOSE_ROUND));
	        		closed++;
	        	}
	        	else
	        		throw new CustomError("ERROR: found a char that isn't accepted");
	        }

	        currentToken = streamTokenizer.nextToken();
	        
	        
	    }
	    if(open!=closed)
	    	throw new CustomError("ERROR: mismatched parenthesis");
	    
	    if(tokens.isEmpty()==true)
	    {
	    	throw new CustomError("ERROR: empty program");
	    }
	    
	    

	    
	    this.tokens = tokens;
	}
	
	public TokenItem read() {
		
		return this.read(null);
		
	}

	public TokenItem read(TokenType type) {
		TokenItem t = this.tokens.poll();
		if(type != null && !type.equals(t.getType())) {
			
			throw new CustomError("ERROR: unexpected token found");
		}
		return t;
	}
	
	public TokenType nextType() {
		return this.tokens.getFirst().getType();
		
	}
	
	public TokenItem getSecond(TokenReader tokenReader) {
		
		return tokenReader.tokens.get(1);
		
	}
	
	public void ControlNumberFormat(StringTokenizer st)
	{
		while (st.hasMoreTokens()) {
	         String str = st.nextToken();
	         int cont = str.length();
	         for(int i=0;i<str.length();i++)
	        	 if(str.charAt(i) == ')')
	        	 {
	        		 cont-=1;
	        	 }
	        	 else if(str.charAt(i) == '.')
	        		 throw new CustomError("ERROR: language doesn't accept doubles");
	         if(cont>1 && str.charAt(0) == '0')
	        	 throw new CustomError("ERROR: number with non-significant digit");
	         
		}
	}
	
}