/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class ArgsCode extends ByteCode{
    public int num;
    @Override
    public void execute(VirtualMachine vm) {
        //Number of args will be load from the top of Stack.
        vm.newFrameAt(num);
    }

    @Override
    public void init(ArrayList list) {
        num = Integer.parseInt((String)list.get(0));
    }
    
    @Override
    public String toString(){
        return "ARGS " + num;
    }
}
