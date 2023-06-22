package silver5.num01652;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 방의 크기를 변수 roomSize에 할당
		int roomSize = Integer.parseInt(in.readLine());
		
		// 방의 상태를 저장할 2차원 배열 room 초기화
		char[][] room = new char[roomSize][roomSize];
		
		// for 반복문을 사용해 방의 각 행을 순회
		for (int r = 0; r < roomSize; r++) {
			
			// readLine() 메서드를 사용해 입력 받은 방의 행의 상태를 변수 line에 할당
			String line = in.readLine();
			
			// for 반복문을 사용해 배열 roomSize에 방의 상태를 저장
			for (int c = 0; c < roomSize; c++)
				room[r][c] = line.charAt(c);
		}
		
		// 가로로 누울 수 있는 자리 및 세로로 누울 수 있는 자리의 수, 빈 공간의 개수를 저장할 각 변수 초기화
		int rowCnt = 0;
		int colCnt = 0;
		int count = 0;
		
		// for 반복문을 사용해 방의 각 행과 열을 순회
		for (int r = 0; r < roomSize; r++) {
			for (int c = 0; c < roomSize; c++) {
				
				// 짐이 있는 곳인 경우
				if (room[r][c] == 'X') {
					
					// 빈 공간의 개수가 2개 이상인 경우 가로로 누울 수 있는 자리의 수 갱신
					if (count > 1)
						rowCnt++;
					
					// 빈 공간의 개수 초기화
					count = 0;
				
				// 빈 공간인 경우 빈 공간의 개수 갱신
				} else {
					count++;
				}
			}
			
			// 빈 공간의 개수가 2개 이상인 경우 가로로 누울 수 있는 자리의 수 갱신
			if (count > 1)
				rowCnt++;
			
			// 빈 공간의 개수 초기화
			count = 0;
		}
		
		// for 반복문을 사용해 방의 각 행과 열을 순회
		for (int c = 0; c < roomSize; c++) {
			for (int r = 0; r < roomSize; r++) {
				
				// 짐이 있는 곳인 경우
				if (room[r][c] == 'X') {
					
					// 빈 공간의 개수가 2개 이상인 경우 세로로 누울 수 있는 자리의 수 갱신
					if (count > 1)
						colCnt++;
					
					// 빈 공간의 개수 초기화
					count = 0;
				
				// 빈 공간인 경우 빈 공간의 개수 갱신
				} else {
					count++;
				}
			}
			
			// 빈 공간의 개수가 2개 이상인 경우 세로로 누울 수 있는 자리의 수 갱신
			if (count > 1)
				colCnt++;
			
			// 빈 공간의 개수 초기화
			count = 0;
		}
		
		// write() 메서드를 사용해 가로로 누울 수 있는 자리 및 세로로 누울 수 있는 자리의 수를 출력
		out.write(rowCnt + " " + colCnt);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}