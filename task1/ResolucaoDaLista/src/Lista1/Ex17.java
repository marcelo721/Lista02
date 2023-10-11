package Lista1;

public class Ex17 {

	public static void main(String[] args) {
		
		int A = 0;
		int B = 0;
		
		if ( A > 10 || A + B == 20) {
			
			System.out.println("NUMERO VALIDO");
			
		} else if( A == B ) {
			
			System.out.println("A EH IGUAL A B ");
			
		} else if (A != 10 && B != 10 && A < 10 ) {
			
			System.out.println("A < 10");
			
		} else {
			
			System.out.println("numero nao valido");
		}
	}

}
