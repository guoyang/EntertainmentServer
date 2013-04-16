/**
 * 
 */
package util;

/**
 * @author Administrator
 *
 */
public class TextContent {

	public static String MAIN_MENU = "主菜单：\n1、blabla\n2、blablabla";
	public static String RETURN_MAIN = "返回main输入x";
	public static String SELECT_CONTENT = "aaa$0bbb$1ccc$2";
	
	
	public static String fillParam(String content, String... strings) {
		String ret = content;
		for(int i=0;i<Integer.MAX_VALUE;i++) {
			String mark = "$" + i;
			if(content.indexOf(mark) == -1) {
				return ret;
			} else {
				ret = ret.replace(mark, strings[i]);
			}
			
		}
		return ret;
		
	}
	
	public static void main(String[] args) {
		System.out.println(fillParam(SELECT_CONTENT, "hhhh","iiii","nnnn"));;
	}
}
