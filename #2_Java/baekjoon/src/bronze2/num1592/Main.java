package bronze2.num1592;

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
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사람 수, 종료 조건, 규칙을 각각의 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int term = Integer.parseInt(st.nextToken());		
		
		// 각 사람이 공을 받은 횟수를 저장할 배열 count 초기화
		int[] count = new int[size + 1];
		
		// 공을 던진 횟수를 저장할 변수 total 초기화
		int total = 0;
		
		// 공을 던진 사람을 저장할 변수 idx 초기화
		int idx = 1;
		
		// while 반복문을 사용해 종료 조건에 도달할 때까지 순회
		while (true) {
			
			// 공을 받은 사람의 던진 횟수를 갱신
			count[idx]++;
			
			// 종료 조건에 도달한 경우 반복문 탈출
			if (count[idx] == end)
				break;
			
			// 홀수인지 짝수인지 검사하여 공을 받는 위치 조정
			idx = (count[idx] % 2 != 0) ? idx + term : idx - term;
			
			// 인덱스가 배열의 범위를 벗어난 경우 조절
			idx = (idx > size) ? idx - size : idx;
			idx = (idx < 1) ? idx + size : idx;

			// 공을 던진 횟수 갱신
			total++;
		}

		// valueOf() 및 write() 메서드를 사용해 공을 던진 횟수 출력
		out.write(String.valueOf(total));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}