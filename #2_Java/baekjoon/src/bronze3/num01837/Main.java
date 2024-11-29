package bronze3.num01837;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 메서드를 사용해 입력 받은 암호와 좋은 암호의 기준을 각 변수에 할당
		BigInteger password = new BigInteger(st.nextToken());
		BigInteger lowerLimit = new BigInteger(st.nextToken());
		
		// 해당 암호가 좋은 암호인지 여부를 저장할 변수 isGood 초기화
		boolean isGood = true;
		
		// for 반복문을 사용해 가능한 소수를 순회
		for (int factor = 2; factor < lowerLimit.intValue(); factor++) {
			
			// 해당 암호가 해당 소수로 나눠지는 경우
			if (password.remainder(BigInteger.valueOf(factor)).compareTo(BigInteger.ZERO) == 0) {
				
				// write() 메서드를 사용해 'BAD'와 소수를 출력
				out.write("BAD " + factor);
				
				// 해당 암호가 좋은 암호인지 여부를 갱신 후 반복문 탈출
				isGood = false;
				break;
			}
		}
		
		// 해당 암호가 좋은 암호인 경우 'GOOD'을 출력
		if (isGood)
			out.write("GOOD");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}