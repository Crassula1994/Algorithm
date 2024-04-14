package gold4.num02110;

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
	
	// 집과 공유기의 개수를 저장할 각 변수 초기화
	static int houseNum;
	static int routerNum;
	
	// 집의 좌표를 저장할 배열 houses 초기화
	static int[] houses;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 집과 공유기의 개수를 각 변수에 할당
		houseNum = Integer.parseInt(st.nextToken());
		routerNum = Integer.parseInt(st.nextToken());
		
		// 집의 좌표를 저장할 배열 houses 초기화
		houses = new int[houseNum];
		
		// for 반복문을 사용해 입력 받은 집의 좌표를 배열 houses에 저장
		for (int idx = 0; idx < houses.length; idx++)
			houses[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 입력 받은 집의 좌표를 오름차순으로 정렬
		Arrays.sort(houses);
		
		// routerInstaller() 메서드를 호출해 인접한 두 공유기 사이의 최대 거리를 변수 maxDistance에 할당
		int maxDistance = routerInstaller();
		
		// valueOf() 및 write() 메서드를 사용해 인접한 두 공유기 사이의 최대 거리를 출력
		out.write(String.valueOf(maxDistance));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// routerInstaller() 메서드 정의
	public static int routerInstaller() {
		
		// 이분탐색을 위해 필요한 구간의 양끝 값을 저장할 각 변수 초기화
		int start = 1;
		int end = houses[houseNum - 1] - houses[0] + 1;
		
		// while 반복문을 사용해 값을 찾을 때까지 순회
		while (start < end) {
			
			// 이분탐색을 위해 필요한 중간값인 mid 변수 초기화
			int mid = (start + end) / 2;
			
			// 설치할 수 있는 공유기의 개수가 전체 공유기의 개수보다 크거나 같은 경우 구간의 왼쪽 끝을 갱신
			if (routerCounter(mid) >= routerNum) {
				start = mid + 1;
				
			// 설치할 수 있는 공유기의 개수가 전체 공유기의 개수보다 작은 경우 구간의 오른쪽 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// 두 공유기 사이의 최대 거리를 반환
		return start - 1;
	}

	// ----------------------------------------------------------------------------------------------------
	
	// routerCounter() 메서드 정의
	public static int routerCounter(int distance) {
		
		// 설치한 공유기의 개수, 이전에 설치한 공유기의 위치를 저장할 각 변수 초기화
		int count = 1;
		int prevRouter = houses[0];
		
		// for 반복문을 사용해 각 집의 위치를 순회
		for (int idx = 1; idx < houses.length; idx++) {
			
			// 공유기를 설치할 수 있는 거리가 아닌 경우 다음 집을 순회
			if (prevRouter + distance > houses[idx])
				continue;
			
			// 설치한 공유기의 개수 및 이전에 설치한 공유기의 위치를 갱신
			count++;
			prevRouter = houses[idx];
		}
		
		// 설치할 수 있는 공유기의 개수를 반환
		return count;
	}
}