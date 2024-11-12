package gold3.num25598;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 게임 필드의 크기, 플레이어를 움직일 명령어, 플레이어의 위치, 목표 게임의 일차를 저장할 각 변수 초기화
	static int size;
	static String commands;
	static int playerR;
	static int playerC;
	static int targetDay;
	
	// 각 좀비의 정보를 저장할 배열 zombies 초기화
	static Zombie[] zombies;
	
	// 각 방향을 나타낼 델타 배열 초기화
	static int[] dr = {-1, 0, 1, 0, 0};
	static int[] dc = {0, 1, 0, -1, 0};
	
	// 각 벽의 위치를 저장할 2차원 배열 fields 초기화
	static boolean[][] fields;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Zombie 클래스 정의
	static class Zombie {
		
		// 좀비의 위치, 종류, 방향, 속도를 저장할 각 변수 초기화
		int row;
		int column;
		int category;
		int direction;
		int speed;
		
		// 매개변수를 입력 받는 생성자 정의
		public Zombie(int row, int column, int category, int direction, int speed) {
			this.row = row;
			this.column = column;
			this.category = category;
			this.direction = direction;
			this.speed = speed;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 게임 필드의 크기 및 플레이어를 움직일 명령어를 각 변수에 할당
		size = Integer.parseInt(in.readLine());
		commands = in.readLine();
		
		// 플레이어가 죽었는지 여부 및 죽은 일차를 저장할 각 변수 초기화
		boolean isDead = false;
		int deathDay = 0;
		
		// 각 벽의 위치를 저장할 2차원 배열 fields 초기화
		fields = new boolean[size + 1][size + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 플레이어의 위치를 각 변수에 할당
		playerR = Integer.parseInt(st.nextToken());
		playerC = Integer.parseInt(st.nextToken());

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 벽의 개수를 변수 wallNum에 할당
		int wallNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 벽의 정보를 순회
		while (wallNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 벽의 위치를 배열 fields에 저장
			fields[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 좀비의 수를 변수 zombieNum에 할당
		int zombieNum = Integer.parseInt(in.readLine());
		
		// 각 좀비의 정보를 저장할 배열 zombies 초기화
		zombies = new Zombie[zombieNum];
		
		// for 반복문을 사용해 각 좀비의 정보를 순회
		for (int idx = 0; idx < zombies.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken(), parseInt(), charAt() 메서드를 사용해 좀비의 위치, 종류, 이동 방향, 속도를 각 변수에 할당
			int zombieR = Integer.parseInt(st.nextToken());
			int zombieC = Integer.parseInt(st.nextToken());
			int category = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			int speed = Integer.parseInt(st.nextToken());
			
			// switch 조건문을 사용해 해당 좀비의 정보를 배열 zombies에 저장
			switch (direction) {
				case 'U':
					zombies[idx] = new Zombie(zombieR, zombieC, category, 0, speed);
					break;
				case 'R':
					zombies[idx] = new Zombie(zombieR, zombieC, category, 1, speed);
					break;
				case 'D':
					zombies[idx] = new Zombie(zombieR, zombieC, category, 2, speed);
					break;
				default:
					zombies[idx] = new Zombie(zombieR, zombieC, category, 3, speed);
			}
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 영재가 알고 싶어하는 게임의 일차를 변수 targetDay에 할당
		targetDay = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 일자를 순회
		for (int day = 1; day <= targetDay; day++) {
			
			// playerMover() 메서드를 사용해 플레이어를 이동 처리
			playerMover(day);
			
			// for 반복문을 사용해 각 좀비를 이동 처리
			for (Zombie zombie : zombies)
				zombieMover(zombie);
			
			// 플레이어가 죽은 경우 플레이어가 죽었는지 여부 및 죽은 일차를 갱신 후 반복문 탈출
			if (!playerChecker()) {
				isDead = true;
				deathDay = day;
				break;
			}
		}
		
		// write() 메서드를 사용해 플레이어가 죽었는지 여부를 출력
		out.write((isDead) ? deathDay + "\nDEAD..." : "ALIVE!");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// playerMover() 메서드 정의
	public static void playerMover(int day) {
		
		// charAt() 메서드를 사용해 해당 날짜에 플레이어에게 내려진 명령을 변수 command에 할당
		char command = commands.charAt(day - 1);
		
		// 플레이어의 이동 방향을 나타낼 변수 direction 초기화
		int direction = 4;
		
		// switch 조건문을 사용해 플레이어의 이동 방향을 플레이어에게 내려진 명령에 따라 갱신
		switch (command) {
			case 'U':
				direction = 0;
				break;
			case 'R':
				direction = 1;
				break;
			case 'D':
				direction = 2;
				break;
			case 'L':
				direction = 3;
		}
		
		// 플레이어가 새로 이동할 위치를 나타낼 각 변수 초기화
		int nextPlayerR = playerR + dr[direction];
		int nextPlayerC = playerC + dc[direction];
		
		// 플레이어가 이동할 위치가 게임 필드를 벗어나는 경우 메서드 종료
		if (nextPlayerR < 1 || nextPlayerR > size || nextPlayerC < 1 || nextPlayerC > size)
			return;
		
		// 플레이어가 이동할 위치가 벽인 경우 메서드 종료
		if (fields[nextPlayerR][nextPlayerC])
			return;
		
		// 플레이어 이동 처리
		playerR = nextPlayerR;
		playerC = nextPlayerC;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// zombieMover() 메서드 정의
	public static void zombieMover(Zombie zombie) {
		
		// 하급 좀비인 경우
		if (zombie.category == 0) {
			
			// for 반복문을 사용해 좀비가 이동할 각 칸을 순회
			for (int l = 0; l < zombie.speed; l++) {
				
				// 좀비가 새로 이동할 위치를 나타낼 각 변수 초기화
				int nextZombieR = zombie.row + dr[zombie.direction];
				int nextZombieC = zombie.column + dc[zombie.direction];
				
				// 새로 이동할 위치가 게임 필드를 벗어나거나 벽인 경우
				if (nextZombieR < 1 || nextZombieR > size || nextZombieC < 1
						|| nextZombieC > size || fields[nextZombieR][nextZombieC]) {
					
					// 좀비의 이동 방향을 반대 방향으로 전환
					zombie.direction = (zombie.direction + 2) % 4;
					
					// 메서드 종료
					return;
				}
				
				// 좀비 이동 처리
				zombie.row = nextZombieR;
				zombie.column = nextZombieC;
			}
		
		// 상급 좀비인 경우
		} else {
			
			// for 반복문을 사용해 좀비가 이동할 각 칸을 순회
			for (int h = 0; h < zombie.speed; h++) {
				
				// 좀비가 새로 이동할 위치를 나타낼 각 변수 초기화
				int nextZombieR = zombie.row + dr[zombie.direction];
				int nextZombieC = zombie.column + dc[zombie.direction];
				
				// 새로 이동할 위치가 게임 필드를 벗어나는 경우 반복문 탈출
				if (nextZombieR < 1 || nextZombieR > size || nextZombieC < 1 || nextZombieC > size)
					break;
				
				// 새로 이동할 위치에 벽이 존재하는 경우 벽을 부순 뒤 반복문 탈출
				if (fields[nextZombieR][nextZombieC]) {
					fields[nextZombieR][nextZombieC] = false;
					break;
				}
				
				// 좀비 이동 처리
				zombie.row = nextZombieR;
				zombie.column = nextZombieC;
			}
			
			// directionFinder() 메서드를 호출해 좀비의 이동 방향을 갱신
			zombie.direction = directionFinder(zombie.row, zombie.column, zombie.direction);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// directionFinder() 메서드 정의
	public static int directionFinder(int curRow, int curColumn, int curDirection) {
		
		// 가장 많은 벽의 수 및 이동할 방향을 저장할 각 변수 초기화
		int maxCount = -1;
		int direction = -1;
		
		// for 반복문을 사용해 각 방향을 순회
		for (int d = 0; d < 4; d++) {
			
			// 해당 방향에 위치한 벽의 수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 해당 위치를 순회
			for (int m = 1; m < size; m++) {
				
				// 해당 방향의 위치를 각 변수에 할당
				int nr = curRow + dr[d] * m;
				int nc = curColumn + dc[d] * m;
				
				// 해당 위치가 범위를 벗어난 경우 반복문 탈출
				if (nr < 1 || nr > size || nc < 1 || nc > size)
					break;
				
				// 해당 위치가 벽인 경우 해당 방향에 위치한 벽의 수를 갱신
				if (fields[nr][nc])
					count++;
			}
			
			// 해당 방향에 위치한 벽의 수가 가장 많은 벽의 수인 경우 이동할 방향 및 가장 많은 벽의 수 갱신
			if (count > maxCount) {
				direction = d;
				maxCount = count;
			}
		}
		
		// 이동할 방향을 반환
		return direction;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// playerChecker() 메서드 정의
	public static boolean playerChecker() {
		
		// for 반복문을 사용해 각 좀비를 순회
		for (Zombie zombie : zombies) {
			
			// 해당 좀비의 위치에 플레이어가 위치한 경우 false 반환
			if (zombie.row == playerR && zombie.column == playerC)
				return false;
		}
		
		// 플레이어가 살아 있는 경우 true 반환
		return true;
	}
}