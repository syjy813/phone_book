
public class test {
	public static void main(String[] args) {
	
	
//	int b = Integer.parseInt(a);
//	System.out.println(b);
	String a = "a1s2d3f4";
	int [] b = new int [8];
	char [] c = new char [8];
	for (int i = 0; i < c.length; i++) {
		c[i] = a.charAt(i);
		b[i] = c[i];
		System.out.println(c[i]);
		System.out.println(b[i]);
		if(b[i] <58) {
			System.out.println("오류없음");
		}else {
			System.out.println("오류");
		}
	}
	
	
	}
}
