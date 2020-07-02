/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 *
 * @author Tao
 * @create 2020/6/29 11:17
 */
public class A_011_二进制中1的个数 {
    public int NumberOf1(int n) {
        //解法一：Java语法
        int count = 0;
        String BS = Integer.toBinaryString(n);
        for (int i = 0; i < BS.length(); i++) {
            if (BS.charAt(i) == '1') {
                count++;
            }
        }


        /*
            机器数:是带符号的，在计算机用一个数的最高位存放符号, 正数为0, 负数为1.
                比如，十进制中的数 +3 ，计算机字长为8位，转换成二进制就是00000011。如果是 -3 ，就是 10000011 。

            真值:因为第一位是符号位，所以机器数的形式值就不等于真正的数值。
                例如上面的有符号数 10000011，其最高位1代表负，其真正数值是 -3 而不是形式值131。


            原码：就是符号位加上真值的绝对值, 即用第一位表示符号, 其余位表示值.
                [+1]原 = 0000 0001
                [-1]原 = 1000 0001

            反码：正数的反码是其本身，负数的反码是在其原码的基础上, 符号位不变，其余各个位取反.
                [+1] = [00000001]原 = [00000001]反
                [-1] = [10000001]原 = [11111110]反

            补码：正数的补码就是其本身，负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1. (即在反码的基础上+1)
                [+1] = [00000001]原 = [00000001]反 = [00000001]补
                [-1] = [10000001]原 = [11111110]反 = [11111111]补

         */

        //解法二：二进制移位法
        /*
        10101
      & 00001
      = 00001

        01010
        00001



        11111111111111111111111111101001
        00000000000000000000000000000001
        01111111111111111111111111111110

        00000000000000000000000000000001
        00000000000000000000000000000001


         */

        count = 0;
        int mark = 1;
        while (mark != 0) {
            System.out.println("count="+count+"    Bmark="+Integer.toBinaryString(mark)+"    mark="+mark);
            if ((mark & n) != 0) ++count;
            mark <<= 1;
        }
        return count;




    }

    public static void main(String[] args) {
        System.out.println(new A_011_二进制中1的个数().NumberOf1(10));
        //System.out.println(Integer.toBinaryString(10));

        /*
        System.out.println(Integer.toBinaryString(23));
        System.out.println(Integer.toBinaryString(-2147483648));
        System.out.println(-2147483648<<1);
        System.out.println(0x01);

        System.out.println(1<<1);

        System.out.println(Integer.toBinaryString(-23>>1));
        System.out.println(-23>>1);

        System.out.println(Integer.toBinaryString(-12>>1));
        System.out.println(-12>>1);

        System.out.println(Integer.toBinaryString(0x01));
        System.out.println(-23<<31);

        */
    }
}
