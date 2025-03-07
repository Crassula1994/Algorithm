package bronze1.num02897;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 주차 가능 공간을 저장할 각 델타 배열 초기화
	static int[] dr = {0, 0, 1, 1};
	static int[] dc = {0, 1, 0, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행의 개수 및 열의 개수를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());
		
		// 차를 부순 대수별로 주차할 수 있는 공간의 개수를 저장할 배열 counts 초기화
		int[] counts = new int[5];
		
		// 입력 받은 주차장의 상태를 저장할 2차원 배열 parkingLot 초기화
		char[][] parkingLot = new char[rowNum][columnNum];
		
		// for 반복문을 사용해 입력 받은 주차장의 상태를 2차원 배열 parkingLot에 저장
		for (int r = 0; r < rowNum; r++)
			parkingLot[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 주차 가능 공간을 순회
		for (int r = 0; r < rowNum - 1; r++) {
			outer: for (int c = 0; c < columnNum - 1; c++) {
				
				// 주차하기 위해 부숴야 하는 차의 수를 저장할 변수 count 초기화
				int count = 0;
				
				// for 반복문을 사용해 각 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 해당 위치의 상태를 변수 cell에 할당
					char cell = parkingLot[r + dr[d]][c + dc[d]];
					
					// 해당 위치가 빌딩인 경우 다음 주차 가능 공간을 순회
					if (cell == '#')
						continue outer;
					
					// 해당 위치가 주차된 차인 경우 주차하기 위해 부숴야 하는 차의 수를 갱신
					if (cell == 'X')
						count++;
				}
				
				// 차를 부순 대수별 주차할 수 있는 공간의 개수를 갱신
				counts[count]++;
			}
		}
		
		// for 반복문을 사용해 차를 부순 대수별 주차할 수 있는 공간의 개수를 출력
		for (int count : counts)
			out.write(count + "\n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}