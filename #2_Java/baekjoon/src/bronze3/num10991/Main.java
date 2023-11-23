package bronze3.num10991;

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
		
		// for 반복문을 사용해서 각 행을 순회
		for (int r = 1; r <= number; r++) {

			// for 반복문을 사용해 빈 칸을 출력
			for (int c = 0; c < number - r; c++)
				out.write(" ");
			
			// for 반복문을 사용해 각 별을 순회
			for (int c = 0; c < r; c++) {
				
				// write() 메서드를 사용해 별을 출력
				out.write("*");
				
				// 마지막 별인 경우 반복문 탈출
				if (c == r - 1)
					break;

				// write() 메서드를 사용해 빈 칸을 출력
				out.write(" ");
			}

			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}