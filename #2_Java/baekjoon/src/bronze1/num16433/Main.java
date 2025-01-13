package bronze1.num16433;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 밭의 크기 및 당근을 심은 위치를 각 변수에 할당
		int size = Integer.parseInt(st.nextToken());
		int startRow = Integer.parseInt(st.nextToken());
		int startColumn = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 밭의 각 칸을 순회
		for (int r = 1; r <= size; r++) {
			for (int c = 1; c <= size; c++) {
				
				// 당근을 심어야 하는 곳인 경우 'v'를 출력
				if ((r % 2 == startRow % 2 && c % 2 == startColumn % 2)
						|| (r % 2 != startRow % 2 && c % 2 != startColumn % 2)) {
					out.write("v");
					
				// 당근을 심지 않아야 하는 곳인 경우 '.'을 출력
				} else {
					out.write(".");
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