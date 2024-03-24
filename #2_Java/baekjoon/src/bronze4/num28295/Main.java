package bronze4.num28295;

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
		
		// 현재 학생들이 바라보는 방향을 나타내는 변수 direction 초기화
		int direction = 0;
		
		// for 반복문을 사용해 각 지시를 순회
		for (int c = 0; c < 10; c++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 지시를 변수 command에 할당
			int command = Integer.parseInt(in.readLine());
			
			// switch 조건문을 사용해 각 지시에 따른 방향을 설정
			switch (command) {
				case 1:
					direction++;
					break;
				case 2:
					direction += 2;
					break;
				default:
					direction--;
			}
			
			// 방향이 음수인 경우 양수로 변경
			if (direction == -1)
				direction = 3;
			
			// 방향이 3보다 큰 경우 방향을 조정
			if (direction > 3)
				direction %= 4;
		}
		
		// switch 조건문에 따라 학생들이 바라보는 방향을 출력
		switch (direction) {
			case 0:
				out.write("N");
				break;
			case 1:
				out.write("E");
				break;
			case 2:
				out.write("S");
				break;
			default:
				out.write("W");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}