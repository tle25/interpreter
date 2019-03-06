/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;


import interpreter.VirtualMachine;
import java.util.ArrayList;

public class LabelCode extends ByteCode{

    private String label;
    @Override
    public void execute(VirtualMachine vm) {      
    }

    @Override
    public void init(ArrayList list) {
        label = (String)list.get(0);
    }
    
    @Override
    public String toString(){
        return "LABEL " + label;
    }
    
    public String getLabel(){
        return label;
    }
    
}

