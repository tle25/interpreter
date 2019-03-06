package interpreter;

import interpreter.ByteCode.ByteCode;
import interpreter.ByteCode.DumpCode;
import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    
    private boolean dump = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    
    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack();
        isRunning = true;
       
        while(isRunning){
            ByteCode code = program.getCode(pc);  
            code.execute(this);
            
            
            // check if code is an instance of DUmpCode, if so, it will set dump to true or false
            // This also avoid output the DUMP ON or DUMP OFF line 
            if(code instanceof DumpCode){
                if(code.toString() == "ON"){
                    dump = true;
                }
                
                else
                    dump = false;       
            }
           
            // IF dump is on/true, print line and the executed program
            else{
                if(dump){  
                System.out.println(code + " "); 
                runStack.dump(); // check that the operation is correct
                }
            }
  
            pc++;
        }       
    }
    
        // set isRunning to false when calls Halt class
        public void setHALT(boolean halt){
            this.isRunning = halt;
        }
        
       
        // Set PC to new PC, and its new PC must - 1 because when it returns to execute, it PC will be add to 1.
        public void SetPC(int newPC){
            this.pc = newPC - 1;
        }   
        
        // Memorize the addresss of CallCode
        public void currentAddr(int cur){
            this.returnAddrs.push(cur); 
        }
        
        // Return the value from function.
        public Stack returnStack(){
            return this.returnAddrs;
        }
        
        public int getSize(){
            return runStack.getSize();
        }
        
        // Pop top of RTS   
        public int pop(){
            return runStack.pop();
        }
        
        //Peek top
        public int peek(){
            return runStack.peek();
        }
        
        // Push on top stack
        public int push(int x){
            return runStack.push(x);
        }
       
        //request to create a new frame 
       public void newFrameAt(int offset){
          runStack.newFrameAt(offset);
          }
    
       //request RTS to pop frame
        public void popFrame(){
            runStack.popFrame();
         }
   
        //request RTS store arg at offset
        public int storeFrame(int offset){
              return runStack.store(offset);
         }
    
        //request RTS load value at offset
         public int loadFrame(int offset){
             return runStack.load(offset);
         }
    
         //request RTS push an Integer number
         public Integer push(Integer i){
            return runStack.push(i);
         }

}

