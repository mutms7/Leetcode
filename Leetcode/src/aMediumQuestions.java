import java.util.*;

public class aMediumQuestions {

    public static void main(String[] args) {
        System.out.println(checkSubarraySum(new int[] {23,2,6,4,7}, 13));
    }

    // PX
    public static String test(String s) {
        
        return "";
    }

    // P11 OK

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length-1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, (j-i)*Math.min(height[i],height[j]));
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }

    // P15 NO TLE
    
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sols = new ArrayList<>();
        Arrays.sort(nums);
        int f = 0;
        int l = nums.length-1;
        for (int i = 1; i <= nums.length-2; i++) {
            while (f < i && i < l) {
                if (nums[f] + nums[i] + nums[l] > 0) {
                    l--;
                } else if (nums[f] + nums[i] + nums[l] < 0) {
                    f++;
                } else {
                    sols.add(Arrays.asList(nums[f], nums[i], nums[l]));
                    l--;
                    f++;
                }
            }
            f = 0;
            l = nums.length-1;
        }
        List<List<Integer>> uniqsols = new ArrayList<>();
        for (int i = 0; i < sols.size(); i++) {
            if (!uniqsols.contains(sols.get(i))) {
                uniqsols.add(sols.get(i));
            }
        }
        return uniqsols;
    }

    // P128 OK
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

    // P167 OK
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int h = numbers.length-1;
        while (l < h) {
            if (numbers[l] + numbers[h] > target) {
                h--;
            } else if (numbers[l] + numbers[h] < target) {
                l++;
            } else {
                return new int[] {l+1, h+1};
            }
        }
        return null;
    }

    // P523
    public static boolean checkSubarraySum(int[] nums, int k) {
        int[] sums = new int[nums.length+1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = (sums[i-1] + nums[i-1])%k;
        }
        boolean[] seen = new boolean[k];
        for (int i = 0; i < sums.length; i++) {
            if (seen[sums[i]] || seen[(k-sums[i])%k]) {
                return true;
            } else {
                seen[sums[i]] = true;
            }
        }
        return false;
    }

    // P560 OK
    public static int subarraySum(int[] nums, int k) {
        int[] presum = new int[nums.length+1];
        presum[1] = nums[0];
        for (int i = 2; i < presum.length; i++) {
            presum[i] = presum[i-1] + nums[i-1];
        }
        int sbrry = 0;
        for (int i = 0; i < presum.length-1; i++) {
            for (int j = i+1; j < presum.length; j++) {
                if (presum[j] - presum[i] == k) {
                    sbrry++;
                }
            }
        }
        return sbrry;
    }

    // P659 NO
    public static boolean isPossible(int[] nums) {

        return false;
        /*
        if (nums.length < 3) {
            return false;
        }git
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

    


    // P792 OK
    public static int numMatchingSubseq(String s, String[] words) {
        HashMap<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        int index = 0;
        int num = 0;
        for (String word : counts.keySet()) {
            index = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == word.charAt(index)) {
                    index++;
                }
                if (index == word.length()) {
                    num += counts.get(word);
                    break;
                }
            }
        }
        return num;
    }

    // P974 OK

    public static int subarraysDivByK(int[] nums, int k) {
        int[] sums = new int[nums.length+1];
        sums[1] = (nums[0]+k*10000)%k;
        for (int i = 2; i < nums.length+1; i++) {
            sums[i] = (sums[i-1] + nums[i-1] +k*10000)%k;
        }
        int count = 0;
        for (int i = 0; i < sums.length-1; i++) {
            for (int j = i+1; j < sums.length; j++) {
                if ((sums[j] - sums[i]) == 0) {
                    count++;
                }
            }
        }
        return count;
    }


    // P1525 OK
    public static int numSplits(String s) {
        if (s.length() == 1) {
            return 0;
        }
        HashMap<Character, Integer> firstapp = new HashMap<>();
        HashMap<Character, Integer> lastapp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) { 
            if (!firstapp.containsKey(s.charAt(i))) {
                firstapp.put(s.charAt(i), i); //makes a map of where each letter occurs first
            }
            if (!lastapp.containsKey(s.charAt(s.length()-1-i))) {
                lastapp.put(s.charAt(s.length()-1-i), s.length()-1-i); //makes a map of where each letter occurs last
            }
        }

        ArrayList<Integer> firsts = new ArrayList<>(firstapp.values());
        ArrayList<Integer> lasts = new ArrayList<>(lastapp.values());

        ArrayList<Integer> sigs = new ArrayList<>();
        for (int i : firsts) {
            if (!sigs.contains(i)) {
                sigs.add(i);
            }
        }
        for (int i : lasts) {
            if (!sigs.contains(i)) {
                sigs.add(i);
            }
        }

        Collections.sort(firsts); //sorted list of all the places where a letter appears for the first time
        Collections.sort(lasts); //sorted list of all the places where a letter appears for the last time
        Collections.sort(sigs); //sorted list of all the significant spots where the "good" can start and end

        for (int i = 0; i < sigs.size(); i++) { //going through all sig spots
            int beforeandthere = 0;
            for (int j = 0; j < firsts.size(); j++) { //how many first appearance letters are before and including current sig spot
                if (firsts.get(j) > sigs.get(i)) {
                    break;
                }
                beforeandthere++; 
            }
            int after = 0;
            for (int j = lasts.size()-1; j >= 0; j--) { //how many last appearnace letters are after current sig spot
                if (lasts.get(j) <= sigs.get(i)) {
                    break;
                }
                after++; 
            }
            if (beforeandthere == after) {
                return sigs.get(i+1) - sigs.get(i);
            }
        }
        
        /*
        int start = 0;
        int end = s.length()-1;

        int pos1 = 0;
        int pos2 = s.length()-1;

        int diff1 = 0;
        int diff2 = 0;
        while (true) {
            if (diff1 <= diff2) {

            } else {

            }
            if (firstapp.containsValue(i)) {
                st = i;
            }
            if (lastapp.containsValue(s.length()-1-i)) {
                en = s.length()-1-i;
            }
        }*/


        return 0;
    }
}