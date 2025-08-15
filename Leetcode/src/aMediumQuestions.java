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

    //P128
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int max = 1;
        int current = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == current+count) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
                current = nums[i];
            }
        }
        return max;
    }
}
