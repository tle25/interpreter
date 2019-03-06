/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadCode extends ByteCode{
     private int num;
    @Override
    public void execute(VirtualMachine vm) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter an Integer: ");
        num = scan.nextInt();
        vm.push(num);       
    }

    @Override
    public void init(ArrayList list) {
    }
    
    @Override
    public String toString(){
        return "READ";
    }
    
}
