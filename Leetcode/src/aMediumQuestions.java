import java.util.*;

public class aMediumQuestions {

    // PX
    public static String test(String s) {
        
        return "";
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAA", 0));
    }
    

    // P424
        
    public static int maxelement(int[] k) {
        int max = 0;
        for (int i = 0; i < k.length; i++) {
            max = Math.max(max, k[i]);
        }

        return max;
    }
    public static int characterReplacement(String s, int k) {
        int[] occurs = new int[26];
        int start = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            while (i-start > maxelement(occurs)+k) {
                occurs[s.charAt(start)-'A']--;
                start++;
            }
            occurs[s.charAt(i)-'A']++;
            max = Math.max(max, Math.min(maxelement(occurs)+k, s.length()));
        }

        return max;
    }

    // P3
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> occurance = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) { // abcabcbb
            char cur = s.charAt(i);
            if (occurance.containsKey(cur)) {
                start = Math.max(start, occurance.get(cur)+1);
            }
            occurance.put(cur, i);
            max = Math.max(max, i-start+1);

        }

        return max;
    }

    //2461
    public static long maximumSubarraySum(int[] nums, int k) {
        int[] occurs = new int[100001];
        long sum = 0;
        long maxsum = 0;
        boolean valid = true;
        for (int i = 0; i < k; i++) {
            int current = nums[i];
            sum += current;
            if (occurs[current] > 0) {
                valid = false;
            }
            occurs[current]++;
        }
        if (valid) {
            maxsum = Math.max(maxsum, sum);
        }
        ABC : for (int i = 1; i+k-1 < nums.length; i++) {
            sum -= nums[i-1];
            occurs[nums[i-1]]--;
            sum += nums[i+k-1];
            occurs[nums[i+k-1]]++;
            for (int j = 0; j < occurs.length; j++) {
                if (occurs[j] > 1) {
                    continue ABC;
                }
            }
            maxsum = Math.max(maxsum, sum);
        }

        return maxsum;
    }

    // P567 OK
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] target = new int[26];
        int[] current = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            target[s1.charAt(i)-'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            current[s2.charAt(i)-'a']++;
        }
        boolean match = true;
        for (int i = 0; i < 26; i++) {
            if (target[i] != current[i]) {
                match = false;
                break;
            }
        }
        if (match) {
            return true;
        }
        for (int i = 1; i + s1.length()-1 < s2.length(); i++) {
            current[s2.charAt(i - 1)-'a']--;
            current[s2.charAt(i + s1.length()-1)-'a']++;
            boolean match1 = true;
            for (int j = 0; j < 26; j++) {
                if (target[j] != current[j]) {
                    match1 = false;
                    break;
                }
            }
            if (match1) {
                return true;
            }
        }


        return false;
    }

    // P438 OK
    public static List<Integer> findAnagrams(String s, String p) {
        LinkedList<Integer> indices = new LinkedList<>();
        if (p.length() > s.length()) {
            return indices;
        }
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        for (int i = 'a'; i < 'z'+1; i++) {
            target.put((char) i, 0);
            current.put((char) i, 0);
        }


        for (int i = 0; i < p.length(); i++) {
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
            current.put(p.charAt(i), 0);
        }
        for (int i = 0; i < p.length(); i++) {
            current.put(s.charAt(i), current.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean match = true;
        for (int i = 'a'; i <= 'z'; i++) {
            if (!target.get((char) i).equals(current.get((char) i))) {
                match = false;
                break;
            }
        }
        if (match) {
            indices.add(0);
        }

        for (int i = 1; i + p.length()-1 < s.length(); i++) {
            current.put(s.charAt(i - 1), current.getOrDefault(s.charAt(i - 1), 0) - 1);
            current.put(s.charAt(i + p.length()-1), current.getOrDefault(s.charAt(i + p.length()-1), 0) + 1);
            boolean match1 = true;
            for (int j = 'a'; j <= 'z'; j++) {
                if (!target.get((char) j).equals(current.get((char) j))) {
                    match1 = false;
                    break;
                }
            }
            if (match1) {
                indices.add(i);
            }
        }
 


        return indices;
    }

    // P525
    public static int findMaxLength(int[] nums) {
        int[] sums = new int[nums.length+1];
        for (int i = 1; i < sums.length; i++) {
            int change;
            if (nums[i-1] == 0) {
                change = -1;
            } else {
                change = 1;
            }
            sums[i] = sums[i-1] + change;
        }
        int[] seen = new int[200001];
        Arrays.fill(seen, -1);
        int max = 0;
        for (int i = 0; i < sums.length; i++) {
            int count = sums[i] + 100000;
            if (seen[count] == -1) {
                seen[count] = i;
            } else {
                max = Math.max(max, i - seen[count]);
            }
        }

        return max;
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

    // P523 NO
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        if (nums.length == 2) {
            return ((nums[0]+nums[1])%k == 0);
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0]%k;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = (sums[i-1] + nums[i])%k;
        }
        boolean[] seen = new boolean[k];
        int queue = sums[0];
        for (int i = 1; i < sums.length; i++) {
            if (seen[sums[i]]) {
                return true;
            } else {
                seen[queue] = true;
                queue = sums[i];
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