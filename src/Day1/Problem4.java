package Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//4. Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//        Notice that the solution set must not contain duplicate triplets.
//        Example:
//        Input: nums = [-1,0,1,2,-1,-4]
//        Output: [[-1,-1,2],[-1,0,1]]
public class Problem4 {
    static ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    static void addList(int a, int b, int c) {
        boolean toAdd = true;
        for(int i = 0; i < ans.size(); i++) {
            if(ans.get(i).get(0) == a || ans.get(i).get(1) == a || ans.get(i).get(2) == a) {
                if(ans.get(i).get(0) == b || ans.get(i).get(1) == b || ans.get(i).get(2) == b) {
                    if(ans.get(i).get(0) == c || ans.get(i).get(1) == c || ans.get(i).get(2) == c) {
                        toAdd = false;
                    }
                }
            }
        }
        if(toAdd) ans.add(new ArrayList<>(List.of(a,b,c)));
    }
    static void findTriplets(int arr[], int n)
    {
        boolean found = false;
        Arrays.sort(arr);
        for (int i=0; i<n-1; i++)
        {
            int l = i + 1;
            int r = n - 1;
            int x = arr[i];
            while (l < r)
            {
                if (x + arr[l] + arr[r] == 0)
                {
                    addList(x, arr[l], arr[r]);
                    l++;
                    r--;
                    found = true;
                } else if (x + arr[l] + arr[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        if (!found) System.out.println("No such triplets exist");
    }
    public static void main (String[] args) {
        int arr[] = {-1,0,1,2,-1,-4};
        int n =arr.length;
        findTriplets(arr, n);
        System.out.println(ans);
    }
}
