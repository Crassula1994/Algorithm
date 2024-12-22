package bronze4.num07595;

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
		
		// while 반복문을 사용해 각 크기의 삼각형을 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 삼각형의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// 주어진 삼각형의 크기가 0인 경우 반복문 탈출
			if (size == 0)
				break;
			
			// for 반복문을 사용해 각 삼각형의 줄을 순회
			for (int line = 1; line <= size; line++) {
			
				// for 반복문을 사용해 각 줄의 별을 출력
				for (int count = 0; count < line; count++)
					out.write("*");
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}