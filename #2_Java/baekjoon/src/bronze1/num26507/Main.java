package bronze1.num26507;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 층의 개수를 변수 layerNum에 할당
		int layerNum = Integer.parseInt(in.readLine());
		
		// 각 층의 정보를 저장할 3차원 배열 layers 초기화
		int[][][] layers = new int[layerNum][10][10];
		
		// for 반복문을 사용해 각 층을 순회
		for (int idx = 0; idx < layerNum; idx++) {
			
			// for 반복문을 사용해 입력 받은 층의 정보를 3차원 배열 layers에 저장
			for (int r = 0; r < 10; r++) {
				
				// readLine() 메서드를 사용해 입력 받은 해당 층의 행 정보를 변수 row에 할당
				String row = in.readLine();
				
				// for 반복문을 사용해 입력 받은 층의 정보를 3차원 배열 layers에 저장
				for (int c = 0; c < 10; c++)
					layers[idx][r][c] = row.charAt(c) - '0';
			}
			
			// readLine() 메서드를 사용해 빈 줄을 제거
			in.readLine();
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 데이터 세트의 개수를 변수 dataSet에 할당
		int dataSet = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 데이터 세트를 순회
		while (dataSet-- > 0) {
			
			// 각 레이어가 사용된 횟수를 저장할 배열 counts 초기화
			int[] counts = new int[layerNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// while 반복문을 사용해 각 레이어가 사용된 횟수를 배열 counts에 저장
			while (st.hasMoreTokens())
				counts[Integer.parseInt(st.nextToken())]++;
			
			// for 반복문을 사용해 각 행과 열을 순회
			for (int r = 0; r < 10; r++) {
				for (int c = 0; c < 10; c++) {
					
					// 해당 위치의 칩의 값을 저장할 변수 chipValue 초기화
					int chipValue = 0;
					
					// for 반복문을 사용해 해당 위치의 칩의 값을 갱신
					for (int idx = 0; idx < layerNum; idx++)
						chipValue += layers[idx][r][c] * counts[idx];
					
					// format() 및 write() 메서드를 사용해 해당 위치의 칩의 값을 출력
					out.write(String.format("%02d ", chipValue));
				}
				
				// newLine() 메서드를 사용해 줄바꿈을 출력
				out.newLine();
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}