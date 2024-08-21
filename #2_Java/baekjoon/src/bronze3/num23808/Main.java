package bronze3.num23808;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 셀의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 셀의 각 행과 열을 순회
		for (int r = 0; r < 5 * size; r++) {
			for (int c = 0; c < 5 * size; c++) {
				
				// 골뱅이를 출력해야 하는 경우 골뱅이를 출력
				if (r / size == 2 || r / size == 4 || c / size == 0 || c / size == 4) {
					out.write("@");
					
				// 빈 칸을 출력해야 하는 경우 빈 칸을 출력
				} else {
					out.write(" ");
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}