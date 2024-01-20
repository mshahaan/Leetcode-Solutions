public class TwoNum {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // CREATE RESULT LIST TO STORE RESULT
        ListNode result = new ListNode();

        // SET UP TEMP VARIABLES FOR LIST TRAVERSAL
        ListNode l3 = result;
        int remainder = 0;

        // CREATE LOOP THAT LOOPS OVER BOTH LISTS AT THE SAME TIME
        while(l1 != null || l2 != null || remainder > 0){

            // HANDLE CASE WHERE LISTS ARE NULL BUT REMAINDER IS NONZERO
            if(l1 == null && l2 == null && remainder > 0){
                l3.val = remainder;
                break;
            }

            // CHECK IF ANY LIST IS NULL
            if(l1 == null){

                // RETRIEVE NUMBER OF NON-NULL LIST PLUS ANY REMAINDER
                int current = l2.val + remainder;

                // RESET REMAINDER
                remainder = 0;

                // CHART THE REMAINDER FOR NEXT LOOP ITERATION
                if(current > 9){
                    remainder = 1;
                    while(current > 9) current = current - 10;
                }

                // ADD NUMBER TO RESULT LIST
                l3.val = current;
                if(l2.next != null || remainder > 0) l3.next = new ListNode();

                // ITERATE THE LIST POINTERS
                l2 = l2.next;
                l3 = l3.next;

                // JUMP TO NEXT LOOP ITERATION
                continue;

            }

            if(l2 == null){

                // RETRIEVE NUMBER OF NON-NULL LIST PLUS ANY REMAINDER
                int current = l1.val + remainder;

                // RESET REMAINDER
                remainder = 0;

                // CHART THE REMAINDER FOR NEXT LOOP ITERATION
                if(current > 9){
                    remainder = 1;
                    while(current > 9) current = current - 10;
                }

                // ADD NUMBER TO RESULT LIST
                l3.val = current;
                if(l1.next != null || remainder > 0) l3.next = new ListNode();

                // ITERATE THE LIST POINTERS
                l1 = l1.next;
                l3 = l3.next;

                // JUMP TO NEXT LOOP ITERATION
                continue;

            }

            // ADD NUMBERS OF EACH LIST WITH THE PREVIOUS LOOPS REMAINDER
            int current = l1.val + l2.val + remainder;

            // RESET REMAINDER
            remainder = 0;

            // CHART THE REMAINDER FOR NEXT LOOP ITERATION
            if(current > 9){
                remainder = 1;
                while(current > 9) current = current - 10;
            }

            // ADD ANSWER TO RESULT LIST
            l3.val = current;
            if(l1.next != null || l2.next != null || remainder > 0) l3.next = new ListNode();

            // ITERATE THE LIST POINTERS
            l1 = l1.next;
            l2 = l2.next;
            l3 = l3.next;
        }

        // RETURN THE RESULT
        return result;
        
    }

    public static void main(String[] args) {
        ListNode operand1 = new ListNode();
        ListNode operand2 = new ListNode();
    
        turnIntoList(operand1, "9999999");
        turnIntoList(operand2, "9999");

        ListNode result = addTwoNumbers(operand1, operand2);
        
        System.out.println("----------------SOLUTION-----------------");
        printList(result);
        
    }
    
    public static void turnIntoList(ListNode listNode, String num){

        ListNode test = listNode;
    
        for (int i = 0; i < num.length(); i++) {
            listNode.val = Integer.parseInt(num.substring(i, i+1));
            if(i != num.length()-1){
                listNode.next = new ListNode();
                listNode = listNode.next;
            }
        }

        System.out.println("----------------OPERAND-----------------");
        printList(test);
        System.out.println("");
        System.out.println("");
    
    }

    public static void printList(ListNode listNode){

        System.out.print("[ ");

        while(listNode != null){
            System.out.print(listNode.val);
            if(listNode.next != null) System.out.print(", ");
            listNode = listNode.next;
        }

        System.out.print(" ]");

    }
}

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}