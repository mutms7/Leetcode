import java.util.*;

public class aEasyQuestions {

    public static void main(String[] args) {
        merge(new int[] {1,2,3,0,0,0}, 3, new int[] {2,5,6}, 3);
        
    }

    // PX
    public static String test(String s) {
        
        return "y";
    }

    // P496

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums2.length; ++i) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                hash.put(nums2[stack.pop()], nums2[i]);
            }
            stack.push(i);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hash.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }

    // P160
    /*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode A = headA, B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }*/

    // P88 
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] totalnums = new int[m+n];
        int in1 = 0;
        int in2 = 0;

        for (int i = 0; i < m+n; i++) {
        if (in1 >= m) {
            totalnums[i] = nums2[in2];
            in2++;
        } else if (in2 >= n) {
            totalnums[i] = nums1[in1];
            in1++;
        } else if (nums1[in1] >= nums2[in2]) {
            totalnums[i] = nums2[in2];
            in2++;
        } else {
            totalnums[i] = nums1[in1];
            in1++;
        }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = totalnums[i];
        }
    }
}

