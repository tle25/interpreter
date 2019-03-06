package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    public void dump(){
        int IndexOfRTS = 0,                       
                maxFrames = framePointer.size(),  // Frame size
                 frameCount = 0;
    
            // the statement greater than 0 will print open-close squared bracket even it has no argument
            // It also is a place to keep the final value.
            if(maxFrames > 0){
                for(int i = 0; i < maxFrames; i++){
                    System.out.print("[");
                    
                    
                    // This output the first framePointer to (max frame - 1)
                    // It avoids the value out of bounds
                    if(i != (maxFrames-1)){
                        while((framePointer.get(i+1) - frameCount) > framePointer.get(i)){
  
                        System.out.print(runTimeStack.get(IndexOfRTS));
                        frameCount++;
                        IndexOfRTS++;
                        if((framePointer.get(i+1) - frameCount) > framePointer.get(i))
                            System.out.print(",");
                        }
                    }
                    
                    //This else statement will check the last frame
                    //Print all value from the top RTS to the last framePointer
                    else {
                        frameCount = 0;
                        while((runTimeStack.size() - frameCount) > framePointer.get(i)){
                        System.out.print(runTimeStack.get(IndexOfRTS));
                        frameCount++;
                        IndexOfRTS++;
                        if((runTimeStack.size() - frameCount) > framePointer.get(i))
                            System.out.print(",");
                        }
                        
                    }
                        frameCount = 0; //increasing frameCount

                    System.out.print("] ");
                } // end frameNumber for loop
             } // end if
 

        System.out.println();
    
    }
    
    
    public int getSize(){
        return runTimeStack.size();
    }
    
    // Peek the last argue of runTimeStack
    public int peek(){
       return runTimeStack.get(runTimeStack.size() - 1);
    }
    
    // Pop the back first.
    public int pop() {
       
       int popTop = runTimeStack.get(runTimeStack.size()-1);

       runTimeStack.remove(runTimeStack.size()-1);

        return popTop;     
    }
 
    // Push       
    public int push(int i){
        runTimeStack.add(i);
        return i;
 
    }
    
    // Starting newFrame at index runStackStack with value offset
    // e.g if RTS has args[0123] which sizes is 4, cal ARG 1, newFrame start at index 3, [012][3] 
   public void newFrameAt(int offset){
       if(offset > 0)
       framePointer.add(runTimeStack.size() - offset);
   }
   
   // Pop all the runtimeStack until it read the starting frame argument.
   // Delete the starting pointer and push value on the top of runTimeStack.
   // e.g [012][345][678] , framePointer at index 6, pop 8,7,6, also pop the FrameAt at 6, then push 8 to index 6
   // it will be [012][3458]
   public void popFrame(){
       int num = runTimeStack.get(runTimeStack.size()-1); 
       while(runTimeStack.size() > framePointer.peek()){
           runTimeStack.remove(runTimeStack.size()-1); 
       }
       
       if(framePointer.size() > 1) // This will make sure the default frame won't be delete
       framePointer.pop();
       
       runTimeStack.add(num);      
   }
   
   // Pop the top of the runTimeStack and set it to index of framePointer.
    public int store(int offset){
        int val = runTimeStack.get(runTimeStack.size()- 1);
        
        // This makes sure if won't remove the answer
        if(framePointer.size() > 1 && runTimeStack.size() >= offset){
        runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(framePointer.peek() + offset, val); 
        }
        return val;
    }
    
    // Load the code from starting framPoter at index n 
    public int load(int offset){
        int val = runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(val);
        return val;
    }
    
    
    private Integer push(Integer i){
        runTimeStack.add(i);
        return i;
    }       
       
}

