import java.util.*;

public class HardQuestions {

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("BANC".substring(0, 4));
    }

    // PX
    public static String test(String s) {
        
        return "";
    }

    //P25
    /*
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode others = kthList(head, k);
        if (others != null && others.val == -1) {
            return head;
        }
        others = reverseKGroup(others, k);
        for (int i = 0; i < k; i++) {
            others = new ListNode(head.val, others);
            head = head.next;
        }
        return others;
    }

    public ListNode kthList(ListNode head, int k) {
        if (k == 0) {
            return head;
        } else if (head == null) {
            return new ListNode(-1);
        } else {
            return kthList(head.next, k-1);
        }
    }
    */

    //P76
    public static String minWindow(String s, String t) {
        int[] tcount = new int[58];
        int[] scount = new int[58];

        for (int i = 0; i < t.length(); i++) {
            tcount[t.charAt(i)-'A']++;
        }

        int start = 0;
        String minsub = "";
        for (int i = 0; i < s.length(); i++) {
            scount[s.charAt(i)-'A']++;
            boolean included = true;
            for (int j = 0; j < scount.length; j++) {
                if (scount[j] < tcount[j]) {
                    included = false;
                    break;
                }
            }
            while (included) {
                scount[s.charAt(start)-'A']--;
                start++;
                for (int j = 0; j < scount.length; j++) {
                    if (scount[j] < tcount[j]) {
                        included = false;
                        scount[s.charAt(start-1)-'A']++;
                        start--;
                        break;
                    }
                }
                if (minsub.equals("") || minsub.length() > i-start) {
                    minsub = s.substring(start, i+1);
                }
            }
        }

        return minsub;
    }

    //P42
    public static int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int lh = 0;
        int rh = 0;
        int water = 0;
        while (l <= r) {
            if (lh >= rh) { //l is taller
                if (rh <= height[r]) {
                    rh = height[r];
                } else {
                    water += rh - height[r];
                }
                r--;
            } else { //r is taller
                if (lh <= height[l]) {
                    lh = height[l];
                } else {
                    water += lh - height[l];
                }
                l++;
            }
        }

        return water;
    }
}