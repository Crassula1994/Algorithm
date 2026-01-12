package bronze2.num03076;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 체스판의 행과 열의 수를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 체스판의 행 높이과 열 너비를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 행과 열을 순회
		for (int r = 0; r < rowNum * height; r++) {
			for (int c = 0; c < columnNum * width; c++) {
				sb.append(((r / height + c / width) & 1) == 1 ? '.' : 'X');
			}
			
			// append() 메서드를 사용해 sb에 줄바꿈 기호를 추가
			sb.append("\n");
		}
		
		// toString() 및 write() 메서드를 사용해 상근이의 체스판을 출력
		out.write(sb.toString());

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}