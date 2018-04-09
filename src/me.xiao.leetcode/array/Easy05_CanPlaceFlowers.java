package me.xiao.leetcode.array;

/**
 * 给定的位置 能不能种花。给定一组花，看最多能种多少株花。必须要间隔种，不然会死掉
 *
 * 隔着1，把里面所有的零计数，然后间隔里面可以中的花 把花数出来
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 17:42
 */

public class Easy05_CanPlaceFlowers {
    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1};
        System.out.println(new Easy05_CanPlaceFlowers().canPlaceFlowers(nums, 1));
    }

    private boolean canPlaceFlowers(int[] nums, int n) {
        int[] T = new int[nums.length + 4];
        for (int i = 0, j = 2; i < nums.length; i++) {
            T[j++] = nums[i];
        }

        T[0] = 1;
        T[T.length - 1] = 1;

        int total = 0, count = 0;
        for (int i = 1; i < T.length; i++) {
            if (T[i] == 0) {
                count++;
            } else {
                if ((count % 2) == 0) {
                    total += ((count / 2) - 1);
                } else {
                    total += count / 2;
                }

                count = 0;
            }
        }

        return total >= n;
    }
}
