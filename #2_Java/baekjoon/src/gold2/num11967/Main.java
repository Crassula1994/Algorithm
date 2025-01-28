package gold2.num11967;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 헛간의 크기를 저장할 변수 size 초기화
	static int size;
	
	// 인접한 방을 나타낼 각 델타 배열 초기화
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	// 각 방에 위치한 스위치의 정보를 저장할 2차원 배열 switches 초기화
	static List<Room>[][] switches;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Room 클래스 정의
	static class Room {
		
		// 해당 방의 위치를 저장할 각 변수 초기화
		int row;
		int column;
		
		// 매개변수를 입력 받는 생성자 정의
		public Room(int row, int column) {
			this.row = row;
			this.column = column;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 헛간의 크기와 스위치의 개수를 각 변수에 할당
		size = Integer.parseInt(st.nextToken());
		int switchNum = Integer.parseInt(st.nextToken());
		
		// 각 방에 위치한 스위치의 정보를 저장할 2차원 배열 switches 초기화
		switches = new ArrayList[size][size];
		
		// for 반복문을 사용해 각 방의 스위치 정보를 저장할 List 객체 초기화
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++)
				switches[r][c] = new ArrayList<>();
		}
		
		// while 반복문을 사용해 각 스위치의 정보를 순회
		while (switchNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 스위치의 위치와 해당 스위치로 켤 수 있는 방의 위치를 각 변수에 할당
			int curRoomR = Integer.parseInt(st.nextToken()) - 1;
			int curRoomC = Integer.parseInt(st.nextToken()) - 1;
			int targetRoomR = Integer.parseInt(st.nextToken()) - 1;
			int targetRoomC = Integer.parseInt(st.nextToken()) - 1;
			
			// add() 메서드를 사용해 입력 받은 스위치의 정보를 2차원 배열 switches에 저장
			switches[curRoomR][curRoomC].add(new Room(targetRoomR, targetRoomC));
		}
		
		// roomLighter() 메서드를 호출해 베시가 불을 켤 수 있는 방의 최대 개수를 변수 maxCount에 할당
		int maxCount = roomLighter(0, 0);
		
		// valueOf() 및 write() 메서드를 사용해 베시가 불을 켤 수 있는 방의 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// roomLighter() 메서드 정의
	public static int roomLighter(int startRow, int startColumn) {
		
		// 베시가 불을 켤 수 있는 방의 최대 개수를 저장할 변수 maxCount 초기화
		int maxCount = 1;
		
		// 현재 방을 이동했는지, 불을 켰는지 여부를 저장할 각 2차원 배열 초기화
		boolean[][] moved = new boolean[size][size];
		boolean[][] lighted = new boolean[size][size];
		
		// 다음에 움직일 방의 위치를 저장할 Queue 객체 roomList 초기화
		Queue<Room> roomList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 roomList에 추가 후 불이 켜졌는지 여부를 갱신
		roomList.offer(new Room(startRow, startColumn));
		lighted[startRow][startColumn] = true;
		
		// while 반복문을 사용해 roomList가 빌 때까지 순회
		while (!roomList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 방의 위치를 변수 curRoom에 할당
			Room curRoom = roomList.poll();
			
			// 현재 방을 이미 이동했던 경우 다음 위치를 순회
			if (moved[curRoom.row][curRoom.column])
				continue;
			
			// 현재 방을 이동했는지 여부를 갱신
			moved[curRoom.row][curRoom.column] = true;
			
			// for 반복문을 사용해 해당 방의 스위치를 순회
			for (Room nextRoom : switches[curRoom.row][curRoom.column]) {
				
				// 해당 방에 이미 불이 켜진 경우 다음 스위치를 순회
				if (lighted[nextRoom.row][nextRoom.column])
					continue;
				
				// 해당 방에 불이 켜졌는지 여부 및 베시가 불을 켤 수 있는 방의 최대 개수를 갱신
				lighted[nextRoom.row][nextRoom.column] = true;
				maxCount++;
			}
			
			// for 반복문을 사용해 인접한 위치를 순회
			for (int d = 0; d < 4; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nr = curRoom.row + dr[d];
				int nc = curRoom.column + dc[d];
				
				// 해당 위치가 헛간의 범위를 벗어나는 경우 다음 위치를 순회
				if (nr < 0 || nr >= size || nc < 0 || nc >= size)
					continue;
				
				// 해당 위치를 이미 확인했거나 불이 꺼져 있는 경우 다음 위치를 순회
				if (moved[nr][nc] || !lighted[nr][nc])
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 roomList에 추가
				roomList.offer(new Room(nr, nc));
			}
			
			// for 반복문을 사용해 새롭게 불이 켜진 각 방을 순회
			for (Room nextRoom : switches[curRoom.row][curRoom.column]) {
				
				// 해당 방이 이미 방문한 위치와 인접했는지 여부를 저장할 변수 canMove 초기화
				boolean canMove = false;
				
				// for 반복문을 사용해 해당 방과 인접한 위치를 순회
				for (int d = 0; d < 4; d++) {
					
					// 인접한 위치를 각 변수에 할당
					int nr = nextRoom.row + dr[d];
					int nc = nextRoom.column + dc[d];
					
					// 해당 위치가 헛간의 범위를 벗어나는 경우 다음 위치를 순회
					if (nr < 0 || nr >= size || nc < 0 || nc >= size)
						continue;
					
					// 해당 위치를 이미 확인한 경우 이미 방문한 위치와 인접했는지 여부를 갱신 후 반복문 탈출
					if (moved[nr][nc]) {
						canMove = true;
						break;
					}
				}
				
				// 해당 방이 이미 방문한 위치와 인접한 경우 해당 위치를 roomList에 추가
				if (canMove)
					roomList.offer(new Room(nextRoom.row, nextRoom.column));
			}
		}
		
		// 베시가 불을 켤 수 있는 방의 최대 개수를 반환
		return maxCount;
	}
}