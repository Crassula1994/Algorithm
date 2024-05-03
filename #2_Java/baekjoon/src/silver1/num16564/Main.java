package silver1.num16564;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 캐릭터의 레벨을 저장할 배열 characters 초기화
	static int[] characters;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 캐릭터의 개수 및 올릴 수 있는 레벨의 총합을 각 변수에 할당
		int characterNum = Integer.parseInt(st.nextToken());
		int levelLimit = Integer.parseInt(st.nextToken());
		
		// 캐릭터의 최소 레벨을 저장할 변수 minLevel 초기화
		int minLevel = Integer.MAX_VALUE;
		
		// 각 캐릭터의 레벨을 저장할 배열 characters 초기화
		characters = new int[characterNum];
		
		// for 반복문을 사용해 각 캐릭터를 순회
		for (int idx = 0; idx < characters.length; idx++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 각 캐릭터의 레벨을 배열 characters에 저장
			characters[idx] = Integer.parseInt(in.readLine());
			
			// min() 메서드를 사용해 캐릭터의 최소 레벨을 갱신
			minLevel = Math.min(characters[idx], minLevel);
		}
		
		// 이분탐색을 위해 필요한 구간의 시작과 끝을 나타낼 각 변수 초기화
		long start = minLevel;
		long end = minLevel + levelLimit + 1;
		
		// while 반복문을 사용해 가능한 팀 목표 레벨을 찾을 때까지 순회
		while (start < end) {
			
			// 이분탐색을 위해 필요한 중간값을 계산해 변수 mid에 할당
			long mid = (start + end) / 2;
			
			// levelCalculator() 메서드를 호출해 필요한 레벨을 변수 levelNeeded에 할당
			long levelNeeded = levelCalculator(mid, levelLimit);
			
			// 필요한 레벨이 올릴 수 있는 레벨의 총합보다 같거나 작은 경우 구간의 시작을 갱신
			if (levelNeeded <= levelLimit) {
				start = mid + 1;
				
			// 필요한 레벨이 올릴 수 있는 레벨의 총합보다 큰 경우 구간의 끝을 갱신
			} else {
				end = mid;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 가능한 팀 목표 레벨을 출력
		out.write(String.valueOf(end - 1));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// levelCalculator() 메서드 정의
	public static long levelCalculator(long targetLevel, int levelLimit) {
		
		// 목표 레벨을 맞추기 위해 필요한 레벨을 저장할 변수 levelNeeded 초기화
		long levelNeeded = 0;
		
		// for 반복문을 사용해 각 캐릭터의 레벨을 순회
		for (int idx = 0; idx < characters.length; idx++) {
			
			// 올릴 수 있는 레벨의 총합을 초과한 경우 반복문 탈출
			if (levelNeeded > levelLimit)
				break;
			
			// 해당 레벨이 목표 레벨보다 낮은 경우 목표 레벨을 맞추기 위해 필요한 레벨을 갱신
			if (characters[idx] < targetLevel)
				levelNeeded += targetLevel - characters[idx];
		}
		
		// 목표 레벨을 맞추기 위해 필요한 레벨을 반환
		return levelNeeded;
	}
}