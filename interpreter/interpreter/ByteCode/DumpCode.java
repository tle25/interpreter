/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode{
   private String get = "";
   private boolean value;
    @Override
    public void execute(VirtualMachine vm) {
    }

    @Override
    public void init(ArrayList list) {
       get = (String)list.get(0);
       if(get.contentEquals("ON")){
           value = true;
       }
           
       else{
           value = false;
          }
    }
    // If true, return String "ON", otherwise "OFF"
   @Override
     public String toString() {
    return value ? "ON" : "OFF";
}
    
}
