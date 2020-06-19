/**请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * @author Tao
 * @create 2020/6/18 15:00
 */
public class A_002_替换空格 {
    public static String replaceSpace(StringBuffer str) {

        //解法一：自带函数
        //return str.toString().replace(" ", "%20");

        //解法二：遍历字符，替换
        StringBuffer result = new StringBuffer();
        for(int i=0; i < str.length(); i++){
            char c = str.charAt(i);
            if(c != ' '){
                result.append(c);
            }else{
                result.append("%20");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "We Are Happy";
        System.out.println(replaceSpace(new StringBuffer(str)));
    }
}
