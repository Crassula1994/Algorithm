package gold5.num02469;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 참가한 사람의 수 및 전체 가로 줄의 수를 각 변수에 할당
		int participantNum = Integer.parseInt(in.readLine());
		int rowNum = Integer.parseInt(in.readLine());
		
		// 가로 줄을 재구성해 순서를 얻을 수 있는지 여부를 나타낼 변수 canSearch 초기화
		boolean canSearch = true;
		
		// readLine() 및 toCharArray() 메서드를 사용해 사다리를 타기 전과 후의 참가자 위치를 저장할 각 배열 초기화
		char[] startLoc = new char[participantNum];
		char[] endLoc = in.readLine().toCharArray();
		
		// 가로 줄의 상태를 저장할 2차원 배열 ladders 초기화
		char[][] ladders = new char[rowNum][participantNum - 1];
		
		// 감추어진 가로 줄의 상태를 저장할 StringBuilder 객체 sb 초기화
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 사다리를 타기 전의 참가자 위치를 갱신
		for (int idx = 0; idx < startLoc.length; idx++)
			startLoc[idx] = (char) ('A' + idx);
		
		// for 반복문을 사용해 입력 받은 가로 줄의 상태를 2차원 배열 ladders에 저장
		for (int r = 0; r < rowNum; r++)
			ladders[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 가로 줄을 차례로 순회
		outer: for (int r = 0; r < rowNum; r++) {
			
			// for 반복문을 사용해 각 칸을 순회
			for (int c = 0; c < participantNum - 1; c++) {
				
				// 해당 줄이 감추어진 가로 줄인 경우 반복문 탈출
				if (ladders[r][c] == '?')
					break outer;
				
				// 해당 칸에 가로 막대가 존재하는 경우 참가자 위치를 갱신
				if (ladders[r][c] == '-')
					locationSwapper(startLoc, c);
			}
		}
		
		// for 반복문을 사용해 가로 줄을 거꾸로 순회
		outer: for (int r = rowNum - 1; r >= 0; r--) {
			
			// for 반복문을 사용해 각 칸을 순회
			for (int c = 0; c < participantNum - 1; c++) {
				
				// 해당 줄이 감추어진 가로 줄인 경우 반복문 탈출
				if (ladders[r][c] == '?')
					break outer;
				
				// 해당 칸에 가로 막대가 존재하는 경우 참가자 위치를 갱신
				if (ladders[r][c] == '-')
					locationSwapper(endLoc, c);
			}
		}
		
		// for 반복문을 사용해 각 참가자의 위치를 순회
		for (int idx = 0; idx < participantNum - 1; idx++) {
			
			// 해당 참가자의 위치가 동일한 경우 '*'을 sb에 추가
			if (startLoc[idx] == endLoc[idx]) {
				sb.append("*");
				
			// 해당 참가자의 위치가 서로 뒤바뀐 경우
			} else if (startLoc[idx] == endLoc[idx + 1] && startLoc[idx + 1] == endLoc[idx]) {
				
				// append() 메서드를 사용해 '-'을 sb에 추가
				sb.append("-");
				
				// locationSwapper() 메서드를 호출해 참가자의 위치를 갱신
				locationSwapper(startLoc, idx);
			
			// 가로 줄을 재구성해 순서를 얻을 수 없는 경우
			} else {
				
				// for 반복문을 사용해 'x'를 출력
				for (int count = 0; count < participantNum - 1; count++)
					out.write("x");
				
				// 재구성 가능 여부 갱신 후 반복문 탈출 
				canSearch = false;
				break;
			}
		}
		
		// 가로 줄을 재구성해 순서를 얻을 수 있는 경우 
		if (canSearch)
			out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// locationSwapper() 메서드 정의
	public static void locationSwapper(char[] location, int index) {
		
		// 입력 받은 참가자의 위치를 교환
		char temp = location[index];
		location[index] = location[index + 1];
		location[index + 1] = temp;
	}
}