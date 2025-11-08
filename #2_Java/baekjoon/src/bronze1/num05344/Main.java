package bronze1.num05344;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문제 세트의 수를 변수 problemSet에 할당
		int problemSet = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 문제 세트를 순회
		while (problemSet-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 정수를 각 변수에 할당
			int numberA = Integer.parseInt(st.nextToken());
			int numberB = Integer.parseInt(st.nextToken());
			
			// gcdCalculator() 및 write() 메서드를 사용해 두 정수의 최대공약수를 출력
			out.write(gcdCalculator(numberA, numberB) + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int numberA, int numberB) {
		
		// 한 숫자가 다른 숫자로 나누어 떨어지는 경우 나눈 숫자가 최대공약수이므로 이를 반환
		if (numberA % numberB == 0)
			return numberB;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}