import java.util.*;

public class HardQuestions {

    public static void main(String[] args) {
        System.out.println(trap(new int[] {4,2,0,3,2,5}));
    }

    // PX
    public static String test(String s) {
        
        return "";
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