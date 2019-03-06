/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

/**
 *
 * @author Hier
 */
public class FalseBranchCode extends ByteCode {
    private int num;
    private String getFB = "";
    
    @Override
    public void execute(VirtualMachine vm) {
        // If false is 0, go to label, else execute the program normally
        if(vm.pop() == 0){
            vm.SetPC(num);
        } 
        
    }

    @Override
    public void init(ArrayList list) {
        getFB = (String)list.get(0);

    }
    
    
    @Override
    public String toString(){
        return "FALSEBRANCH " + getFB;
    }
    
    public String getFalseBranch(){
        return getFB;
    }
    
    public void convertToAddrs(int num){
        this.num = num;
    }
    
}