package bronze3.num03460;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 양의 정수를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 현재 확인 중인 위치를 저장할 변수 location 초기화
			int location = -1;
			
			// while 반복문을 사용해 양의 정수가 0이 될 때까지 순회
			while (number > 0) {
				
				// 현재 확인 중인 위치를 갱신
				location++;
				
				// 현재 확인 중인 위치가 1인 경우 현재 위치를 출력
				if (number % 2 == 1)
					out.write(location + " ");
				
				// 양의 정수를 2로 나누어 갱신
				number /= 2;
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}