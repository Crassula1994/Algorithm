package bronze3.num18883;

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
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행과 열의 개수를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 행과 열을 순회
		for (int r = 0, number = 1; r < rowNum; r++) {
			for (int c = 0; c < columnNum; c++) {
				
				// append() 메서드를 사용해 각 숫자를 sb에 저장
				sb.append(number++);
				
				// 마지막 열이 아닌 경우 빈 칸을 sb에 저장
				if (c < columnNum - 1)
					sb.append(" ");
			}
			
			// append() 메서드를 사용해 줄바꿈을 sb에 저장
			sb.append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 숫자를 순서대로 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}