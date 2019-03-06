/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class StoreCode extends ByteCode{
       private  ArrayList list;
        private String newString = "";
    @Override
    public void execute(VirtualMachine vm) {
        vm.storeFrame(Integer.parseInt((String)list.get(0)));

        for(int i = 0; i < list.size(); i++)
        {
            newString = newString + " " + list.get(i);
        }
        
    }

    @Override
    public void init(ArrayList list) {
        this.list = list;

    }
    
    
    public String toString(){
        return "STORE " + newString;
    }
    
}
