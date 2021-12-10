import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList("foo", "toto");
		List<Integer> list2 = Arrays.asList(1, 3, 5);

		
		List l = Arrays.asList("Hello", "world");
		
		List<String> l1 = Arrays.asList("l11", "l12");
		List<StringBuilder> l2 = Arrays.asList(new StringBuilder("Hello"), new StringBuilder(" World!"));
		
		List<? extends CharSequence> r1 = (List<? extends CharSequence>) Generics.fusion(l1, l2);
		System.out.println(r1);
		
		List<Integer> l3 = Arrays.asList(1, 2);
		System.out.println(Generics.fusion(l1, l3));
	}

}
