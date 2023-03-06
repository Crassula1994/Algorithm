package bronze3.num10250;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 저장
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int i = 0; i < testCase; i++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 층 수를 변수 height에 저장
			int height = Integer.parseInt(st.nextToken());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 방 수를 변수 width에 저장
			@SuppressWarnings("unused")
			int width = Integer.parseInt(st.nextToken());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 손님의 번호를 변수 customerNum에 저장
			int customerNum = Integer.parseInt(st.nextToken());
			
			// 배정되어야 할 방 번호를 계산
			int room = customerNum / height + 1;
			
			// 배정되어야 할 층 수를 계산
			int floor = customerNum % height;
			
			// 꼭대기 층인 경우 층 수 및 방 번호 조정
			if (floor == 0) {
				floor = height;
				room -= 1;
			}
				
			// write() 메서드를 사용해 최종 방 번호를 출력
			out.write((floor * 100 + room) + "\n");			
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}