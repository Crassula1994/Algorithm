package bronze3.num10995;

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
		
		// for 반복문을 사용해 입력 받은 숫자만큼의 줄을 순회
		for (int r = 0; r < number; r++) {
			
			// 홀수 번째 줄인 경우
			if (r % 2 == 0) {
				
				// for 반복문을 사용해 별부터 입력 받은 숫자만큼 출력
				for (int c = 0; c < number; c++)
					out.write("* ");
				
			// 짝수 번째 줄인 경우
			} else {
				
				// for 반복문을 사용해 빈칸부터 입력 받은 숫자만큼 출력
				for (int c = 0; c < number; c++)
					out.write(" *");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}