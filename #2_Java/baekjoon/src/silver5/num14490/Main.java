package silver5.num14490;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine(), ":");
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 두 숫자를 각 변수에 할당
		int numberA = Integer.parseInt(st.nextToken());
		int numberB = Integer.parseInt(st.nextToken());
		
		// max(), min(), gcdCalculator() 메서드를 사용해 두 숫자의 최대공약수를 변수 gcd에 할당
		int gcd = gcdCalculator(Math.max(numberA, numberB), Math.min(numberA, numberB));
		
		// write() 메서드를 사용해  두 수를 최대한으로 약분한 결과를 출력
		out.write((numberA / gcd) + ":" + (numberB / gcd));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// gcdCalculator() 메서드 정의
	public static int gcdCalculator(int numberA, int numberB) {
		
		// 나머지가 0인 경우 최대공약수를 반환
		if (numberB == 0)
			return numberA;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}