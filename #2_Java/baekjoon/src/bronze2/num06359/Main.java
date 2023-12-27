package bronze2.num06359;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 방의 개수를 변수 roomNum에 할당
			int roomNum = Integer.parseInt(in.readLine());
			
			// 각 방의 상태를 저장할 배열 rooms 초기화
			boolean[] rooms = new boolean[roomNum + 1];
			
			// 도망칠 수 있는 학생의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 각 위스키 잔을 순회
			for (int whiskey = 1; whiskey <= roomNum; whiskey++) {
				
				// for 반복문을 사용해 각 방을 열고 닫기
				for (int number = whiskey; number <= roomNum; number += whiskey)
					rooms[number] = !rooms[number];
			}
			
			// for 반복문을 사용해 각 방의 상태를 순회
			for (int idx = 1; idx <= roomNum; idx++) {
				
				// 방이 열려 있는 경우 도망칠 수 있는 학생의 수를 갱신
				if (rooms[idx])
					count++;
			}
			
			// write() 메서드를 사용해 도망칠 수 있는 학생의 수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}