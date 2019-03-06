/**
 * Name: Thanh Le
 * Class: CSC 413
 * Professor: Anthony Souza
 * Assignment3: Interpreter
 * Due date: 3/17/2018 11:59 PM
 */


package interpreter;

import java.io.*;

/**
 * <pre>
 *     Interpreter class runs the interpreter:
 *     1. Perform all initializations
 *     2. Load the bytecodes from file
 *     3. Run the virtual machine
 * </pre>
 */
public class Interpreter {

	private ByteCodeLoader bcl;

	public Interpreter(String codeFile) {
		try {
			CodeTable.init();
			bcl = new ByteCodeLoader(codeFile);
		} catch (IOException e) {
			System.out.println("**** " + e);
		}
	}

	void run() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		Program program = bcl.loadCodes();
		VirtualMachine vm = new VirtualMachine(program);
		vm.executeProgram();
	}

	public static void main(String args[]) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException{
            
		if (args.length == 0) {
			System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
			System.exit(1);
		}
		(new Interpreter(args[0])).run();
	}
}