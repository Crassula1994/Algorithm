package silver4.num01331;

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

		// 나이트 투어 경로가 올바른 것인지를 나타내는 변수 초기화
		boolean isValid = true;
		
		// 나이트가 해당 위치를 방문했는지 여부를 나타내는 2차원 배열 초기화
		boolean[][] visited = new boolean[6][6];
		
		// readLine() 메서드를 사용해 나이트의 출발 위치를 각 변수에 할당
		String startLoc = in.readLine();
		String currentLoc = startLoc;
		
		// for 반복문을 사용해 각 위치를 차례로 순회
		for (int loc = 0; loc < 36; loc++) {
			
			// charAt() 메서드를 사용해 나이트의 위치의 좌표를 각 변수에 할당
			int currentCol = currentLoc.charAt(0) - 'A';
			int currentRow = currentLoc.charAt(1) - '1';
			
			// 현재 위치를 방문하지 않은 경우 방문 처리
			if (!visited[currentRow][currentCol]) {
				visited[currentRow][currentCol] = true;
				
			// 현재 위치를 방문했던 경우 나이트 투어 경로가 올바르지 않으므로 반복문 탈출
			} else {
				isValid = false;
				break;
			}
			
			// 나이트의 다음 위치를 저장할 변수 nextLoc 초기화
			String nextLoc = "";
			
			// 마지막 위치인 경우 출발 위치를 다음 위치에 할당
			if (loc == 35) {
				nextLoc = startLoc;
						
			// 마지막 위치가 아닌 경우 readLine() 메서드를 사용해 다음 위치를 저장
			} else {
				nextLoc = in.readLine();
			}
						
			// charAt() 메서드를 사용해 나이트의 다음 위치의 좌표를 각 변수에 할당
			int nextCol = nextLoc.charAt(0) - 'A';
			int nextRow = nextLoc.charAt(1) - '1';
			
			// abs() 메서드를 사용해 두 좌표의 차이를 각 변수에 할당
			int colDiff = Math.abs(currentCol - nextCol);
			int rowDiff = Math.abs(currentRow - nextRow);
			
			// 다음 위치가 현재 위치에서 나이트가 이동할 수 있는 곳일 경우 현재 위치를 갱신
			if ((colDiff == 2 && rowDiff == 1) || (colDiff == 1 && rowDiff == 2)) {
				currentLoc = nextLoc;
			
			// 다음 위치가 현재 위치에서 나이트가 이동할 수 없는 곳일 경우 반복문 탈출
			} else {
				isValid = false;
				break;
			}
		}
		
		// 나이트 투어 경로가 올바른 것인 경우 'Valid' 출력
		if (isValid) {
			out.write("Valid");
		
		// 나이트 투어 경로가 올바르지 않은 것인 경우 'Valid' 출력
		} else {
			out.write("Invalid");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}