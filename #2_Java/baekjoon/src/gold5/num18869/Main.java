package gold5.num18869;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 우주의 개수와 행성의 개수를 각 변수에 할당
		int universeNum = Integer.parseInt(st.nextToken());
		int planetNum = Integer.parseInt(st.nextToken());
		
		// 균등한 우주의 쌍의 개수를 저장할 변수 pairCount 초기화
		int pairCount = 0;
		
		// 각 균등한 우주의 개수를 저장할 Map 객체 multiverse 초기화
		Map<Integer, Integer> multiverse = new HashMap<>();
		
		// for 반복문을 사용해 각 우주를 순회
		for (int universe = 0; universe < universeNum; universe++) {

			// 해당 우주의 각 행성의 크기를 순서대로 저장할 배열 planets 초기화
			int[] planets = new int[planetNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 행성의 크기를 배열 planets에 저장
			for (int idx = 0; idx < planets.length; idx++)
				planets[idx] = Integer.parseInt(st.nextToken());
			
			// clone() 메서드를 사용해 행성의 크기를 순서대로 정렬할 배열 planetRanks 초기화
			int[] planetRanks = planets.clone();
			
			// sort() 메서드를 사용해 행성의 크기를 오름차순으로 정렬
			Arrays.sort(planetRanks);
			
			// for 반복문을 사용해 상대적인 행성의 크기를 배열 planets에 저장
			for (int idx = 0; idx < planetNum; idx++)
				planets[idx] = Arrays.binarySearch(planetRanks, planets[idx]);
			
			// hashCode() 메서드를 사용해 해당 우주의 행성의 배열 상태를 변수 universeType에 저장
			int universeType = Arrays.hashCode(planets);
			
			// getOrDefault() 및 put() 메서드를 사용해 각 균등한 우주의 개수를 multiverse에 저장
			multiverse.put(universeType, multiverse.getOrDefault(universeType, 0) + 1);
		}
		
		// for 반복문을 사용해 각 균등한 우주의 개수를 순회
		for (int count : multiverse.values()) {
			
			// 균등한 우주가 2개 이상 존재하는 경우 균등한 우주의 쌍의 개수를 갱신
			if (count > 1)
				pairCount += count * (count - 1) / 2;
		}
		
		// valueOf() 및 write() 메서드를 사용해 균등한 우주의 쌍의 개수를 출력
		out.write(String.valueOf(pairCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}