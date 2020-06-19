/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @author Tao
 * @create 2020/6/18 11:10
 */
public class A_001_二维数组中的查找 {
    public static  boolean Find(int target, int [][] array) {
        //空
        if(array == null || array.length==0 || array[0] == null || array[0].length==0){
            return false;
        }

        //左下角
        int row = array.length-1;
        int column = 0;
        System.out.println(array.length+" "+array[0].length);

        while(target != array[row][column]){
            System.out.println(array[row][column]+"  "+row+"  "+column);
            if(target > array[row][column]){
                column++;
            }else if(target < array[row][column]){
                row--;
            }else {
                return true;
            }

            if(row < 0 || (column>array[0].length-1)){
                return false;
            }
        }
        return true;
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
