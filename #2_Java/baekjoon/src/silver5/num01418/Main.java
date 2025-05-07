package silver5.num01418;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수의 상한과 K-세준수의 기준이 되는 값을 각 변수에 할당
		int numberLimit = Integer.parseInt(in.readLine());
		int factorLimit = Integer.parseInt(in.readLine());
		
		// K-세준수의 개수를 저장할 변수 count 초기화
		int count = 1;
		
		// 각 숫자의 최대 소인수를 저장할 배열 maxFactors 초기화
		int[] maxFactors = new int[numberLimit + 1];
		
		// for 반복문을 사용해 각 인수를 순회
		for (int factor = 2; factor <= numberLimit; factor++) {
			
			// 해당 인수가 소인수인 경우
			if (maxFactors[factor] == 0) {

				// for 반복문을 사용해 해당 소인수의 배수에 대하여 최대 소인수를 갱신
				for (int multiplier = factor; multiplier <= numberLimit; multiplier += factor)
					maxFactors[multiplier] = factor;
			}
			
			// 해당 숫자가 K-세준수인 경우 K-세준수의 개수를 갱신
			if (maxFactors[factor] <= factorLimit)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 K-세준수의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}