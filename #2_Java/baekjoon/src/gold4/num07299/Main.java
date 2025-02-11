package gold4.num07299;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 인접한 큐브의 각 방향을 저장할 각 델타 배열 초기화
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	// 각 위치에 식량 큐브가 존재하는지 여부를 나타낼 3차원 배열 isCube 초기화
	static boolean[][][] isFoodCube;
	
	// ----------------------------------------------------------------------------------------------------
	
	// Cube 클래스 정의
	static class Cube {
		
		// 해당 공간의 좌표를 나타낼 각 변수 초기화
		int coordinateX;
		int coordinateY;
		int coordinateZ;
		
		// 매개변수를 입력 받는 생성자 정의
		public Cube(int coordinateX, int coordinateY, int coordinateZ) {
			this.coordinateX = coordinateX;
			this.coordinateY = coordinateY;
			this.coordinateZ = coordinateZ;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// gc() 메서드를 사용해 메모리 초기화
			System.gc();
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 식량 큐브의 개수를 변수 cubeNum에 할당
			int cubeNum = Integer.parseInt(in.readLine());
			
			// 구멍의 개수를 저장할 변수 holeNum 초기화
			int holeNum = 0;
			
			// 각 위치에 식량 큐브가 존재하는지 여부를 나타낼 3차원 배열 isFoodCube 초기화
			isFoodCube = new boolean[100][100][100];
			
			// while 반복문을 사용해 각 식량 큐브를 순회
			while (cubeNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 식량 큐브의 각 좌표를 각 변수에 할당
				int coordinateX = Integer.parseInt(st.nextToken()) - 1;
				int coordinateY = Integer.parseInt(st.nextToken()) - 1;
				int coordinateZ = Integer.parseInt(st.nextToken()) - 1;
				
				// 해당 위치에 식량 큐브가 존재하는지 여부를 갱신
				isFoodCube[coordinateX][coordinateY][coordinateZ] = true;
			}
			
			// for 반복문을 사용해 각 좌표를 순회
			for (int x = 0; x < 100; x++) {
				for (int y = 0; y < 100; y++) {
					for (int z = 0; z < 100; z++) {
						
						// 해당 위치에 식량 큐브가 존재하는 경우 다음 칸을 순회
						if (isFoodCube[x][y][z])
							continue;
						
						// 해당 위치가 구멍인 경우 구멍의 개수를 갱신
						if (holeFinder(x, y, z))
							holeNum++;
					}
				}
			}
			
			// write() 메서드를 사용해 구멍의 개수를 출력
			out.write(holeNum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// holeFinder() 메서드 정의
	public static boolean holeFinder(int startX, int startY, int startZ) {
		
		// 해당 공간이 구멍인지 여부를 나타낼 변수 isHole 초기화
		boolean isHole = true;
		
		// 다음에 방문할 위치를 저장할 Queue 객체 cubeList 초기화
		Queue<Cube> cubeList = new LinkedList<>();
		
		// offer() 메서드를 사용해 시작 위치를 cubeList에 추가 후 해당 위치 확인 처리
		cubeList.offer(new Cube(startX, startY, startZ));
		isFoodCube[startX][startY][startZ] = true;
		
		// while 반복문을 사용해 cubeList가 빌 때까지 순회
		while (!cubeList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 위치를 변수 curCube에 할당
			Cube curCube = cubeList.poll();
			
			// for 반복문을 사용해 인접한 각 위치를 순회
			for (int d = 0; d < 6; d++) {
				
				// 인접한 위치를 각 변수에 할당
				int nx = curCube.coordinateX + dx[d];
				int ny = curCube.coordinateY + dy[d];
				int nz = curCube.coordinateZ + dz[d];
				
				// 해당 위치가 공간의 범위를 벗어나는 경우 해당 공간이 구멍인지 여부를 갱신 후 다음 위치를 순회
				if (nx < 0 || nx >= 100 || ny < 0 || ny >= 100 || nz < 0 || nz >= 100) {
					isHole = false;
					continue;
				}
				
				// 해당 위치를 이미 확인했거나 식량 큐브가 위치한 경우 다음 위치를 순회
				if (isFoodCube[nx][ny][nz])
					continue;
				
				// offer() 메서드를 사용해 해당 위치를 cubeList에 추가 후 해당 위치 확인 처리
				cubeList.offer(new Cube(nx, ny, nz));
				isFoodCube[nx][ny][nz] = true;
			}
		}
		
		// 해당 공간이 구멍인지 여부를 반환
		return isHole;
	}
}