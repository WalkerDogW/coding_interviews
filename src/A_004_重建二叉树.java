import comm.TreeNode;

import java.util.Arrays;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 *
 * @author Tao
 * @create 2020/6/19 17:22
 */
public class A_004_重建二叉树 {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        /*


                            8
                       2        7
                   【】  3    1   【】


                 前序：8   2   3  7    1
                 中序：2   3   8  1    7


            前序遍历序列的第一个元素 8 就是二叉树的根节点，
            中序遍历序列的根节点 8 把这个序列分成两半部分，
            分别是[2,3]和[1,7]，左半分部是根节点的左子树，右半分布是根节点的右子树。

            基于这个特点，可以采用递归的方法来做
         */

        //递归调用的终止条件
        if(pre == null || in == null || pre.length==0 || in.length == 0) {
            return null;
        }

        //由前序遍历得到该二叉树的根结点
        TreeNode root = new TreeNode(pre[0]);
        //对于中序遍历，根节点左边的节点位于二叉树的左边，根节点右边的节点位于二叉树的右边
        //在中序遍历中找根结点位置，进行左右子树的划分
        for(int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]) {
                //将左子树看成一棵二叉树调用该方法，可以得到左子树根结点，即上面根结点的左子结点
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                //将右子树看成一棵二叉树调用该方法，可以得到右子树根结点，即上面根结点的右子结点
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
                break;
            }
        }



        //return root;


        //写法二：
        root=rebuildTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }


    public static TreeNode rebuildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(pre[preStart]);
        for(int i=inStart;i<=inEnd;i++)
            if(in[i]==pre[preStart]){
                root.left=rebuildTree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right=rebuildTree(pre,i-inStart+preStart+1,preEnd,in,i+1,inEnd);
                break;
            }

        return root;
    }
}
