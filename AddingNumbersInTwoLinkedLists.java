class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    ListNode temp=null, tail = null; 
    int carry = 0;
    while(l1!=null && l2!=null){
        int n1 = l1.val;
        int n2 = l2.val;
        int sum = n1 + n2;
        
        if((sum+carry)<10){
            ListNode curr = new ListNode(sum+carry);
            curr.next = null;
            
            if(temp==null){
                temp = curr;
                tail = curr;
            }else{
                tail.next = curr;
                tail = curr;
            }
            carry = 0;
        }else{
            int value = (sum+carry)%10;
         
            ListNode curr = new ListNode(value);
            curr.next = null;
            if(temp==null){
                temp = curr;
                tail = curr;
            }else{
                tail.next = curr;
                tail = curr;
            }
            
            carry = 1;            
       
        }
        
        l1 = l1.next;
        l2 = l2.next;
        
    }
    
    
        
    while(l1!=null){
        if((carry+l1.val)==10){
            ListNode cur = new ListNode(0);
            tail.next = cur;
            tail = cur;
        }else{
            ListNode cur = new ListNode(l1.val+carry);
            tail.next = cur;
            tail = cur;
            carry = 0;
        
        }
        l1 = l1.next;
    }
        
        
    while(l2!=null){
        if((carry+l2.val)==10){
            ListNode cur = new ListNode(0);
            tail.next = cur;
            tail = cur;
        }else{
            ListNode cur = new ListNode(l2.val+carry);
            tail.next = cur;
            tail = cur;
            carry = 0;
        
        }
        l2 = l2.next;
    }
    
    if(carry == 1){
        ListNode finalNode = new ListNode(1);
        tail.next = finalNode;
        tail = finalNode;
    }
    
    return temp;
    }
}
