/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GotoCode extends ByteCode{
    private String getGoto = "";
    private int addrs;
    @Override
    public void execute(VirtualMachine vm) {
        vm.SetPC(addrs);       
    }

    @Override
    public void init(ArrayList list) {
        getGoto = (String)list.get(0);
    }
    
    @Override
    public String toString(){
        return "GOTO " + getGoto;
    }
    
    public String getGoto(){
        return getGoto;
    }
    
    public void convertToAddr(int num){
        this.addrs = num;
    }
}
