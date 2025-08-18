import java.util.*;

public class aMediumQuestions {
    
	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
	}

	
	//P151 OK
	public static String reverseWords(String s) {
        String[] spaces = s.split(" ");
        String reversed = "";
        for (int i = spaces.length-1; i >= 0; i--) {
            if (!spaces[i].equals("")) {
                reversed = reversed + spaces[i] + " ";
            }
        }
        reversed = reversed.substring(0, reversed.length()-1);
        return reversed;
    }

    //P128 YES
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
            if (sortedList.get(i) == sortedList.get(i-1) + 1) {
                count++;
                max = Math.max(count, max);
            } else {
                count = 1;
            }
        }
        return max;
        
    }

    //P659 
    public static boolean isPossible(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] += 1000;
        }
        Map<Integer, Integer> mp = new HashMap<>(); //make map a list that can do contains AND find the i th item
        for (int i : nums) {
            if (mp.containsKey(i)) {
                mp.put(i, mp.get(i) + 1);
            } else {
                mp.put(i, 1);
            }
        }

        while (!mp.isEmpty()) {
            int length = 0;
            int current = -10;
            LinkedList<Integer> remove = new LinkedList<>();
            for (int i = 0; i < mp.size(); i++) {
                if (length == 0) { //need to find a way to get the i th item in the list
                    current = mp.values().iterator().next();
                }
            }
        }

        return true;
    }
}
