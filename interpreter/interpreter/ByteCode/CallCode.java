/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class CallCode extends ByteCode{

     private String callfn = "",
             newString = "";
   //  int getValue1= null;
     private int num, currentAddrs, getValue;
    @Override
    public void execute(VirtualMachine vm) {
        
        //Everytime we call a function, remember its current address so that we will return back to where f is called.
        vm.currentAddr(currentAddrs);
        vm.SetPC(num); 
  
        
           if(callfn.contains("<")){
           newString = callfn.substring(0, callfn.indexOf('<'));
                if(vm.getSize() > 0)
                newString = newString + "    " + newString + "(" + vm.peek()+ ")";
                else
                newString = newString + "    " + newString + "()";
           }
           
           else
           {
               if(vm.getSize() > 0)
                newString = callfn + "    " + callfn + "(" + vm.peek()+ ")";
                else
                newString = callfn + "    " + callfn + "()";
           }

    }
  
    @Override
    public void init(ArrayList list) {
        this.callfn = (String)list.get(0);
       
    }
       
    @Override
    public String toString(){
        return "Call " + newString;
    }
    
    public String getCall(){
        return this.callfn;
    }
    
    public void convertToAddr(int num, int cur){
        this.num = num;
        this.currentAddrs = cur;
    }
    
}
