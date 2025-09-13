package bronze3.num05724;

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

		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 그리드 한 변에 있는 정사각형의 개수를 변수 squareNum에 할당
			int squareNum = Integer.parseInt(in.readLine());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (squareNum == 0)
				break;
			
			// 서로 다른 정사각형의 개수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 서로 다른 정사각형의 개수를 갱신
			for (int square = 1; square <= squareNum; square++)
				count += square * square;
			
			// write() 메서드를 사용해 서로 다른 정사각형의 개수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}