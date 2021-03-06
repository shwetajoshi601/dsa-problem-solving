/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class LLAddTwoNumbersII {
    
    // function to reverse a linked list
    ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse the two numbers so that the least significant digit is first
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        // now the problem is reduced to the previous add two nos problem
        // new list for result
        ListNode res = new ListNode(-1);
        ListNode head = res;
        
        int carry = 0;
        
        while(l1 != null || l2 != null) {
            int sum = 0;
            
            if(l1 == null) {
                sum = l2.val + carry;
                l2 = l2.next;
            }
            else if(l2 == null) {
                sum = l1.val + carry;
                l1 = l1.next;
            }
            else {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            }
            
            // find carry
            if(sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else
                carry = 0;
            
            res.next = new ListNode(sum);
            res = res.next;
        }
        
        // at the end, if the carry exists
        if(carry > 0) res.next = new ListNode(carry);
        
        // the resulting number is also in reverse order, hence reverse it back
        return reverse(head.next);
    }

    // Solution -2: Follow up: Modifying the list is not allowed

    public Stack<Integer> createStackFromLL(ListNode l) {
        Stack<Integer> st = new Stack<Integer>();
        while(l != null) {
            st.push(l.val);
            l=l.next;
        }
        
        return st;
    }
    
    // without reversing, using a stack    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // create two stacks for the two numbers
        Stack<Integer> s1 = createStackFromLL(l1);
        Stack<Integer> s2 = createStackFromLL(l2);
        
        int carry = 0;
        ListNode head = null;
       
        // traverse the two stacks
        while(!s1.isEmpty() || !s2.isEmpty()) {
            System.out.println("in while");
            int sum = 0;
            if(!s1.isEmpty()) sum+= s1.pop();
            if(!s2.isEmpty()) sum+= s2.pop();

            sum+=carry;
            
            carry = sum / 10;
            sum = sum % 10;
            
            // add the node to the beginning of the list
            // MSB is first
            ListNode node = new ListNode(sum);
            if(head == null) {
                head = node;
            } else {
                node.next = head;
                head = node;
            }
        }

        // if there is a carry, add it
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            head = node;
        }
        
        return head;
    }
}