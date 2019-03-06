/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import interpreter.VirtualMachine;
import java.util.ArrayList;

public class HaltCode extends ByteCode{

    @Override
    public void execute(VirtualMachine vm) {
        vm.setHALT(false);
    }

    @Override
    public void init(ArrayList list) {       
    }
    
    @Override
    public String toString(){
        return "HALT";
    }
}
