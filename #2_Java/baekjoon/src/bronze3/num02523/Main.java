package bronze3.num02523;

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
		
		// 행의 길이를 계산해 변수 length에 할당
		int length = number * 2 - 1;
		
		// for 반복문을 사용해 각 줄을 순회
		for (int r = 1; r <= length; r++) {
			
			// 해당 줄이 입력 받은 숫자보다 작거나 같은 경우
			if (r <= number) {
				
				// for 반복문을 사용해 별을 출력
				for (int s = 0; s < r; s++)
					out.write("*");				
			
			// 해당 줄이 입력 받은 숫자보다 큰 경우
			} else {
				
				// for 반복문을 사용해 별을 출력
				for (int s = 0; s < 2 * number - r; s++)
					out.write("*");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}