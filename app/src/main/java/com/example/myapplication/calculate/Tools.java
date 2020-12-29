package com.example.myapplication.calculate;

import java.util.HashMap;

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
}
