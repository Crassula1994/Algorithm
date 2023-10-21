package bronze2.num10996;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 숫자만큼 반복해서 순회
		for (int line = 0; line < number; line++) {
			
			// for 반복문을 사용해 첫 번째 줄을 순회
			for (int idx = 0; idx < number; idx++) {
				
				// 홀수 위치인 경우 '*'을 출력
				if (idx % 2 == 0) {
					out.write("*");
				
				// 짝수 위치인 경우 빈 칸을 출력
				} else {
					out.write(" ");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
			
			// for 반복문을 사용해 두 번째 줄을 순회
			for (int idx = 0; idx < number; idx++) {
				
				// 홀수 위치인 경우 빈 칸을 출력
				if (idx % 2 == 0) {
					out.write(" ");
				
				// 짝수 위치인 경우 '*'을 출력
				} else {
					out.write("*");
				}
			} 
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}