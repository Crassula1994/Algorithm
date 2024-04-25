package silver5.num16395;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 파스칼 삼각형의 행과 열의 숫자를 각 변수에 할당
		int targetRow = Integer.parseInt(st.nextToken());
		int targetCol = Integer.parseInt(st.nextToken());
		
		// 파스칼의 삼각형의 각 숫자를 저장할 2차원 배열 triangle 초기화
		int[][] triangle = new int[targetRow + 1][targetRow + 1];
		
		// 파스칼의 삼각형의 첫 번째 줄의 숫자를 초기화
		triangle[1][1] = 1;
		
		// for 반복문을 사용해 파스칼의 삼각형의 각 숫자를 갱신
		for (int r = 2; r <= targetRow; r++) {
			for (int c = 1; c <= r; c++)
				triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
		}
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 파스칼 삼각형의 행과 열에 해당하는 숫자를 출력
		out.write(String.valueOf(triangle[targetRow][targetCol]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}