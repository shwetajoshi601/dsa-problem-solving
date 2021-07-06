import java.util.*;

public class StackImplementThreeStacksInAnArray {
  
    public static void main(String args[]) {
      ThreeStacks myStacks = new ThreeStacks(3);
      myStacks.push(0, 1);
      myStacks.push(1, 1);
      myStacks.push(2, 1);
      
      System.out.println(myStacks.size(0));
      System.out.println(myStacks.size(1));
      System.out.println(myStacks.size(2));
      
      myStacks.pop(0);
      myStacks.pop(1);
      myStacks.pop(2);
      
      System.out.println(myStacks.size(0));
      System.out.println(myStacks.size(1));
      System.out.println(myStacks.size(2));
    }
}

class ThreeStacks {
    // array containing three stacks
    int[] values;
    // store the sizes of the three stacks
    int[] sizes;
    int numberOfStacks = 3;
    // size of each stack
    int stackCapacity;
    
    ThreeStacks(int stackSize) {
        stackCapacity = stackSize;
        sizes = new int[numberOfStacks];
        // total size of the array depends on number of stacks and size of each stack
        values = new int[numberOfStacks * stackCapacity];
    }
    
    void push(int stackNumber, int value) {
        if(isFull(stackNumber))
        // ideally raise an exception
            return;
            
        // important to increase the size first to get the correct topIndex
        sizes[stackNumber]++;
        // we do not use variables for keeping a track of the top
        // getTop method calculates the current top based on the size
        int topIndex = getTopIndex(stackNumber);
        values[topIndex] = value;
    }
    
    int pop(int stackNumber) {
        if(isEmpty(stackNumber))
            return -1;
        
        // get the top index
        int topIndex = getTopIndex(stackNumber);
        // get value at that index
        int value = values[topIndex];
        values[topIndex] = 0; // clear
        sizes[stackNumber]--; // reduce the size
        
        return value;
    }
    
    boolean isEmpty(int stackNumber) {
        return sizes[stackNumber] == 0;
    }
    
    boolean isFull(int stackNumber) {
        return sizes[stackNumber] == stackCapacity;
    }
    
    int size(int stackNumber) {
        return sizes[stackNumber];
    }
    
    int getTopIndex(int stackNumber) {
        // we know the stack size, stack capacity and the stack numberOfStacks
        // to get the top index, we need to leave stackCapacity no. of elements
        // for the previous stacks -> which means stackNumber * stackCapacity.
        int offset = stackNumber * stackCapacity;
        // Now the top will be after elements that are already in the stackCapacity
        // this is given by size
        // hence following is the topIndex
        int size = sizes[stackNumber];
        return offset + size - 1;
    }
}