/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class BopCode extends ByteCode{
    private String check = "";
    private int num1, num2;
    @Override
    public void execute(VirtualMachine vm) {
         num2 = vm.pop();
         num1 = vm.pop();
        
        // 
       // System.out.println(num1 +" " + num2);
       
        if(null != check)
            switch (check) {
            case "+": 
                vm.push(num1+num2);
                break;
                
            case "-":                
                vm.push(num1-num2);
                break;
                
            case "*":
                vm.push(num1*num2);
                break;
                
            case "/":
                vm.push(num1/num2);
                break;
                
            case "==":
                if(num1 == num2)
                vm.push(1);
                else
                vm.push(0);
                break;
                
            case ">=":
                if(num1 >= num2)
                vm.push(1);
                else
                vm.push(0);
                break;
                
            case "<=":
                if(num1 <= num2)
                vm.push(1);
                else
                vm.push(0);
                break;
                
            case ">":
                if(num1 > num2)
                vm.push(1);
                else
                vm.push(0);
                break;
                
            case "<":
                if(num1 < num2)
                vm.push(1);
                else
                vm.push(0);
                break;
                
            case "!=":
                if(num1 != num2)
                vm.push(1);
                else
                vm.push(0);
                break;
                
            case "|":
                System.out.println("Num1 or Num2 are set as integers, Can not convert as boolean");
                /*
                something like but I don't know how to convert num1 and num2 to boolean
                vm.push(num1||num2); // this will check if one or more of these numbeber aretrue, return true;              
                */
                break;
                
            case "&":
                System.out.println("Num1 or Num2 are set as integers, Can not convert as boolean");
                /*
                something like but I don't know how to convert num1 and num2 to boolean
                vm.push(num1&&num2); // if return true if and only if num1 and num2 are true;   
                */       
                break;
                 
                
            default:
                break;
        }
        
    }

    @Override
    public void init(ArrayList list) {
        check = (String)list.get(0);
    }
    
    @Override
    public String toString(){
        return "BOP " + check;
    }
    
}
