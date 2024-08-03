package src.main.java.classical;

import java.util.Arrays;

public class StringIndex {

    public static void main(String[] args) {
//        String str = "ABCDEFGHJHG";
//        String tar = "CDEF";
        String str = "ABCABCAABCABCD";
        String tar = "ABCABCD";
//        System.out.println(indexOf(str,tar));
        char[] s = str.toCharArray();
        char[] t = tar.toCharArray();
        int[] next= new int[tar.length()];
        getNext(t,next);
        System.out.println(Arrays.toString(next));
        System.out.println(kpm(s,t,next));

    }
    //求目标字符串是否在，存在返回下标，不存在返回-1
    static int indexOf(String str, String tar){
        if(str.length()<tar.length()){//给定字符串没有目标字符串长，那么目标一定不在给定串内
            return -1;
        }
        for (int i = 0; i <= str.length()-tar.length(); i++) {//只需要比到最后长度一致的地方，不需要比完
            for (int j = 0; j < tar.length(); j++) {
                char s = tar.charAt(j) ;
                char t = str.charAt(i+j);
                if(s != t){
                    break;
                }
                if (j==tar.length()-1){
                    return i;
                }
            }

        }
        return -1;
    }

    static int kpm(char[] str, char[]tar, int[] next){

        int i = 0;
        int j = 0;
        while (i<str.length && j<tar.length){
            if(j == -1 || str[i] == tar[j]){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if(j == tar.length){
            return i-j;
        }else {
            return -1;
        }

    }

    static void getNext(char[] tar, int[] next){
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < tar.length){
            if (j == -1){//需要后移继续匹配
                i++;
                j++;
            }else if (tar[i]==tar[j]){//前缀与后缀产生交际
                i++;
                j++;
                next[i] = j;//记录当前交集的数量

            }else {//再次不相等的时候 就是最长交集的长度
                j = next[j];
            }

        }

    }


}
