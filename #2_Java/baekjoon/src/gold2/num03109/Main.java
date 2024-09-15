package gold2.num03109;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 빵집이 있는 곳의 크기를 저장할 각 변수 초기화
	static int rowNum;
	static int columnNum;
	
	// 다음에 이동할 위치를 저장할 델타 배열 dr 초기화
	static int[] dr = {-1, 0, 1};
	
	// 빵집 근처의 모습을 저장할 2차원 배열 map 초기화
	static char[][] map;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 빵집이 있는 곳의 크기를 각 변수에 할당
		rowNum = Integer.parseInt(st.nextToken());
		columnNum = Integer.parseInt(st.nextToken());
		
		// 원웅이가 놓을 수 있는 파이프라인의 최대 개수를 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// 빵집 근처의 모습을 저장할 2차원 배열 map 초기화
		map = new char[rowNum][columnNum];
		
		// for 반복문을 사용해 입력 받은 빵집 근처의 모습을 2차원 배열 map에 저장
		for (int r = 0; r < rowNum; r++)
			map[r] = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 파이프라인의 시작 위치를 순회
		for (int r = 0; r < rowNum; r++) {
			
			// 파이프라인을 놓을 수 있는 경우 원웅이가 놓을 수 있는 파이프라인의 최대 개수를 갱신
			if (pipelineBuilder(r, 0))
				maxCount++;
		}
			
		// valueOf() 및 write() 메서드를 사용해 원웅이가 놓을 수 있는 파이프라인의 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// pipelineBuilder() 메서드 정의
	public static boolean pipelineBuilder(int curRow, int curCol) {
		
		// 현재 위치를 확인 처리
		map[curRow][curCol] = 'O';
		
		// 현재 위치가 마지막 열인 경우 true 반환
		if (curCol == columnNum - 1)
			return true;
		
		// for 반복문을 사용해 다음에 이동할 위치를 순회
		for (int d = 0; d < 3; d++) {
			
			// 다음에 이동할 위치를 각 변수에 할당
			int nextRow = curRow + dr[d];
			int nextCol = curCol + 1;
			
			// 해당 위치가 빵집이 있는 곳의 범위를 벗어난 경우 다음 위치를 순회
			if (nextRow < 0 || nextRow >= rowNum)
				continue;
			
			// 해당 위치를 이미 확인했거나 건물이 위치한 경우 다음 위치를 순회
			if (map[nextRow][nextCol] != '.')
				continue;
			
			// 파이프라인을 건설할 수 있는 경우 true 반환
			if (pipelineBuilder(nextRow, nextCol))
				return true;
		}
		
		// 파이프라인을 놓을 수 없는 경우 false 반환
		return false;
	}
}