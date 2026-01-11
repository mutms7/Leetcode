import java.util.*;

public class aMediumQuestions {

    // PX
    public static String test(String s) {

        return "";
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }

// P
    class MinStack {
    int min;
    LinkedList<int[]> stack;
    

    public MinStack() {
        min = Integer.MAX_VALUE;
        stack = new LinkedList<>();
    }
    
    public void push(int val) {
        min = Math.min(min, val);
        stack.add(new int[] {val, min});
    }
    
    public void pop() {
        min = stack.pop()[1];
        
    }
    
    public int top() {
        int[] temp = stack.pop();
        min = temp[1];
        return temp[0];
    }
    
    public int getMin() {
        return min;
    }
}

    // P142

    /* 
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode shead = head;
        ListNode fhead = head;

        while (true) {
            if (fhead == null || fhead.next == null) {
                return null;
            }

            shead = shead.next;
            fhead = fhead.next.next;

            if (shead == fhead) break;
        }
        while (shead != head) {
            shead = shead.next;
            head = head.next;
        }
        return shead;
    }
        */

    // P406

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) return b[0] - a[0];
            return a[1] - b[1];
        });
        ArrayList<int[]> answer = new ArrayList<>();
        for (int[] person : people) {
            answer.add(person[1], person);
        }
        return answer.toArray(new int[people.length][2]);
    }

    // P2

    /*
     * public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     * int sum = l1.val + l2.val;
     * if (sum >= 10) {
     * return new ListNode(sum-10, addTwoNumHelp(l1.next, l2.next, true));
     * } else {
     * return new ListNode(sum, addTwoNumHelp(l1.next, l2.next, false));
     * }
     * }
     * 
     * public ListNode addTwoNumHelp(ListNode l1, ListNode l2, boolean carry) {
     * int sum = 0;
     * if (l1 == null && l2 == null) {
     * sum = 0;
     * } else if (l1 == null) {
     * sum = l2.val;
     * } else if (l2 == null) {
     * sum = l1.val;
     * } else {
     * sum = l1.val+l2.val;
     * }
     * if (carry) {
     * sum++;
     * }
     * 
     * if (l1 == null && l2 == null) {
     * if (sum == 1) {
     * return new ListNode(1, null);
     * } else {
     * return null;
     * }
     * 
     * } else if (l1 == null) {
     * if (sum >= 10) {
     * return new ListNode(sum-10, addTwoNumHelp(null, l2.next, true));
     * } else {
     * return new ListNode(sum, addTwoNumHelp(null, l2.next, false));
     * }
     * } else if (l2 == null) {
     * if (sum >= 10) {
     * return new ListNode(sum-10, addTwoNumHelp( l1.next, null, true));
     * } else {
     * return new ListNode(sum, addTwoNumHelp( l1.next, null, false));
     * }
     * } else {
     * if (sum >= 10) {
     * return new ListNode(sum-10, addTwoNumHelp( l1.next, l2.next, true));
     * } else {
     * return new ListNode(sum, addTwoNumHelp( l1.next, l2.next, false));
     * }
     * }
     * }
     */

    // P394

    /*
     * Javascript
     * function decodeString(s: string): string {
     * const tokens = s.split("");
     * let stack: [number, string][] = [];
     * let num = 0;
     * let str = "";
     * for (let token of tokens) {
     * if (token === "[") {
     * stack.push([num, str]);
     * num = 0;
     * str = "";
     * } else if (token === "]") {
     * let [count, prevStr] = stack.pop()!;
     * str = prevStr + str.repeat(count);
     * } else if (!isNaN(parseInt(token))) {
     * num = num * 10 + parseInt(token);
     * } else {
     * str += token;
     * }
     * }
     * return str;
     * };
     * 
     * public String decodeString(String s) {
     * char[] tokens = s.toCharArray();
     * Stack<Pair<Integer, String>> stack = new Stack<>();
     * int num = 0;
     * String str = "";
     * for (char token : tokens) {
     * if (token == '[') {
     * stack.push(new Pair<>(num, str));
     * num = 0;
     * str = "";
     * } else if (token == ']') {
     * Pair<Integer, String> pair = stack.pop();
     * int count = pair.getKey();
     * String prevStr = pair.getValue();
     * str = prevStr + str.repeat(count);
     * } else if (Character.isDigit(token)) {
     * num = num * 10 + Character.getNumericValue(token);
     * } else {
     * str += token;
     * }
     * }
     * return str;
     * }
     */

    public static String decodeString(String s) {
        String item = "";
        if (s.length() == 0) {
            return "";
        }
        String snum = "";
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if ('a' <= curr && curr <= 'z') {
                item += curr;
            } else if ('0' <= curr && curr <= '9') {
                snum += curr;
            } else if (curr == '[') {
                int countopen = 1;
                String recur = "";
                while (true) {
                    i++;
                    curr = s.charAt(i);
                    if (curr == '[') {
                        countopen++;
                    }
                    if (curr == ']') {
                        countopen--;
                        if (countopen == 0) {

                            String addstr = decodeString(recur);
                            for (int j = 0; j < Integer.parseInt(snum); j++) {
                                item += addstr;
                            }
                            snum = "";
                            break;
                        }
                    }
                    recur += curr;
                }
            }
        }

        return item;

    }

    // P24
    /*
     * public ListNode swapPairs(ListNode head) {
     * if (head == null) {
     * return null;
     * }
     * if (head.next == null) {
     * return head;
     * }
     * return new ListNode(head.next.val, new ListNode(head.val,
     * swapPairs(head.next.next)));
     * }
     */

    // P19

    /*
     * public ListNode removeNthFromEnd(ListNode head, int n) {
     * if (head == null) {
     * return null;
     * }
     * return removeNthFromEndh(head, linlislen(head) - n);
     * }
     * 
     * public ListNode removeNthFromEndh(ListNode head, int n) {
     * if (n == 0) {
     * return head.next;
     * }
     * return new ListNode(head.val, removeNthFromEndh(head.next, n-1));
     * }
     * 
     * public int linlislen(ListNode head) {
     * if (head == null) {
     * return 0;
     * }
     * return 1 + linlislen(head.next);
     * }
     * 
     */

    // P707
    /*
     * 
     * 
     * 
     * class MyLinkedList {
     * 
     * private static class Node{
     * int val;
     * Node next;
     * public Node(int val) {
     * this.val = val;
     * }
     * }
     * 
     * Node head = null;
     * Node tail = null;
     * int currentsize = 0;
     * 
     * public MyLinkedList() {
     * }
     * 
     * public int get(int index) {
     * if (index < 0 || index >= currentsize) {
     * return -1;
     * }
     * Node temp = head;
     * for (int i = 0; i < index; i++) {
     * temp = temp.next;
     * }
     * return temp.val;
     * }
     * 
     * private Node getNodeAtIndex(int index) {
     * if(index < 0 || index >= currentsize)
     * return null;
     * 
     * Node temp = head;
     * for(int i=0; i<index; i++){
     * temp = temp.next;
     * }
     * return temp;
     * }
     * 
     * public void addAtHead(int val) {
     * Node newNode = new Node(val);
     * newNode.next = head;
     * head = newNode;
     * if (currentsize == 0)
     * tail = head;
     * currentsize++;
     * }
     * 
     * public void addAtTail(int val) {
     * if (currentsize == 0)
     * addAtHead(val);
     * else {
     * tail.next = new Node(val);
     * tail = tail.next;
     * currentsize++;
     * }
     * }
     * 
     * public void addAtIndex(int index, int val) {
     * if (index < 0 || index > currentsize)
     * return;
     * else if (index == 0)
     * addAtHead(val);
     * else if (index == currentsize)
     * addAtTail(val);
     * else {
     * Node newNode = new Node(val);
     * Node prevNode = getNodeAtIndex(index-1);
     * newNode.next = prevNode.next;
     * prevNode.next = newNode;
     * currentsize++;
     * }
     * }
     * 
     * public void deleteAtIndex(int index) {
     * if (index < 0 || index >= currentsize)
     * return;
     * else if (currentsize == 1) {
     * head = null;
     * tail = null;
     * }
     * else if (index == 0)
     * head = head.next;
     * else if (index == currentsize-1) {
     * Node previousNode = (getNodeAtIndex(index-1));
     * previousNode.next = null;
     * tail = previousNode;
     * } else {
     * Node previousNode = (getNodeAtIndex(index-1));
     * previousNode.next = previousNode.next.next;
     * }
     * currentsize--;
     * }
     * }
     */

    // P289

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int a = -1; a <= 1; a++) {
                    for (int b = -1; b <= 1; b++) {
                        if (0 <= i + a && i + a < m && 0 <= j + b && j + b < n && !(a == 0 && b == 0)) {
                            if (board[i + a][j + b] % 2 == 1) {
                                count++;
                            }
                        }
                    }
                }

                if (board[i][j] == 0) {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                } else if (count == 2 || count == 3) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] < 2) {
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    // P179

    public static String largestNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));
        if (array[0].equals("0")) {
            return "0";
        }
        StringBuilder largest = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            largest.append(array[i]);
        }
        return largest.toString();
    }

    // P36
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (seen[board[i][j] - '1']) {
                    return false;
                }
                seen[board[i][j] - '1'] = true;
            }
        }
        for (int i = 0; i < 9; i++) {
            boolean[] seen = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                }
                if (seen[board[j][i] - '1']) {
                    return false;
                }
                seen[board[j][i] - '1'] = true;
            }
        }
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                boolean[] seen = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[i + x][j + y] == '.') {
                            continue;
                        }
                        if (seen[board[i + x][j + y] - '1']) {
                            return false;
                        }
                        seen[board[i + x][j + y] - '1'] = true;
                    }
                }
            }
        }

        return true;
    }

    // P73
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] mzero = new boolean[m];
        boolean[] nzero = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    mzero[i] = true;
                    nzero[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (mzero[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (nzero[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    // P48
    public void rotate(int[][] matrix) {
        int start = 0;
        int x = matrix.length - 1;
        int length = matrix.length - 1;
        while (start < x) {

            for (int i = start; i < x; i++) {
                int temp = matrix[start][i];
                matrix[start][i] = matrix[length - i][start];
                matrix[length - i][start] = matrix[length - start][length - i];
                matrix[length - start][length - i] = matrix[i][length - start];
                matrix[i][length - start] = temp;
            }
            start++;
            x--;
        }
    }

    // P54
    public static List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> spiral = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1,
                size = matrix.length * matrix[0].length;
        int a = 0, b = 0;
        int dirver = 0, dirhor = 1;
        for (int i = 0; i < size; i++) {
            spiral.add(matrix[a][b]);

            if (a == top && dirver == -1) {
                dirver = 0;
                dirhor = 1;
                left++;
            } else if (b == right && dirhor == 1) {
                dirver = 1;
                dirhor = 0;
                top++;
            } else if (a == bottom && dirver == 1) {
                dirver = 0;
                dirhor = -1;
                right--;
            } else if (b == left && dirhor == -1) {
                dirver = -1;
                dirhor = 0;
                bottom--;
            }

            a += dirver;
            b += dirhor;
        }

        return spiral;
    }

    // P1014
    public static int maxScoreSightseeingPair(int[] values) {
        int start = values[0];
        int max = start + values[1] - 1;
        for (int i = 2; i < values.length; i++) {
            start--;
            start = Math.max(start, values[i - 1]);
            max = Math.max(max, start + values[i] - 1);
        }

        return max;
    }

    // P152
    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            if (n < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(n, max * n);
            min = Math.min(n, min * n);

            ans = Math.max(ans, max);
        }

        return ans;
    }

    // P918
    public static int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            if (max <= current) {
                max = current;
            }
        }

        int min = nums[1];
        current = nums[1];
        for (int i = 2; i < nums.length; i++) {
            current = Math.min(nums[i], current + nums[i]);
            if (min >= current) {
                min = current;
            }
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
        }

        return Math.max(max, total - min);
    }

    // P53
    public static int maxSubArray(int[] nums) {
        int max = nums[0];
        int current = nums[0];
        for (int i = 1; i < nums.length; i++) {
            current = Math.max(nums[i], current + nums[i]);
            max = Math.max(max, current);
        }
        return max;
    }

    // P209
    public static int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;

        int[] sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        int start = 0;
        for (int i = 1; i < sums.length; i++) {
            if (start >= i) {
                continue;
            }
            while (sums[i] - sums[start] >= target) {
                min = Math.min(min, i - start);
                start++;
            }
        }

        if (min == Integer.MAX_VALUE) {
            return 0;
        }
        return min;
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
            while (i - start > maxelement(occurs) + k) {
                occurs[s.charAt(start) - 'A']--;
                start++;
            }
            occurs[s.charAt(i) - 'A']++;
            max = Math.max(max, Math.min(maxelement(occurs) + k, s.length()));
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
                start = Math.max(start, occurance.get(cur) + 1);
            }
            occurance.put(cur, i);
            max = Math.max(max, i - start + 1);

        }

        return max;
    }

    // 2461
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
        ABC: for (int i = 1; i + k - 1 < nums.length; i++) {
            sum -= nums[i - 1];
            occurs[nums[i - 1]]--;
            sum += nums[i + k - 1];
            occurs[nums[i + k - 1]]++;
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
            target[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s1.length(); i++) {
            current[s2.charAt(i) - 'a']++;
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
        for (int i = 1; i + s1.length() - 1 < s2.length(); i++) {
            current[s2.charAt(i - 1) - 'a']--;
            current[s2.charAt(i + s1.length() - 1) - 'a']++;
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
        for (int i = 'a'; i < 'z' + 1; i++) {
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

        for (int i = 1; i + p.length() - 1 < s.length(); i++) {
            current.put(s.charAt(i - 1), current.getOrDefault(s.charAt(i - 1), 0) - 1);
            current.put(s.charAt(i + p.length() - 1), current.getOrDefault(s.charAt(i + p.length() - 1), 0) + 1);
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
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            int change;
            if (nums[i - 1] == 0) {
                change = -1;
            } else {
                change = 1;
            }
            sums[i] = sums[i - 1] + change;
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
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
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
        int l = nums.length - 1;
        for (int i = 1; i <= nums.length - 2; i++) {
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
            l = nums.length - 1;
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
        int h = numbers.length - 1;
        while (l < h) {
            if (numbers[l] + numbers[h] > target) {
                h--;
            } else if (numbers[l] + numbers[h] < target) {
                l++;
            } else {
                return new int[] { l + 1, h + 1 };
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
            return ((nums[0] + nums[1]) % k == 0);
        }
        int[] sums = new int[nums.length];
        sums[0] = nums[0] % k;
        for (int i = 1; i < sums.length; i++) {
            sums[i] = (sums[i - 1] + nums[i]) % k;
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
        int[] presum = new int[nums.length + 1];
        presum[1] = nums[0];
        for (int i = 2; i < presum.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        int sbrry = 0;
        for (int i = 0; i < presum.length - 1; i++) {
            for (int j = i + 1; j < presum.length; j++) {
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
         * if (nums.length < 3) {
         * return false;
         * }git
         * for (int i = 0; i < nums.length; i++) {
         * nums[i] += 1000;
         * }
         * int[] freq = new int[2001]; // 0,... 2000
         * for (int i : nums) {
         * freq[i]++;
         * }
         * ABC : while (true) {
         * int start = 0;
         * int count = 0;
         * for (int i = 0; i < freq.length; i++) {
         * if (start == 0) {
         * if (freq[i] > 0) {
         * start = freq[i];
         * count++;
         * freq[i]--;
         * }
         * } else {
         * if (freq[i] >= start) {
         * count++;
         * freq[i]--;
         * } else {
         * if (count < 3) {
         * return false;
         * } else {
         * continue ABC;
         * }
         * }
         * }
         * 
         * }
         * for (int i = 0; i < freq.length; i++) {
         * if (freq[i] > 0) {
         * continue ABC;
         * }
         * }
         * return true;
         * }
         */

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
        int[] sums = new int[nums.length + 1];
        sums[1] = (nums[0] + k * 10000) % k;
        for (int i = 2; i < nums.length + 1; i++) {
            sums[i] = (sums[i - 1] + nums[i - 1] + k * 10000) % k;
        }
        int count = 0;
        for (int i = 0; i < sums.length - 1; i++) {
            for (int j = i + 1; j < sums.length; j++) {
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
                firstapp.put(s.charAt(i), i); // makes a map of where each letter occurs first
            }
            if (!lastapp.containsKey(s.charAt(s.length() - 1 - i))) {
                lastapp.put(s.charAt(s.length() - 1 - i), s.length() - 1 - i); // makes a map of where each letter
                                                                               // occurs last
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

        Collections.sort(firsts); // sorted list of all the places where a letter appears for the first time
        Collections.sort(lasts); // sorted list of all the places where a letter appears for the last time
        Collections.sort(sigs); // sorted list of all the significant spots where the "good" can start and end

        for (int i = 0; i < sigs.size(); i++) { // going through all sig spots
            int beforeandthere = 0;
            for (int j = 0; j < firsts.size(); j++) { // how many first appearance letters are before and including
                                                      // current sig spot
                if (firsts.get(j) > sigs.get(i)) {
                    break;
                }
                beforeandthere++;
            }
            int after = 0;
            for (int j = lasts.size() - 1; j >= 0; j--) { // how many last appearnace letters are after current sig spot
                if (lasts.get(j) <= sigs.get(i)) {
                    break;
                }
                after++;
            }
            if (beforeandthere == after) {
                return sigs.get(i + 1) - sigs.get(i);
            }
        }

        /*
         * int start = 0;
         * int end = s.length()-1;
         * 
         * int pos1 = 0;
         * int pos2 = s.length()-1;
         * 
         * int diff1 = 0;
         * int diff2 = 0;
         * while (true) {
         * if (diff1 <= diff2) {
         * 
         * } else {
         * 
         * }
         * if (firstapp.containsValue(i)) {
         * st = i;
         * }
         * if (lastapp.containsValue(s.length()-1-i)) {
         * en = s.length()-1-i;
         * }
         * }
         */

        return 0;
    }
}