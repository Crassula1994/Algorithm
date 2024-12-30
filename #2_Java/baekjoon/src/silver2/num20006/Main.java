package silver2.num20006;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 방의 정원을 저장할 변수 capacity 초기화
	static int capacity;
	
	// 현재 생성된 방의 정보 및 레벨 제한을 저장할 List 객체 rooms 초기화
	static List<List<Player>> rooms = new ArrayList<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// Player 클래스 정의
	static class Player implements Comparable<Player> {
		
		// 플레이어의 레벨 및 닉네임을 저장할 각 변수 초기화
		int level;
		String nickname;
		
		// 매개변수를 입력 받는 생성자 정의
		public Player(int level, String nickname) {
			this.level = level;
			this.nickname = nickname;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Player anotherPlayer) {
			
			// compareTo() 메서드를 사용해 닉네임을 사전 순으로 반환
			return this.nickname.compareTo(anotherPlayer.nickname);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 플레이어의 수와 방의 정원을 각 변수에 할당
		int playerNum = Integer.parseInt(st.nextToken());
		capacity = Integer.parseInt(st.nextToken());
		
		// while 반복문을 사용해 각 플레이어의 정보를 입장 신청 순서대로 순회
		while (playerNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 플레이어의 레벨과 닉네임을 각 변수에 할당
			int level = Integer.parseInt(st.nextToken());
			String nickname = st.nextToken();
			
			// 해당 플레이어가 들어갈 방이 없는 경우
			if (!roomFinder(level, nickname)) {
				
				// add() 메서드를 사용해 새로운 방을 생성
				rooms.add(new ArrayList<>());
				
				// size(), get(), add() 메서드를 사용해 새로운 방에 해당 플레이어를 추가
				rooms.get(rooms.size() - 1).add(new Player(level, nickname));
			}
		}
		
		// for 반복문을 사용해 각 방을 순회
		for (List<Player> room : rooms) {
			
			// size() 및 write() 메서드를 사용해 해당 방이 시작되었는지 여부를 출력
			out.write((room.size() == capacity) ? "Started!" : "Waiting!");
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
			
			// sort() 메서드를 사용해 해당 방의 플레이어를 닉네임을 기준으로 사전 순 정렬
			Collections.sort(room);
			
			// for 반복문을 사용해 각 플레이어의 정보를 출력
			for (Player player : room)
				out.write(player.level + " " + player.nickname + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// roomFinder() 메서드 정의
	private static boolean roomFinder(int level, String nickname) {
		
		// for 반복문을 사용해 각 방을 순회
		for (List<Player> room : rooms) {
			
			// 해당 방의 정원이 모두 찬 경우 다음 방을 순회
			if (room.size() == capacity)
				continue;
			
			// 해당 방의 레벨 제한을 만족하지 못하는 경우 다음 방을 순회
			if (Math.abs(level - room.get(0).level) > 10)
				continue;
			
			// add() 메서드를 사용해 해당 방에 해당 플레이어를 추가
			room.add(new Player(level, nickname));
			
			// 해당 플레이어가 들어갈 방이 있는 경우 true 반환
			return true;
		}
		
		// 해당 플레이어가 들어갈 방이 없는 경우 false 반환
		return false;
	}
}