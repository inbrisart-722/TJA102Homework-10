package hw7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class hw7_4 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Dog dog1 = new Dog("Brian dog");
		Dog dog2 = new Dog("Brian dog2");
		Cat cat1 = new Cat("Brian cat");
		Cat cat2 = new Cat("Brian cat2");

		File folder = new File("/Users/inbrisart/desktop/TJA102_Workspace/testFile/obj");
		if (!folder.exists()) {
			folder.mkdirs();
		}
		File f = new File(folder, "obj.ser");
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		ObjectOutputStream oos = new ObjectOutputStream(bos);

		oos.writeObject(dog1);
		oos.writeObject(dog2);
		oos.writeObject(cat1);
		oos.writeObject(cat2);

		oos.close();
		bos.close();
		fos.close();

		// 以下為輸入測試

		FileInputStream fis = new FileInputStream(f);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ObjectInputStream ois = new ObjectInputStream(bis);

		System.out.println(f.getName() + "檔案內容如下：");
		try {
			while (true) {
				((Speak) ois.readObject()).speak();
//				if (temp instanceof Dog) ((Dog) temp).speak();
//				if (temp instanceof Cat) ((Cat) temp).speak();
			}
		} catch (EOFException e) {
			System.out.println("Finished");
		}

		ois.close();
		fis.close();
	}
}
