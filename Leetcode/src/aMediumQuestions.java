import java.util.*;

public class aMediumQuestions {

    public static void main(String[] args) {
        System.out.println(isPossible(new int[] {1,2,3,3,4,5}));
    }

    // P151 OK
    public static String reverseWords(String s) {
        String[] spaces = s.split(" ");
        String reversed = "";
        for (int i = spaces.length - 1; i >= 0; i--) {
            if (!spaces[i].equals("")) {
                reversed = reversed + spaces[i] + " ";
            }
        }
        reversed = reversed.substring(0, reversed.length() - 1);
        return reversed;
    }

    // P128 YES
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        List<Integer> sortedList = new ArrayList<>(hs);
        Collections.sort(sortedList);
        int max = 1;
        int count = 1;
        for (int i = 0; i < sortedList.size(); i++) {
            if (sortedList.get(i) == sortedList.get(i - 1) + 1) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
        }
        return max;

    }

    // P659 NO
    public static boolean isPossible(int[] nums) {

        return false;
        /*
        if (nums.length < 3) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1000;
        }
        int[] freq = new int[2001]; // 0,... 2000
        for (int i : nums) {
            freq[i]++;
        }
        ABC : while (true) {
            int start = 0;
            int count = 0;
            for (int i = 0; i < freq.length; i++) {
                if (start == 0) {
                    if (freq[i] > 0) {
                        start = freq[i];
                        count++;
                        freq[i]--;
                    }
                } else {
                    if (freq[i] >= start) {
                        count++;
                        freq[i]--;
                    } else {
                        if (count < 3) {
                            return false;
                        } else {
                            continue ABC;
                        }
                    }
                }
                
            }
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0) {
                    continue ABC;
                }
            }
            return true;
        } */

    /*
     * Map<Integer, Integer> mp = new HashMap<>(); //make map a list that can do
     * contains AND find the i th
     * for (int i : nums) {
     * if (mp.containsKey(i)) {
     * mp.put(i, mp.get(i) + 1);
     * } else {
     * mp.put(i, 1);
     * }
     * }
     * 
     * while (!mp.isEmpty()) {
     * int length = 0;
     * int current = -10;
     * LinkedList<Integer> remove = new LinkedList<>();
     * for (int i = 0; i < mp.size(); i++) {
     * if (length == 0) { //need to find a way to get the i th item in the list
     * current = mp.values().iterator().next();
     * }
     * }
     * }
     * 
     * return true;
     */
    
}
}