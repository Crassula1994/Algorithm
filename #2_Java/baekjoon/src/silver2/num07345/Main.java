package silver2.num07345;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// polynomialMaker() 메서드를 호출해 입력 받은 다항식의 정보를 각 배열에 저장
			int[] polynomialF = polynomialMaker(in.readLine());
			int[] polynomialG = polynomialMaker(in.readLine());
			int[] polynomialH = polynomialMaker(in.readLine());
			
			// 다항식을 계산한 결과를 저장할 배열 result 초기화
			int[] result = new int[polynomialF.length + polynomialG.length - 1];
			
			// for 반복문을 사용해 다항식 f(x)의 각 항을 순회
			for (int idxF = 0; idxF < polynomialF.length; idxF++) {
				
				// 해당 항의 값이 0인 경우 다음 항을 순회
				if (polynomialF[idxF] == 0)
					continue;
				
				// for 반복문을 사용해 다항식 g(x)의 각 항을 순회
				for (int idxG = 0; idxG < polynomialG.length; idxG++) {
					
					// 해당 항의 값이 0인 경우 다음 항을 순회
					if (polynomialG[idxG] == 0)
						continue;
					
					// 두 다항식의 곱셈의 결과를 갱신
					result[idxF + idxG]++;
				}
			}
			
			// for 반복문을 사용해 두 다항식의 곱셈의 결과를 갱신
			for (int idx = 0; idx < result.length; idx++)
				result[idx] %= 2;
			
			// for 반복문을 사용해 곱셈 결과의 각 항을 순회
			for (int idx = 0; idx < result.length; idx++) {
				
				// 해당 항의 값이 0인 경우 다음 항을 순회
				if (result[idx] == 0)
					continue;
				
				// for 반복문을 사용해 나머지 연산의 결과를 갱신
				for (int idxH = 0; idxH < polynomialH.length; idxH++)
					result[idx + idxH] -= result[idx] * polynomialH[idxH];
			}
			
			// 다항식 연산 결과의 최고 차항을 찾았는지 여부를 저장할 변수 has
			
			// for 반복문을 사용해 각 
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// polynomialMaker() 메서드 정의
	public static int[] polynomialMaker(String polynomialString) {
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(polynomialString);
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 다항식의 길이를 변수 length에 할당
		int length = Integer.parseInt(st.nextToken());
		
		// 다항식의 항의 계수를 저장할 배열 polynomial 초기화
		int[] polynomial = new int[length];
		
		// for 반복문을 사용해 입력 받은 다항식의 계수를 배열 polynomial에 저장
		for (int idx = 0; idx < polynomial.length; idx++)
			polynomial[idx] = Integer.parseInt(st.nextToken());
		
		// 다항식의 항의 계수를 저장한 배열 반환
		return polynomial;
	}
}