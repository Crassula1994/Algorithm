package gold4.num06987;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 국가 간 경기의 경우의 수 및 경기 결과를 저장할 각 2차원 배열
	static int[][] matches = new int[15][2];
	static int[][] records;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// for 반복문을 사용해 각 국가 간 경기의 경우의 수를 2차원 배열 matches에 저장
		for (int home = 0, idx = 0; home < 5; home++) {
			for (int away = home + 1; away < 6; away++) {
				matches[idx][0] = home;
				matches[idx++][1] = away;
			}
		}
		
		// for 반복문을 사용해 각 결과를 순회
		outer: for (int result = 0; result < 4; result++) {
			
			// 각 국가의 경기 결과를 저장할 2차원 배열 records 초기화
			records = new int[6][3];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 국가의 경기 결과를 순회
			for (int r = 0; r < 6; r++) {
				
				// 해당 국가의 총 경기 수를 저장할 변수 count 초기화
				int count = 0;
				
				// for 반복문을 사용해 각 경기 결과를 순회
				for (int c = 0; c < 3; c++) {
					
					// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 해당 국가의 경기 결과를 2차원 배열 records에 저장
					records[r][c] = Integer.parseInt(st.nextToken());
					
					// 해당 국가의 총 경기 수를 갱신
					count += records[r][c];
				}
				
				// 해당 국가의 총 경기 수가 5경기가 아닌 경우 0을 출력 후 다음 경기 결과를 순회
				if (count != 5) {
					out.write(0 + " ");
					continue outer;
				}
			}
			
			// recordChecker() 및 write() 메서드를 사용해 해당 결과가 가능한지 여부를 출력
			out.write((recordChecker(0)) ? 1 + " " : 0 + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// recordChecker() 메서드 정의
	public static boolean recordChecker(int curMatch) {
		
		// 해당 결과가 가능한 경우 true 반환
		if (curMatch == 15)
			return true;
		
		// 현재 경기에서 맞붙게 되는 두 국가를 각 변수에 할당
		int home = matches[curMatch][0];
		int away = matches[curMatch][1];
		
		// 첫 번째 팀이 이길 수 있는 경우
		if (records[home][0] > 0 && records[away][2] > 0) {
			
			// 첫 번째 팀이 이긴 것으로 상정해 경기 결과 조정
			records[home][0]--;
			records[away][2]--;
			
			// 해당 결과가 가능한 경우 true 반환
			if (recordChecker(curMatch + 1))
				return true;
			
			// 경기 결과를 원래대로 원상 복구
			records[home][0]++;
			records[away][2]++;
		}
		
		// 두 번째 팀이 이길 수 있는 경우
		if (records[home][2] > 0 && records[away][0] > 0) {
			
			// 첫 번째 팀이 이긴 것으로 상정해 경기 결과 조정
			records[home][2]--;
			records[away][0]--;
			
			// 해당 결과가 가능한 경우 true 반환
			if (recordChecker(curMatch + 1))
				return true;
			
			// 경기 결과를 원래대로 원상 복구
			records[home][2]++;
			records[away][0]++;
		}
		
		// 두 팀이 비길 수 있는 경우
		if (records[home][1] > 0 && records[away][1] > 0) {
			
			// 첫 번째 팀이 이긴 것으로 상정해 경기 결과 조정
			records[home][1]--;
			records[away][1]--;
			
			// 해당 결과가 가능한 경우 true 반환
			if (recordChecker(curMatch + 1))
				return true;
			
			// 경기 결과를 원래대로 원상 복구
			records[home][1]++;
			records[away][1]++;
		}
		
		// 어떠한 경우도 불가능한 경우 false 반환
		return false;
	}
}