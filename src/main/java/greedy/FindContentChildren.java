package greedy;

import java.util.Arrays;

/**
 * @author :wangq
 * @date : 2023/7/3 9:13
 * 分发饼干 https://leetcode.cn/problems/assign-cookies/
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * <p>
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 */
public class FindContentChildren {
    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{3};
        System.out.println(findContentChildren(g, s));
    }

    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int glen = g.length;
        int slen = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j = 0; i < glen && j < slen; i++, j++){
            while (j < slen && s[j] < g[i]){
                j++;
            }
            if(j < slen && s[j] >= g[i]){
                count++;
            }
        }
        return count;
    }
}
