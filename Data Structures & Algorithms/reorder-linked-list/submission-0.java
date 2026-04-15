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

class Solution {
    public void reorderList(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> storeValue = new ArrayList<>();
        ListNode temp = head;
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyNode = dummyHead;
        while (temp!=null){
            list.add(temp.val);
            temp = temp.next;
        }

        int x = 0;
        int y = list.size()-1;
        while (x<y){
            storeValue.add(list.get(x));
            storeValue.add(list.get(y));
            x++;
            y--;
        }

        if (x == y) {
            storeValue.add(list.get(x)); // middle element once
        }

        for (int i=0;i<storeValue.size();i++){
            ListNode nn = new ListNode(storeValue.get(i));
            dummyNode.next = nn;
            dummyNode = dummyNode.next;

        }

        while (head!=null){
            head.val = dummyHead.next.val;
            head = head.next;
            dummyHead = dummyHead.next;
        }
        
    }
}
