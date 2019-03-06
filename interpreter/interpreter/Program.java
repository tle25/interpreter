package interpreter;

import interpreter.ByteCode.ByteCode;
import java.util.ArrayList;
import interpreter.ByteCode.LabelCode;
import interpreter.ByteCode.GotoCode;
import interpreter.ByteCode.FalseBranchCode;
import interpreter.ByteCode.CallCode;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private HashMap<String, Integer> labelMap = new HashMap<>();

    public Program() {
        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {
        return this.program.get(pc);       
    }

    public int getSize() {
        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
   // public void resolveAddrs(Program program) {
    public void resolveAddrs(Program program) {
        int num;
        for(int i = 0; i < program.getSize(); i++)
        {
            
           
            
 /*           // Convert GotoCode args to label address
            if(program.getCode(i) instanceof GotoCode) {              
              num =  labelMap.get(((GotoCode)program.getCode(i)).getGoto());
               ((GotoCode)program.getCode(i)).convertToAddr(num);  
    
            }   
       
            // Convert CallCode args to label address, Also send current memorize the current address before Call
            else if(program.getCode(i) instanceof CallCode){
               
               num = labelMap.get(((CallCode)program.getCode(i)).getCall());
               ((CallCode)program.getCode(i)).convertToAddr(num, i);     

            }

        
            // Convert FALSEBRANCH args to label address
            else if(program.getCode(i) instanceof FalseBranchCode){
              num =  labelMap.get(((FalseBranchCode)program.getCode(i)).getFalseBranch());
              ((FalseBranchCode)program.getCode(i)).convertToAddrs(num);    
            }    
                */
            
            // They both work but this one is better and easier to understand.
            if(program.getCode(i) instanceof GotoCode){
                GotoCode Goto = (GotoCode)program.getCode(i);
                Goto.convertToAddr(labelMap.get(Goto.getGoto()));
            }
            
            else if(program.getCode(i) instanceof CallCode){           
                CallCode Call = (CallCode)program.getCode(i);
               Call.convertToAddr(labelMap.get(Call.getCall()), i);  

            }
            
            else if(program.getCode(i) instanceof FalseBranchCode){
                FalseBranchCode falseBranch = (FalseBranchCode)program.getCode(i);
                falseBranch.convertToAddrs(labelMap.get(falseBranch.getFalseBranch()));
            }
     
        }
    }
      
    //push bytecode to arrayList.
    // Get note if bytecode is label, push set its arg as key, and current addrs as value
    public void addCode(ByteCode bytecode) {  
        //set key as label arg, and value as label current address
        //current address will be size() - 1, however it still not be added to arraylist, then size() is its addrs
        if(bytecode instanceof LabelCode){
            labelMap.put(((LabelCode)bytecode).getLabel(), this.program.size());
        }

        program.add(bytecode);
    }
}
