package com.example.myapplication.calculate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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



}
