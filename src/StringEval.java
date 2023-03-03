
public class StringEval {
	
	public static KeyWords Parse(String name) {
		
		return KeyWords.valueOf(name);
		
	}

	public static boolean IsNumericOperatorKeyWord(KeyWords keyWord) {
		
		return (keyWord.ordinal() >= KeyWords.ADD.ordinal() && keyWord.ordinal() <= KeyWords.DIV.ordinal()); 
						
	}
	
	public static boolean IsRelationOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()>=KeyWords.LT.ordinal() && keyWord.ordinal() <= KeyWords.EQ.ordinal());
		
	}
	
	public static boolean IsLogicalOperatorKeyWord(KeyWords keyWord) {
		
		return (keyWord.ordinal()==KeyWords.AND.ordinal() || keyWord.ordinal() == KeyWords.OR.ordinal());
		
	}
	
	public static boolean IsNotOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()==KeyWords.NOT.ordinal());
		
	}
	
	public static boolean IsSetOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()==KeyWords.SET.ordinal());
		
	}
	
	public static boolean IsPrintOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()==KeyWords.PRINT.ordinal());
		
	}
	
	public static boolean IsInputOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()==KeyWords.INPUT.ordinal());
		
	}
	
	public static boolean IsStatementOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()>=KeyWords.SET.ordinal() && keyWord.ordinal() <= KeyWords.WHILE.ordinal());
		
	}
	public static boolean IsBlockOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()==KeyWords.BLOCK.ordinal());
		
	}
	
	public static boolean IsWhileOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()==KeyWords.WHILE.ordinal());
		
	}
	
	public static boolean IsIfOperatorKeyWord(KeyWords keyWord) {
		
		return(keyWord.ordinal()==KeyWords.IF.ordinal());
		
	}
	
}
