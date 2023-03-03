
public class BooleanExpr {
	
	public static INode assignBooleanNode(TokenReader tokenReader)
	{
		TokenType type = tokenReader.nextType();
		switch(type) {
			case OPEN_ROUND:
				type = tokenReader.tokens.get(1).getType();
				if(type.equals(TokenType.KEYWORD))	
				{
					if(StringEval.IsRelationOperatorKeyWord((KeyWords) tokenReader.tokens.get(1).getToken()))
						return new RelationOperatorNode(tokenReader);
					else if (StringEval.IsLogicalOperatorKeyWord((KeyWords) tokenReader.tokens.get(1).getToken()))
						return new LogicalOperatorNode(tokenReader);
					else if (StringEval.IsNotOperatorKeyWord((KeyWords) tokenReader.tokens.get(1).getToken()))
						return new NotOperatorNode(tokenReader);
				}
				else
					throw new CustomError("ERROR: unexpected keyword found");
			
			case KEYWORD:
				return new BooleanConstNode(tokenReader);
			
			
			default:
				throw new CustomError("ERROR: unexpected token found");
		}
	
	}

}