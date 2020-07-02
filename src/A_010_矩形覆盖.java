/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author Tao
 * @create 2020/6/29 11:08
 */
public class A_010_矩形覆盖 {
    public int RectCover(int target) {
        //类似斐波那契
        if (target == 0 || target == 1 || target == 2) {
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }
}
