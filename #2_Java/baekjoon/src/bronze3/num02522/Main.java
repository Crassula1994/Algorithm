package bronze3.num02522;

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
		
		// 별을 출력할 시작 위치를 저장할 변수 loc 초기화
		int loc = number - 1;
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 0; r < number * 2 - 1; r++) {
			
			// for 반복문을 사용해 각 열을 순회
			for (int c = 0; c < number; c++) {
				
				// 별을 출력할 위치인 경우 별을 출력
				if (c >= loc) {
					out.write("*");
					
				// 빈칸을 출력할 위치인 경우 빈칸을 출력
				} else {
					out.write(" ");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
			
			// 별을 출력할 위치를 조정
			loc = (r < number - 1) ? loc - 1 : loc + 1;
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}