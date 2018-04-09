package me.xiao.leetcode.array;

/**
 * 读取文件
 * <p>
 * 每次读四个字节的文件，把读取到的数据存储到buf里面
 *
 * @author pacman
 * @version 1.0
 * date: 2018/4/9 21:38
 */

public class Easy12_ReadNCharacters {

    public static void main(String[] args) {

    }

    public int read(char[] buf, int n) {
        int i = 0;
        int toRead = Math.min(n, buf.length);

        while (i < toRead) {
            char[] temp = new char[4];
            int r = read4(temp);
            for (int j = 0; j < r && i < toRead; j++) {
                buf[i] = temp[j];
                i++;
            }

            if (r < 4) {
                break;
            }
        }

        return Math.min(i, toRead);
    }

    private int read4(char[] buf) {
        return 1;
    }

}
