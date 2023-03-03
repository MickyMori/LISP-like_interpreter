import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
		
	public static void main(String[] args) {
		
		try {
			File file = new File(args[0]);
			FileReader fileReader= new FileReader(file);
			TokenReader tokenReader = new TokenReader(fileReader, file);
			tokenReader.ControlNumberFormat(tokenReader.st);
			INode program = new Program(tokenReader);
			Context c = new Context();
			EvaluationVisitor ev = new EvaluationVisitor(c);
			program.accept(ev);
		} catch (CustomError e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR: file not found");
		}
		
	}
	
}
