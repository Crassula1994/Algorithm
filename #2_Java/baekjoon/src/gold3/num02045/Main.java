package gold3.num02045;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 마방진을 저장할 2차원 배열 magicSquare 초기화
	static int[][] magicSquare = new int[3][3];
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 마방진의 각 행을 순회
		for (int r = 0; r < 3; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 마방진의 입력 받은 각 값을 2차원 배열 magicSquare에 저장
			for (int c = 0; c < 3; c++)
				magicSquare[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 완성된 마방진을 출력
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++)
				out.write(magicSquare[r][c] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}