import java.util.Stack;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EvaluationVisitor implements NodeVisitor{
	
	private Context context;
	
	private Stack<Object> accumulator;
	
	public EvaluationVisitor(Context context) {
		this.context = context;
		accumulator = new Stack<Object>();
	}
	
	@Override
	public void visit(NumberNode number) {
		accumulator.push(number.value);	
	}

	@Override
	public void visit(VariableNode variable) {
		try {
			Integer value = context.getVariable(variable.name);
			accumulator.push(value);
		} catch(NullPointerException ex) {
			throw new CustomError("ERROR: variable not initialized");
		}
	}

	@Override
	public void visit(NumericOperatorNode operator) {
		operator.left.accept(this);
		operator.right.accept(this);
		int r_value =(int) accumulator.pop();
		int l_value =(int) accumulator.pop();
		switch (operator.operator) {
		case ADD:
			accumulator.push(l_value + r_value);
			return;
		case SUB:
			accumulator.push(l_value - r_value);
			return;
		case MUL:
			accumulator.push(l_value * r_value);
			return;
		case DIV:
			if (r_value!=0)
				accumulator.push(l_value / r_value);
			else
				throw new CustomError("ERROR: division by zero");
			return;
		default:
			return;
		}
	}
	@Override
	public void visit(Program program)
	{
		program.statementBlock.accept(this);
	}
	
	@Override
	public void visit(RelationOperatorNode operator) {
		operator.left.accept(this);
		operator.right.accept(this);
		int r_value =(int) accumulator.pop();
		int l_value =(int) accumulator.pop();
		switch (operator.operator) {
		case LT:
			if(l_value<r_value) 
				accumulator.push(true);
			else
				accumulator.push(false);
			return;
		case GT:
			if(l_value>r_value) 
				accumulator.push(true);
			else
				accumulator.push(false);
			return;
		case EQ:
			if(l_value==r_value) 
				accumulator.push(true);
			else
				accumulator.push(false);
			return;
		default:
			return;
		}
	
		
	}
	
	@Override
	public void visit(LogicalOperatorNode operator){
		operator.left.accept(this);
		boolean l_value =(boolean) accumulator.pop();
		switch (operator.operator) {
		case AND:
			if(l_value==false)
				accumulator.push(false);
			else {
				operator.right.accept(this);
				boolean r_value =(boolean) accumulator.pop();
				if(r_value==false)
					accumulator.push(false);
				else
					accumulator.push(true);
			}
			return;

		case OR:
			if(l_value==true)
				accumulator.push(true);
			else {
				operator.right.accept(this);
				boolean r_value =(boolean) accumulator.pop();
				if(r_value==true)
					accumulator.push(true);
				else
					accumulator.push(false);
			}
			return;
		default:
			return;
		}
	}
	
	@Override
	public void visit(NotOperatorNode operator){
		operator.son.accept(this);
		boolean value = (boolean) accumulator.pop();
		if(value==true)
			accumulator.push(false);
		else
			accumulator.push(true);
	}

	@Override
	public void visit(BooleanConstNode constant) {
		accumulator.push(constant.value);
	}

	@Override
	public void visit(SetOperatorNode operator) {
		operator.right.accept(this);
		int r_value =(int) accumulator.pop();
		context.setVariable(operator.left.name,r_value);
	}

	@Override
	public void visit(PrintOperatorNode operator) {
		operator.son.accept(this);
		int value = (int) accumulator.pop();
		System.out.println(value);
	}

	@Override
	public void visit(InputOperatorNode operator) {
		try {
			Scanner in = new Scanner(System.in);
			String s = in.next("[1-9][0-9]*");
			int value = Integer.parseInt(s);
			context.setVariable(operator.son.name,value);
		} catch(InputMismatchException ex) {
			throw new CustomError("ERROR: invalid input");
		}
	}

	@Override
	public void visit(BlockOperatorNode operator) {
		for(int i=0;i<operator.statement_list.size();i++)
			operator.statement_list.get(i).accept(this);
	}

	@Override
	public void visit(WhileOperatorNode operator) {
		operator.left.accept(this);	
		boolean value = (boolean) accumulator.pop();
		while(value == true)
		{
			operator.right.accept(this);
			operator.left.accept(this);	
			value = (boolean) accumulator.pop();
		}
	}

	@Override
	public void visit(IfOperatorNode operator) {
		operator.left.accept(this);	
		boolean value = (boolean) accumulator.pop();
		if(value==true)
			operator.central.accept(this);
		else
			operator.right.accept(this);
	}
}