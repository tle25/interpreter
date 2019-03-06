/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class WriteCode extends ByteCode{
    private int num;
    @Override
    public void execute(VirtualMachine vm) {
        num = vm.peek();
    }

    @Override
    public void init(ArrayList list) {
    }
    
    @Override
    public String toString(){
        return "WRITE\n" +num ;
    }
    
}
