/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class PopCode extends ByteCode{
    private int num;
    @Override
    public void execute(VirtualMachine vm) {
       for (int i = 0; i < num && vm.getSize() > 1; i++)   
        vm.pop();
            
    }

    @Override
    public void init(ArrayList args) {
       num = Integer.valueOf((String)args.get(0));
    }
        
    @Override
    public String toString(){
        return "POP " + num;
    }    
}

