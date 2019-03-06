/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Stack;

public class ReturnCode extends ByteCode{
 private String aString = "";
 private String newString = "";
    @Override
    public void execute(VirtualMachine vm) {
        
        //return value on the stack and pop the frame.
        vm.popFrame();   
        
        // get the first return addr 
        Stack newStack = vm.returnStack();
            vm.SetPC((Integer)newStack.pop() + 1);    // return back to where it is called + 1 for the next execute

            
           
           if(aString.contains("<")){
           newString = aString.substring(0, aString.indexOf('<'));
                if(vm.getSize() > 0)
                newString = newString + "    exit " + newString + ": " + vm.peek();
           }  
           
           
        }

    @Override
    public void init(ArrayList list) {
        if(!list.isEmpty())
       this.aString = (String)list.get(0);
    }
    
    @Override 
    public String toString(){
        return "RETURN " + newString;
    }
    
}
