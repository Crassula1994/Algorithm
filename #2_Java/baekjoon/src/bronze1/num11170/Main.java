package bronze1.num11170;

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
		
		// for 반복문을 사용해 각 숫자까지의 0의 개수를 저장할 배열 counter 초기화
		int[] counter = new int[1000001];
		
		// 0일 경우 0의 개수를 갱신
		counter[0] = 1;
		
		// for 반복문을 사용해 각 숫자를 순회
		for (int idx = 1; idx < counter.length; idx++) {
			
			// 해당 숫자를 변수 number에 할당
			int number = idx;
			
			// 해당 숫자의 0의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// while 반복문을 사용해 해당 숫자가 10 미만이 될 때까지 순회
			while (number > 9) {
				
				// 해당 숫자에 0이 존재하는 경우 0의 개수를 갱신
				if (number % 10 == 0)
					count++;
				
				// 해당 숫자의 다음 자리 수를 확인하기 위해 숫자 갱신
				number /= 10;
			}
			
			// 해당 자리까지의 0의 개수를 갱신
			counter[idx] = counter[idx - 1] + count;
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 숫자를 각 변수에 할당
			int startNum = Integer.parseInt(st.nextToken());
			int endNum = Integer.parseInt(st.nextToken());
			
			// 시작 숫자가 0인 경우 끝 숫자까지의 0의 개수를 출력
			if (startNum == 0) {
				out.write(counter[endNum] + "\n");
			
			// 시작 숫자가 0이 아닌 경우 처음 숫자부터 끝 숫자까지의 0의 개수를 출력
			} else {
				out.write(counter[endNum] - counter[startNum - 1] + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}