package bronze1.num01145;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 나누어 떨어지는지 검사할 수를 저장할 배열 divisors 초기화
		int[] divisors = new int[5];
		
		// StrintTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 수를 배열 divisors에 저장
		for (int idx = 0; idx < 5; idx++)
			divisors[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 divisor를 오름차순으로 정렬
		Arrays.sort(divisors);
		
		// 적어도 대부분의 배수를 저장할 변수 multiple 초기화
		int multiple = divisors[0];
		
		// while 반복문을 사용해 적어도 대부분의 배수를 찾을 때까지 순회
		while (true) {
			
			// 나누어 떨어지는 숫자의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 배열 divisor의 각 원소를 순회
			for (int idx = 0; idx < 5; idx++) {
				
				// 나누어 떨어지는 경우 나누어 떨어지는 숫자의 개수를 갱신
				if (multiple % divisors[idx] == 0)
					count++;
			}
			
			// 나누어 떨어지는 숫자의 개수가 3개 이상인 경우 반복문 탈출
			if (count >= 3)
				break;
			
			// 검사할 숫자를 갱신
			multiple++;
		}

		// valueOf() 및 write() 메서드를 사용해 적어도 대부분의 배수를 출력
		out.write(String.valueOf(multiple));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}