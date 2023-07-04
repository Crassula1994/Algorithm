package bronze1.num01236;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 성의 세로 크기와 가로 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 각 행과 열에 경비원이 위치하는지를 나타내는 각 배열 초기화
		boolean[] rowGuard = new boolean[height];
		boolean[] colGuard = new boolean[width];
		
		// for 반복문을 사용해 성의 각 행을 순회
		for (int row = 0; row < height; row++) {
			
			// readLine() 메서드를 사용해 입력 받는 성의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 성의 각 열을 순회
			for (int col = 0; col < width; col++) {
				
				// charAt() 메서드를 사용해 해당 위치의 상태를 변수 status에 할당
				char status = line.charAt(col);
				
				// 해당 위치에 경비원이 있는 경우 경비원이 위치하는지 여부를 갱신
				if (status == 'X') {
					rowGuard[row] = true;
					colGuard[col] = true;
				}
			}
		}
		
		// 경비원이 필요한 행과 열의 수를 저장할 각 변수를 갱신
		int rowCnt = 0;
		int colCnt = 0;
		
		// for 반복문을 사용해 배열 rowGuard를 순회
		for (boolean isExisted : rowGuard) {
			
			// 경비원이 존재하지 않는 경우 경비원이 필요한 행의 수를 갱신
			if (!isExisted)
				rowCnt++;
		}
		
		// for 반복문을 사용해 배열 colGuard를 순회
		for (boolean isExisted : colGuard) {
			
			// 경비원이 존재하지 않는 경우 경비원이 필요한 열의 수를 갱신
			if (!isExisted)
				colCnt++;
		}
		
		// max(), valueOf(), write() 메서드를 사용해 추가해야 하는 경비원의 최솟값을 출력
		out.write(String.valueOf(Math.max(rowCnt, colCnt)));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}