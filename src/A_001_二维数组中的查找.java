/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author Tao
 * @create 2020/6/18 11:10
 */
public class A_001_二维数组中的查找 {
    public static  boolean Find(int target, int [][] array) {
        if(array==null) {
            return false;
        }

        //左下角
        int row=array.length-1;
        int col=0;
        while(row >=0 && col< array[0].length) {
            if(target == array[row][col]) {
                return true;
            }else if(target < array[row][col]) {
                row = row-1;
            }else {
                col = col+1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] intArr = {
                {1 ,2 ,3 ,4 ,5 },
                {6 ,7 ,8 ,9 ,10},
                {11,12,13,14,15},
                {16,17,18,19,20}};
        int tar = 5;
        System.out.println(Find(tar,intArr));
    }


}
