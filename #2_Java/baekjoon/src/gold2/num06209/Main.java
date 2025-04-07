package gold2.num06209;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 돌섬이 있는 위치를 저장할 배열 islands 초기화
	static int[] islands;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		/* nextToken() 및 parseInt() 메서드를 사용해 입력 받은 갇힌 돌섬으로부터 탈출구까지의 거리, 작은 돌섬의 수,
		제거할 수 있는 작은 돌섬의 수를 각 변수에 할당 */
		int totalDistance = Integer.parseInt(st.nextToken());
		int islandNum = Integer.parseInt(st.nextToken());
		int removeLimit = Integer.parseInt(st.nextToken());
		
		// 점프할 최소 거리의 최댓값 및 해당 값을 찾기 위한 범위를 나타낼 각 변수 초기화
		int minDistance = 0;
		int start = 0;
		int end = totalDistance + 1;
		
		// 각 돌섬이 있는 위치를 저장할 배열 islands 초기화
		islands = new int[islandNum + 2];
		
		// for 반복문을 사용해 입력 받은 각 돌섬이 있는 위치를 배열 islands에 저장
		for (int idx = 1; idx <= islandNum; idx++)
			islands[idx] = Integer.parseInt(in.readLine());
		
		// 탈출구를 배열 islands에 저장
		islands[islandNum + 1] = totalDistance;
		
		// sort() 메서드를 사용해 각 돌섬이 있는 위치를 오름차순으로 정렬
		Arrays.sort(islands);
		
		// while 반복문을 사용해 점프할 최소 거리의 최댓값을 찾을 때까지 순회
		while (start < end) {
			
			// 점프할 최소 거리를 찾기 위한 범위의 중간값을 계산해 변수 mid에 할당
			int mid = (start + end) / 2;
			
			// islandRemover() 메서드를 호출해 제거한 돌섬의 개수를 변수 removeCount에 할당
			int removeCount = islandRemover(mid);
			
			// 제거한 돌섬의 개수가 제거할 수 있는 작은 돌섬의 수 이하인 경우 범위의 처음과 점프할 최소 거리의 최댓값을 갱신
			if (removeCount <= removeLimit) {
				start = mid + 1;
				minDistance = mid;
				
			// 제거한 돌섬의 개수가 제거할 수 있는 작은 돌섬의 수 초과인 경우 범위의 마지막을 갱신
			} else {
				end = mid;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 점프할 최소 거리의 최댓값을 출력
		out.write(String.valueOf(minDistance));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// islandRemover() 메서드 정의
	public static int islandRemover(int distance) {
		
		// 제거한 돌섬의 개수를 저장할 변수 removeCount 초기화
		int removeCount = 0;
		
		// for 반복문을 사용해 각 돌섬을 순회
		for (int cur = 1, prev = 0; cur < islands.length; cur++) {
			
			// 현재 돌섬과 이전 돌섬의 거리가 점프할 최소 거리 이상인 경우 이전 돌섬을 갱신 후 다음 돌섬을 순회
			if (islands[cur] - islands[prev] >= distance) {
				prev = cur;
				continue;
			}
			
			// 제거한 돌섬의 개수를 갱신
			removeCount++;
		}
		
		// 제거한 돌섬의 개수를 반환
		return removeCount;
	}
}