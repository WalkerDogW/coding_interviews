/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author Tao
 * @create 2020/6/29 10:40
 */
public class A_009_变态跳台阶 {
    public int JumpFloorII(int target) {

        if (target == 0 || target == 1 || target == 2) {
            return target;
        }

        int result=0;

        //解法一：遍历
        /*
        设f[i] 表示 当前跳道第 i 个台阶的方法数。那么f[n]就是所求答案。
        假设现在已经跳到了第 n 个台阶，那么前一步可以从哪些台阶到达呢？
        如果上一步跳 1 步到达第 n 个台阶，说明上一步在第 n-1 个台阶。已知跳到第n-1个台阶的方法数为f[n-1]
        如果上一步跳 2 步到达第 n 个台阶，说明上一步在第 n-2 个台阶。已知跳到第n-2个台阶的方法数为f[n-2]
        如果上一步跳 n 步到达第 n 个台阶，说明上一步在第 0 个台阶。已知跳到 第0个台阶的方法数为f[0]

        那么总的方法数就是所有可能的和。也就是f[n] = f[n-1] + f[n-2] + ... + f[0]
        显然初始条件f[0] = f[1] = 1
        所以我们就可以先求f[2]，然后f[3]...f[n-1]， 最后f[n]
         */
        int[] jump = new int[target + 1];
        jump[0] = 1;
        jump[1] = 1;
        jump[2] = 2;
        for (int i = 3; i <= target; i++) {
            for(int j=0; j<i; j++){
                jump[i] = jump[i]+jump[j];
            }
        }

        result = jump[target];



        //解法二：数学公式
        /*
        因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
        跳1级，剩下n-1级，则剩下跳法是f(n-1)
        跳2级，剩下n-2级，则剩下跳法是f(n-2)
        所以f(n)=f(n-1)+f(n-2)+...+f(1)
        因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
        所以f(n)=2*f(n-1)
         */
        result = 2*JumpFloorII(target-1);
        return result;
    }
}
