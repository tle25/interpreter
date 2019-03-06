/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

   

public class LoadCode extends ByteCode{
    private ArrayList args;
    private String aString = "";
    int num;
    @Override
    public void execute(VirtualMachine vm) {
        vm.loadFrame(num);
    }

    @Override
    public void init(ArrayList list) {
        num = Integer.parseInt((String)list.get(0));
       if(list.size() > 1)
           aString = (String)list.get(1);
    }
   
    @Override
    public String toString(){
        return "LOAD " + num + " "+ aString;
    }
    
}
