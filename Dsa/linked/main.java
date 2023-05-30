package Dsa.linked;
import Dsa.linked.linkedlist;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        linkedlist l1 = new linkedlist();
        linkedlist l2 = new linkedlist();
        linkedlist l3=new linkedlist();
        l1.addatend(2);
        l1.addatend(4);
        l1.addatend(3);
        l2.addatend(5);
        l2.addatend(6);
        l2.addatend(4);
       add(l1,l2,l3);
       l3.transverse();
       //l1.addatend(4);
       // l1.addatend(5);
        //System.out.println(l1.head.value);
        rotate(l1,10);
        //l1.transverse();

    }
    public static void add(linkedlist ll,linkedlist ll2,linkedlist ll3){
        int carry=0;
        linkedlist.node n1=ll.head;
        linkedlist.node n2=ll2.head;
        while(n1!=null || n2!=null){
            int x,y,sum;
            if(n1==null){
                y=n2.value;
                sum=y+carry;
                carry=sum/10;
                ll3.addatend(sum%10);
                n2=n2.next;
            }
            else if(n2==null){
                x=n1.value;
                sum=x+carry;
                carry=sum/10;
                ll3.addatend(sum%10);
                n1=n1.next;
            }
            else{
                x=n1.value;
                y=n2.value;
                sum=x+y+carry;
                carry=sum/10;
                ll3.addatend(sum%10);
                n1=n1.next;
                n2=n2.next;
            }
        }
        if (carry!=0){
            ll3.addatend(carry);
        }
    }
    public static void rotate2(linkedlist ll , int turns){
        int x=turns%ll.size;
        int times=ll.size-x;
        int number=1;
        linkedlist.node intial_head=ll.head;
        linkedlist.node n=ll.head;
        while(number!=times){
            n=n.next;
            number=number+1;
        }
        linkedlist.node end=n;
        ll.head=n.next;
        while(n.next!=null){
            n=n.next;
        }
        n.next=intial_head;
        end.next=null;
    }
    public static void rotate(linkedlist ll,int turns){
        for(int i=0;i<turns;i++){
            linkedlist.node n=ll.head;
            linkedlist.node prev=ll.head;
            while(n.next!=null){
                prev=n;
                n=n.next;
            }
            prev.next=null;
            n.next=ll.head;
            ll.head=n;
        }
    }
    public static Boolean palindrome(linkedlist ll){
        linkedlist.node slow=ll.head;
        linkedlist.node fast=ll.head;
        linkedlist.node tp=null;
        while(fast!=null && fast.next!=null){
            tp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        linkedlist.node prev=null;
        linkedlist.node n=slow;
        linkedlist.node next=slow.next;
        while(n.next!=null){
            n.next=prev;
            prev=n;
            n=next;
            next=n.next;
        }
        n.next=prev;
        tp.next=n;

        linkedlist.node flag=n;
        linkedlist.node pointer =ll.head;
        while(pointer!=flag){
            if(pointer.value!= n.value){
                return false;
            }
            pointer=pointer.next;
            n=n.next;
        }
        return true;
    }
    public static void reverse(linkedlist ll){
        linkedlist.node prev=null;
        linkedlist.node n=ll.head;
        linkedlist.node next=n.next;
        while(n.next!=null){
            n.next=prev;
            prev=n;
            n=next;
            next=n.next;
        }
        n.next=prev;
        ll.head=n;
    }
    public static void reverse2(linkedlist ll,int left,int right) {
        if (left != right) {
            linkedlist.node n = ll.head;
            while (n.next != null) {
                if(n.next.value != left) {
                    n = n.next;
                }
                else{
                    break;
                }
            }
            if (n.next != null) {
                linkedlist.node start = n;
                linkedlist.node end = n.next;
                linkedlist.node i = end.next;
                linkedlist.node prev = end;
                linkedlist.node next = end.next.next;

                while (i.value != right) {
                    i.next = prev;
                    prev = i;
                    i = next;
                    next = i.next;
                }
                i.next = prev;
                start.next = i;
                end.next = next;
            }
        }
    }

    public static linkedlist sort(linkedlist ll){
        int size=ll.size;
        for(int i=size-2;i>=0;i--) {
            linkedlist.node n=ll.head;
            linkedlist.node prev=ll.head;
            for (int j = 0; j <= i; j++) {
                linkedlist.node first = n;
                linkedlist.node second = n.next;
                if (first.value > second.value) {
                    if (first.value == ll.head.value) {
                        first.next = second.next;
                        second.next = first;
                        ll.head = second;
                    } else {
                        first.next = second.next;
                        second.next = first;
                        prev.next = second;

                    }
                    prev = second;
                    n = second.next;
                }
                else {
                    n = n.next;
                }
            }
            }
        return ll;
        }
    public static Boolean linkedlistcycle(linkedlist x){
        linkedlist.node fast=x.head;
        linkedlist.node slow=x.head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }
    public static int linkedlistcyclelength(linkedlist x){
        linkedlist.node fast=x.head;
        linkedlist.node slow=x.head;
        int count=0;
        while(fast!=null && fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            //once u find same meeting point freeze the fast pointer
            //and start increasing slow pointer one by one and increase count by 1
            //till again it reach the fast pointer
            if (fast == slow) {
                count = 1;
                while (slow != fast) {
                    count = count + 1;
                    slow = slow.next;
                }
                return count;
            }
        }
        return count;
    }
    public static linkedlist.node startingpointofthecycle(linkedlist x) {
        linkedlist.node fast = x.head;
        linkedlist.node slow = x.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                slow = x.head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
    public static void mergeTwoLists(linkedlist.node list1, linkedlist.node list2) {
        linkedlist l3 = new linkedlist();
        linkedlist.node n1 = list1;
        linkedlist.node n2 = list2;
        while (n1 != null && n2 != null) {
            if (n1.value <= n2.value) {
                l3.addatend(n1.value);
                n1 = n1.next;
            } else {
                l3.addatend(n2.value);
                n2 = n2.next;
            }
        }
        while (n1 != null) {
            l3.addatend(n1.value);
            n1 = n1.next;
        }
        while (n2 != null) {
            l3.addatend(n2.value);
            n2 = n2.next;
        }
       l3.transverse();
    }

}
