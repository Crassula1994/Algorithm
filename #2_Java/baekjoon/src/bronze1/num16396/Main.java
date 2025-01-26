package bronze1.num16396;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 박스의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 박스의 각 칸을 순회
			for (int r = 0; r < size; r++) {
				for (int c = 0; c < size; c++) {
					
					// 해당 칸이 테두리인 경우 '#'을 출력
					if (r == 0 || r == size - 1 || c == 0 || c == size - 1) {
						out.write("#");
						
					// 해당 칸이 테두리가 아닌 경우 'J'를 출력
					} else {
						out.write("J");
					}
				}
				
				// newLine() 메서드를 사용해 줄바꿈 출력
				out.newLine();
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}