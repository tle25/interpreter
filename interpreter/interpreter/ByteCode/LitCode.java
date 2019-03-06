/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class LitCode extends ByteCode{

    private ArrayList list;
    private String newString = "";
    @Override
    public void execute(VirtualMachine vm) {
        if(list.size() == 1){
          Integer val = Integer.parseInt((String)list.get(0));
            vm.push(val);
        }
        else{
            if(vm.getSize() == 0)
                vm.push(0);
            if(vm.getSize() != 0)
               vm.push(vm.peek());
        }

            newString = (String)list.get(0);
            if(list.size() > 1)
                newString = newString + " " + list.get(1) +  "     int " +
                        list.get(1) + " = " + vm.peek();
        
    }

    @Override
    public void init(ArrayList list) {
        this.list = list;       
    }
    
    @Override
    public String toString(){
        return "LIT " + newString;
    }
    
}
