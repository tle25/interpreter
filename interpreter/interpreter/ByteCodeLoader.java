
package interpreter;

import interpreter.ByteCode.ByteCode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program program;

    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public Program loadCodes() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
    // String line = this.byteSource.readLine();
       String line, getCode;
       StringTokenizer tokenizer;
       ArrayList listArgs;
       program = new Program();
    
        while((line = this.byteSource.readLine()) != null){
              tokenizer = new StringTokenizer(line);
            listArgs = new ArrayList();
            getCode = CodeTable.getClassName(tokenizer.nextToken());
        
            
            while(tokenizer.hasMoreTokens()){
                listArgs.add(tokenizer.nextToken()); 
            }      
     
            //Create an instance of the ByteCode from CodeTable           
            ByteCode bytecode = (ByteCode)(Class.forName("interpreter.ByteCode." + getCode).newInstance()); 
            
            //Parse the additonal arguement and send them to the bytecode. Then add bytecode to the program 
             bytecode.init(listArgs);
            
             program.addCode(bytecode);
        }
           
        this.byteSource.close();    // Close file  
        
        program.resolveAddrs(program); // This will resolve address
        
        
       return program; 
}
}