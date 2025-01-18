package silver4.num15489;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 파스칼 삼각형의 각 값을 저장할 2차원 배열 triangle 초기화
	static int[][] triangle;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 꼭짓점의 좌표와 한 변이 포함하는 수의 개수를 각 변수에 할당
		int vertexRow = Integer.parseInt(st.nextToken());
		int vertexColumn = Integer.parseInt(st.nextToken());
		int sideCount = Integer.parseInt(st.nextToken());
		
		// 해당 정삼각형에 존재하는 수들의 합을 저장할 변수 sum 초기화
		int sum = 0;
		
		// 파스칼 삼각형의 각 값을 저장할 2차원 배열 triangle 초기화
		triangle = new int[vertexRow + sideCount + 1][vertexRow + sideCount + 1];
		
		// triangleMaker() 메서드를 호출해 파스칼 삼각형의 값을 갱신
		triangleMaker(vertexRow + sideCount);
		
		// for 반복문을 사용해 해당 정삼각형에 존재하는 수들의 합을 갱신
		for (int r = vertexRow; r < vertexRow + sideCount; r++) {
			for (int c = vertexColumn; c <= vertexColumn + r - vertexRow; c++)
				sum += triangle[r][c];
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 정삼각형에 존재하는 수들의 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// triangleMaker() 메서드 정의
	public static void triangleMaker(int size) {
		
		// for 반복문을 사용해 각 행을 순회
		for (int r = 1; r <= size; r++) {
			
			// for 반복문을 사용해 각 칸을 순회
			for (int c = 1; c <= r; c++) {
				
				// 삼각형의 가장자리인 경우 1이 들어가야 하므로 해당 칸의 값을 갱신
				if (c == 1 || c == r) {
					triangle[r][c] = 1;
					
				// 삼각형의 내부인 경우 해당 칸의 값을 갱신
				} else {
					triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
				}
			}
		}
	}
}