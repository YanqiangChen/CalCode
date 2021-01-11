package com.example.myapplication.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tools {
    /*
     * I V X   L   C     D      M
     * 1 5 10  50  100   500   1000
     *罗马数字转成数字
     *思路：先遍历罗马数字每个字符，转换称数字
     * 需要注意的是：如果后边的字母表示的数字大于前面的，说明是后边的数字-前面的数字
     * 比如IV=4 IX=9
     * */
    public int changeRomeToNum(String rome){
        HashMap<Character,Integer> map = getMap();
        int total=0;
        for(int i=0;i<rome.length();i++){
            char cur=rome.charAt(i);
            char next;
            int calNum=0;
            int nextNum=0;
            int curNum=map.get(cur);
            if(i<rome.length()-1){
                next=rome.charAt(i+1);
                nextNum=map.get(next);
                if(nextNum>curNum){
                    i++;
                    calNum=nextNum-curNum;
                }else{
                    calNum=curNum;
                }
                total+=calNum;
            }else{
                total+=curNum;
            }

        }
        return total;

    }
    public HashMap<Character,Integer> getMap(){
        HashMap<Character,Integer> map=new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        return map;

    }


    /*
     * 最长公共前缀
     * flower flow flight fl
     * dog racecar car ""
     * 思路：
     * 1.从0-min(firstStr.length,secondStr.length,thirdStr.length)遍历字符串
     * 2.firstStr.char[i]  secondStr.char[i]  thirdStr.char[i]
     * */
    public String getPublicPrefix(String firstStr,String secondStr,String thirdStr){
        StringBuffer publicSb = new StringBuffer();
        int min = min(firstStr.length(),secondStr.length(),thirdStr.length());
        for(int i=0;i<min;i++){
            if(firstStr.charAt(i) == secondStr.charAt(i)
                    && secondStr.charAt(i) == thirdStr.charAt(i)){
                publicSb.append(firstStr.charAt(i));
            }else{
                break;
            }

        }
        return publicSb.toString();

    }

    public int min(int... sizes){
        if(sizes.length==0){
            return -1;
        }
        int min=sizes[0];
        for(int size:sizes){
            if(min>size){
                min=size;
            }
        }
        return min;
    }


    /*
     * 三数之和
     * 最简单的方式：O(N三次方)遍历，得到N三次方个组合，去重复
     * 比较好的方式：先进行排序，然后N的三次方进行遍历 时间复杂度O(N的三次方)
     * 最好的方式：排序，遍历first second 然后从后往前遍历third
     *
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    /*
     * 最接近的三数只和
     * 输入 nums=[-1,2,1,-4],target=1 输出 2
     *
     * */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    /*
     * 给定一个2-9的字符串，返回它能表示的所有字母组合
     * 23 ["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 回溯
     * */
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    /*
    * 时间复杂度 输入m个对应3个字母的数字 n个对应4个字母的数字  时间复杂度 3的m次方 x 4的n次方
    * */
    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);  //获取输入的数字
            String letters = phoneMap.get(digit);   //根据输入的数字获取字母
            int lettersCount = letters.length();   //获取字母的数量
            for (int i = 0; i < lettersCount; i++) {   //遍历字母
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
    /*
    * 判断是否是回文数
    * 反转
    *12321
    * 1221
    * */
    public int isPalindrome(int x){
        int reversal=0;
        while(reversal<x){
            if(x/10>reversal){
                reversal=reversal*10+x%10;
            }
            x=x/10;
        }
        return reversal;

    }
    /*
    * 四数之和
    * 给定一个包含n个整数的数组nums和一个目标值target,判断nums中数否存在四个元素a,b,c,d使得a+b+c+d=target
    * nums=[1,0,-1,0,-2,2]和target = 0;
    * 满足条件的四元组集合为：
    * [
    *   [-1,0,0,1],
    *   [-2,-1,1,2],
    *   [-2,0,0,2]
    * ]
    * */




}
