package gold5.num14204;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 표의 크기를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int colNum = Integer.parseInt(st.nextToken());
		
		// 해당 표를 오름차순으로 만들 수 있는지 여부를 나타낼 변수 isPossible 초기화
		boolean isPossible = true;
		
		// 첫 번째 행의 순서를 저장할 배열 order 초기화
		int[] order = new int[colNum];
		
		// 입력 받은 표의 숫자를 저장할 2차원 배열 table 초기화
		int[][] table = new int[rowNum][colNum];
		
		// for 반복문을 사용해 표의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 표의 각 칸 숫자보다 1 작은 숫자를 2차원 배열 table에 저장
			for (int c = 0; c < colNum; c++)
				table[r][c] = Integer.parseInt(st.nextToken()) - 1;
		}
		
		// for 반복문을 사용해 각 행을 순회
		outer: for (int r = 0; r < rowNum; r++) {
			
			// 현재 행에 존재하는 숫자가 가져야 할 몫을 변수 group에 할당
			int group = table[r][0] / colNum;
			
			// for 반복문을 사용해 각 열을 순회
			for (int c = 0; c < colNum; c++) {
				
				// 해당 숫자가 현재 행에 존재해야 하는 숫자가 아닌 경우
				if (table[r][c] / colNum != group) {
					
					// 해당 표를 오름차순으로 만들 수 있는지 여부를 갱신 후 반복문 탈출
					isPossible = false;
					break outer;
				}
				
				// 첫 번째 행인 경우 숫자가 가져야 하는 순서를 배열 order에 저장 후 다음 칸을 순회
				if (r == 0) {
					order[c] = table[r][c] % colNum;
					continue;
				}
				
				// 해당 숫자가 현재 칸에 존재해야 하는 숫자가 아닌 경우
				if (table[r][c] % colNum != order[c]) {
					
					// 해당 표를 오름차순으로 만들 수 있는지 여부를 갱신 후 반복문 탈출
					isPossible = false;
					break outer;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 해당 표를 오름차순으로 만들 수 있는지 여부를 출력
		out.write((isPossible) ? String.valueOf(1) : String.valueOf(0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}