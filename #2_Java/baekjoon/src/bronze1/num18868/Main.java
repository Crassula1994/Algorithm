package bronze1.num18868;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
		
		// 각 우주의 상대적인 행성의 크기를 저장할 2차원 배열 multiverse 초기화
		int[][] multiverse = new int[universeNum][planetNum];
		
		// for 반복문을 사용해 각 우주를 순회
		for (int universe = 0; universe < universeNum; universe++) {
			
			// 각 행성의 크기를 저장할 Set 객체 planetSizes 초기화
			Set<Integer> planetSizes = new HashSet<>();
			
			// 해당 우주의 각 행성의 크기를 순서대로 저장할 배열 planets 초기화
			int[] planets = new int[planetNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 행성의 크기를 순회
			for (int idx = 0; idx < planets.length; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행성의 크기를 배열 planets에 저장
				planets[idx] = Integer.parseInt(st.nextToken());
				
				// add() 메서드를 사용해 각 행성의 크기를 planetSizes에 추가
				planetSizes.add(planets[idx]);
			}
			
			// 행성의 크기를 순서대로 정렬할 List 객체 planetRanks 초기화
			List<Integer> planetRanks = new ArrayList<>(planetSizes);
			
			// sort() 메서드를 사용해 행성의 크기를 오름차순으로 정렬
			Collections.sort(planetRanks);
			
			// for 반복문을 사용해 상대적인 행성의 크기를 2차원 배열 multiverse에 저장
			for (int idx = 0; idx < planetNum; idx++)
				multiverse[universe][idx] = Collections.binarySearch(planetRanks, planets[idx]);
		}
		
		// for 반복문을 사용해 각 우주의 쌍을 순회
		for (int universeA = 0; universeA < universeNum - 1; universeA++) {
			for (int universeB = universeA + 1; universeB < universeNum; universeB++) {
				
				// 해당 쌍이 균등한 우주의 쌍인 경우 균등한 우주의 쌍의 개수를 갱신
				if (Arrays.equals(multiverse[universeA], multiverse[universeB]))
					pairCount++;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 균등한 우주의 쌍의 개수를 출력
		out.write(String.valueOf(pairCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}