package hw8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

public class hw8_1 {
	/* 請建立一個Collection物件並將以下資料加入：
	Integer(100)、Double(3.14)、Long(21L)、Short(“100”)、Double(5.1)、“Kitty”、Integer(100)、
	Object物件、“Snoopy”、BigInteger(“1000”)
	
	印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)
	• 移除不是java.lang.Number相關的物件
	• 再次印出這個集合物件的所有元素，觀察是否已將非Number相關的物件移除成功 */
	
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(3.14);
		list.add(21L);
		list.add((short)100);
		list.add(3.14);
		list.add("Kitty");
		list.add(100);
		list.add(new Object());
		list.add("snoopy");
		list.add(new BigInteger("1000")); // 這啥呀
		
		// iterator ver.
//		Iterator it = list.iterator();
//		while(it.hasNext()) {
//			Object temp = it.next();
//			System.out.println(temp);
//			if(!(temp instanceof Number)) it.remove();
//		}
//		System.out.println(list);
		
		// for ver.
//		for(int i = list.size() - 1 ; i >= 0 ; i--) {
//			Object temp = list.get(i);
//			System.out.println(temp);
//			if(!(temp instanceof Number)) list.remove(i);
//		}
//		System.out.println(list);
		
		// for-each ver.
//		ArrayList toRemove = new ArrayList();
//		for(Object el : list) {
//			System.out.println(el);
//			if(!(el instanceof Number)) toRemove.add(el);
//		}
//		list.removeAll(toRemove);
//		System.out.println(list);
		
		// +碼：forEach ver.
//		ArrayList toRemove = new ArrayList();
//		list.forEach((el) -> {
//			System.out.println(el);
//			if(!(el instanceof Number)) toRemove.add(el);
//		});
//		list.removeAll(toRemove);
//		System.out.println(list);
	}
}
