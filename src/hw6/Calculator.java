package hw6;

import java.lang.Math;

public final class Calculator {
	public final static int powerXY(int x, int y) throws CalException{
		if(x == 0 && y == 0) throw new CalException("0的0次方沒有意義");
		if(y < 0) throw new CalException("次方為負值，結果回傳不為整數");
		return (int)Math.pow(x, y);
	}
}
