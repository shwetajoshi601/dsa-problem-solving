import java.util.*;

public class RecursionSortAnArray {
    static void sort(List<Integer> list) {
        if(list.size() == 1)
            return;
            
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        
        sort(list);
        insert(list, temp);
    }
    
    static void insert(List<Integer> list, int num) {
        if(list.size() == 0 || list.get(list.size()-1) <= num) {
            list.add(num);
            return;
        }
        
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        insert(list, num);
        
        list.add(temp);
    }
    
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(4);
        list.add(0);
        list.add(1);
        list.add(2);
        
        System.out.println("List before sorting: ");
        for(Integer j: list)
            System.out.print(j.intValue() + " ");

        sort(list);
        
        System.out.println();
        System.out.println("List after sorting: ");
        for(Integer i: list)
            System.out.print(i.intValue() + " ");
    }
}
