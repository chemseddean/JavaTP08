import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
	
	public static int myMax(int... numbers) {
		if (numbers.length == 0) {
			throw new IllegalArgumentException("");
		}
		int max = numbers[0];
		for (int number : numbers) {
			if (number > max) {
				max = number;
			}
		}
		return max;
	}
	
	public static <T extends Comparable<T>> T myMax2(T... objects) {
		if (objects.length == 0) {
			throw new IllegalArgumentException("");
		}
		T max = objects[0];
		for (T object : objects) {
			if (object.compareTo(max) > 0) {
				max = object;
			}
		}
		return max;
	}
	
	public static <T> void print(List<T> list) {
		for (T o:list)
			System.out.println(o);
	}
	
	public static <T extends CharSequence> void printSize(List<T> list) {
		for (T o:list)
			System.out.println(o + " : " + o.length());
	}
	
	public static <T extends CharSequence> List<Integer> listLength(List<T> list) {
		ArrayList<Integer> length = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			CharSequence seq = (CharSequence) list.get(i);
			length.add(seq.length());
		}
		return length;
	}
	
	public static List<Integer> listLength2(List<? extends CharSequence> list) {
		ArrayList<Integer> length = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			CharSequence seq = (CharSequence) list.get(i);
			length.add(seq.length());
		}
		return length;
	}

	public static List<?> fusion(List<?> l1, List<?> l2) {
		List fusion = new ArrayList();
		int sizeL1 = l1.size();
		int sizeL2 = l2.size();
		int min  = Math.min(sizeL1, sizeL2);
		int max  = Math.min(sizeL1, sizeL2);
		for (int i = 0; i < min; i++) {
			fusion.add(l1.get(i));
			fusion.add(l2.get(i));
		}
		
		for (int i = min + 1; i < max; i++) {
			if (sizeL1 > sizeL2) {
				fusion.add(l1.get(i));
			} else {
				fusion.add(l2.get(i));
			}
		}
		
		return fusion;
	}
	
	public static <T> void mix(List<T> l1, int a, int b) {
		T n = l1.get(a);
		l1.set(b, l1.get(b));
		l1.set(a, l1.get(b));
		l1.set(b, n); 
	}
	
}
