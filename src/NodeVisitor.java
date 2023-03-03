
public interface NodeVisitor {
	public void visit(NumberNode number);
	public void visit(VariableNode variable);
	public void visit(NumericOperatorNode operator);
	public void visit(Program program);
	public void visit(RelationOperatorNode operator);
	public void visit(LogicalOperatorNode operator);
	public void visit(NotOperatorNode operator);
	public void visit(BooleanConstNode constant);
	public void visit(SetOperatorNode operator);
	public void visit(PrintOperatorNode operator);
	public void visit(InputOperatorNode operator);
	public void visit(BlockOperatorNode operator);
	public void visit(WhileOperatorNode operator);
	public void visit(IfOperatorNode operator);
}
