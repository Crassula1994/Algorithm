package bronze1.num04641;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 모든 테스트 케이스를 순회
		while (true) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// -1이 입력된 경우 반복문 탈출
			if (st.countTokens() == 1)
				break;
			
			// 자신의 정확히 2배인 수가 있는 수의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// 입력 받은 각 숫자를 저장할 List 객체 numbers 초기화
			List<Integer> numbers = new ArrayList<>();
			
			// while 반복문을 사용해 각 숫자를 순회
			while (true) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
				int number = Integer.parseInt(st.nextToken());
				
				// 해당 숫자가 0인 경우 반복문 탈출
				if (number == 0)
					break;
				
				// add() 메서드를 사용해 입력 받은 숫자를 numbers에 저장
				numbers.add(number);
			}
			
			// sort() 메서드를 사용해 입력 받은 숫자를 오름차순으로 정렬
			Collections.sort(numbers);
			
			// for 반복문을 사용해 각 가능한 숫자 조합을 순회
			for (int i = 0; i < numbers.size() - 1; i++) {
				for (int j = i + 1; j < numbers.size(); j++) {
				
					// 해당 조합이 정확히 2배가 되는 조합인 경우 그 개수를 갱신
					if (numbers.get(i) * 2 == numbers.get(j))
						count++;
				}
			}
			
			// write() 메서드를 사용해 자신의 정확히 2배인 수가 있는 수의 개수를 출력
			out.write(count + "\n");
		}
				
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}