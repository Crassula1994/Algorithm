package bronze3.num23805;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 'ㄹ'자 모양을 저장할 2차원 배열 box 초기화
	static char[][] box = new char[][] {
			{'@', '@', '@', ' ', '@'},
			{'@', ' ', '@', ' ', '@'},
			{'@', ' ', '@', ' ', '@'},
			{'@', ' ', '@', ' ', '@'},
			{'@', ' ', '@', '@', '@'}
	};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 셀의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 셀의 모양을 출력
		for (int r = 0; r < size * 5; r++) {
			for (int c = 0; c < size * 5; c++)
				out.write(box[r / size][c / size]);
				
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}