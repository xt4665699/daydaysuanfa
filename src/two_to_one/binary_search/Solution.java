package two_to_one.binary_search;

public class Solution {

    public int search(int[] data, int target){
        int l = 0, r = data.length;
        while (l < r){
            int mid = l + (r - l) / 2;
            if (data[mid] == target)
                return mid;
            if (data[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return -1;
    }
}
