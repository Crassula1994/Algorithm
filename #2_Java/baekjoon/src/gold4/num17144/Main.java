package gold4.num17144;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 미세먼지의 확산 방향을 저장할 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 방의 크기 및 지난 시간을 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());
		int totalTime = Integer.parseInt(st.nextToken());
		
		// 공기청정기의 위치를 저장할 배열 airCleaner 초기화
		List<Integer> airCleaner = new ArrayList<>();
		
		// 방의 미세먼지 현황을 저장할 2차원 배열 room 초기화
		int[][] room = new int[rowNum][columnNum];
		
		// for 반복문을 사용해 입력 받은 방 상태의 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 방 상태의 열을 순회
			for (int c = 0; c < columnNum; c++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 방 상태를 2차원 배열 room에 저장
				room[r][c] = Integer.parseInt(st.nextToken());
				
				// 해당 위치가 공기청정기인 경우 공기청정기의 위치를 airCleaner에 저장
				if (room[r][c] == -1)
					airCleaner.add(r);
			}
		}
		
		// get() 메서드를 사용해 각 공기청정기의 위치를 각 변수에 할당
		int upperCleaner = airCleaner.get(0);
		int lowerCleaner = airCleaner.get(1);
		
		// for 반복문을 사용해 각 시간을 순회
		for (int t = 1; t <= totalTime; t++) {
			
			// 변화가 일어난 후의 방의 상태를 저장할 2차원 배열 nextRoom 초기화
			int[][] nextRoom = new int[rowNum][columnNum];
			
			// for 반복문을 사용해 공기청정기의 위치를 nextRoom에 저장
			for (int idx = 0; idx < airCleaner.size(); idx++)
				nextRoom[airCleaner.get(idx)][0] = -1;
			
			// for 반복문을 사용해 각 방의 상태를 순회
			for (int r = 0; r < rowNum; r++) {
				for (int c = 0; c < columnNum; c++) {
					
					// 해당 방에 미세먼지가 존재하는 경우
					if (room[r][c] > 0) {
						
						// 확산할 위치의 수를 저장할 변수 count 초기화
						int count = 0;
						
						// for 반복문을 사용해 확산할 위치를 순회
						for (int d = 0; d < 4; d++) {
							
							// 확산할 위치를 각 변수에 할당
							int nr = r + dr[d];
							int nc = c + dc[d];
							
							// 확산할 위치가 범위를 벗어나거나 공기청정기인 경우 다음 위치를 순회
							if (nr < 0 || nr >= rowNum || nc < 0 || nc >= columnNum || room[nr][nc] == -1)
								continue;
							
							// 확산할 위치의 수 및 미세먼지를 갱신
							count++;
							nextRoom[nr][nc] += room[r][c] / 5;
						}
						
						// 확산한 이후 미세먼지를 갱신
						nextRoom[r][c] += room[r][c] - (room[r][c] / 5 * count);
					}
				}
			}
			
			// 미세먼지가 확산한 이후의 방의 상태를 갱신
			room = nextRoom;
			
			// for 반복문을 사용해 위쪽 공기 청정기 왼쪽 열의 미세먼지를 이동
			for (int r = upperCleaner - 1; r > 0; r--)
				room[r][0] = room[r - 1][0];
			
			// for 반복문을 사용해 위쪽 공기 청정기 위쪽 행의 미세먼지를 이동
			for (int c = 0; c < columnNum - 1; c++)
				room[0][c] = room[0][c + 1];
			
			// for 반복문을 사용해 위쪽 공기 청정기 오른쪽 열의 미세먼지를 이동
			for (int r = 0; r < upperCleaner; r++)
				room[r][columnNum - 1] = room[r + 1][columnNum - 1];
			
			// for 반복문을 사용해 위쪽 공기 청정기 아래쪽 행의 미세먼지를 이동
			for (int c = columnNum - 1; c > 1; c--)
				room[upperCleaner][c] = room[upperCleaner][c - 1];
			
			// 위쪽 공기청정기 바로 앞의 방의 상태를 갱신
			room[upperCleaner][1] = 0;
			
			// for 반복문을 사용해 아래쪽 공기 청정기 왼쪽 열의 미세먼지를 이동
			for (int r = lowerCleaner + 1; r < rowNum - 1; r++)
				room[r][0] = room[r + 1][0];
			
			// for 반복문을 사용해 아래쪽 공기 청정기 아래쪽 행의 미세먼지를 이동
			for (int c = 0; c < columnNum - 1; c++)
				room[rowNum - 1][c] = room[rowNum - 1][c + 1];
			
			// for 반복문을 사용해 아래쪽 공기 청정기 오른쪽 열의 미세먼지를 이동
			for (int r = rowNum - 1; r > lowerCleaner; r--)
				room[r][columnNum - 1] = room[r - 1][columnNum - 1];
			
			// for 반복문을 사용해 아래쪽 공기 청정기 위쪽 행의 미세먼지를 이동
			for (int c = columnNum - 1; c > 1; c--)
				room[lowerCleaner][c] = room[lowerCleaner][c - 1];
			
			// 아래쪽 공기청정기 바로 앞의 방의 상태를 갱신
			room[lowerCleaner][1] = 0;
		}
		
		// 방에 남아있는 미세먼지의 양을 저장할 변수 totalAmount 초기화
		int totalAmount = 0;
		
		// for 반복문을 사용해 시간이 지난 후의 방의 상태를 순회
		for (int r = 0; r < rowNum; r++) {
			for (int c = 0; c < columnNum; c++) {
				
				// 미세먼지가 존재하는 경우 방에 남아있는 미세먼지의 양을 갱신
				if (room[r][c] > 0)
					totalAmount += room[r][c];
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 방에 남아있는 미세먼지의 양을 출력
		out.write(String.valueOf(totalAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}