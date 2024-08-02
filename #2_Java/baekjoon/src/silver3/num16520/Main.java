package silver3.num16520;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 범위 및 진법의 범위를 각 변수에 할당
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int targetBase = Integer.parseInt(st.nextToken());
		
		// 주어진 모든 진법에서 회문인 숫자의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 진법의 범위가 4 이상인 경우
		if (targetBase >= 4) {
			
			// 0이 숫자의 범위에 포함되는 경우 모든 진법에서 회문인 숫자의 수를 갱신
			if (start <= 0 && 0 <= end)
				count++;
			
			// 1이 숫자의 범위에 포함되는 경우 모든 진법에서 회문인 숫자의 수를 갱신
			if (start <= 1 && 1 <= end)
				count++;
		
		// 진법의 범위가 4 미만인 경우
		} else {
			
			// for 반복문을 사용해 주어진 범위의 숫자를 차례로 순회
			outer: for (int number = start; number <= end; number++) {
				
				// for 반복문을 사용해 각 진법을 순회
				for (int base = 2; base <= targetBase; base++) {
					
					// 자릿수를 저장하고 남은 나머지를 저장할 변수 remains 초기화
					int remains = number;
					
					// 해당 진법에서 각 자릿수를 저장할 List 객체 digits 초기화
					List<Integer> digits = new ArrayList<>();
					
					// while 반복문을 사용해 각 자릿수를 digits에 저장
					while (remains > 0) {
						digits.add(remains % base);
						remains /= base;
					}
					
					// for 반복문을 사용해 대칭인 자릿수를 순회
					for (int idx = 0; idx < digits.size() / 2; idx++) {
						
						// 각 자릿수가 대칭이 아닌 경우 다음 숫자를 순회
						if (digits.get(idx) != digits.get(digits.size() - idx - 1))
							continue outer;
					}
				}
				
				// 해당 숫자가 모든 진법에서 회문인 경우 그 수를 갱신
				count++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 모든 진법에서 회문인 숫자의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}