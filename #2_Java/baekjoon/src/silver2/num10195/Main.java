package silver2.num10195;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 터널의 깊이와 길이를 저장할 각 변수 초기화
	static int depth;
	static int length;
	
	// 각 터널에 위치한 석순의 크기를 저장할 배열 stalagmites 초기화
	static int[] stalagmites;
	
	// 루시의 자동차가 이동하는 방향을 저장할 Map 객체 directions 초기화
	static Map<Character, Integer> directions = new HashMap<>();
	
	// put() 메서드를 사용해 루시의 자동차가 이동하는 방향을 directions에 저장
	static {
		directions.put('^', -1);
		directions.put('>', 0);
		directions.put('v', 1);
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 첫 번째 테스트 케이스가 아닌 경우 빈 줄을 제거
			if (tc > 1)
				in.readLine();
			
			// foramt() 및 write() 메서드를 사용해 테스트 케이스의 번호를 출력
			out.write(String.format("Case: %d\n", tc));
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 터널의 깊이와 길이를 각 변수에 할당
			st.nextToken();
			st.nextToken();
			depth = Integer.parseInt(st.nextToken());
			st.nextToken();
			length = Integer.parseInt(st.nextToken());
			
			// 각 터널에 위치한 석순의 크기를 저장할 배열 stalagmites 초기화
			stalagmites = new int[length];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 석순의 개수를 변수 stalagmiteNum에 할당
			int stalagmiteNum = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 각 석순의 정보를 순회
			while (stalagmiteNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 석순의 정보를 각 변수에 할당
				int size = Integer.parseInt(st.nextToken());
				st.nextToken();
				st.nextToken();
				int distance = Integer.parseInt(st.nextToken());
				
				// 해당 석순의 정보를 배열 stalagmites에 저장
				stalagmites[distance] = size;
			}
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 동작 순서의 개수를 변수 sequenceNum에 할당
			int sequenceNum = Integer.parseInt(st.nextToken());
			
			// while 반복문을 사용해 각 동작 순서를 순회
			while (sequenceNum-- > 0) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 메서드를 사용해 입력 받은 동작 순서를 변수 sequence에 할당
				String sequence = st.nextToken();
				
				// sequenceSimulator(), format(), write() 메서드를 사용해 해당 동작 순서의 결과를 정해진 형식대로 출력
				out.write(String.format("Sequence %s %s\n", sequence, sequenceSimulator(sequence)));
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// sequenceSimulator() 메서드 정의
	public static String sequenceSimulator(String sequence) {
		
		// for 반복문을 사용해 각 위치를 순회
		for (int idx = 0, curDepth = 0; idx < sequence.length(); idx++) {
			
			// charAt() 및 get() 메서드를 사용해 루시의 자동차가 위치한 깊이를 갱신
			curDepth += directions.get(sequence.charAt(idx));
			
			// 루시의 자동차가 터널의 천장에 충돌한 경우 'Crashed into tunnel ceiling' 반환
			if (curDepth < 0)
				return "Crashed into tunnel ceiling";
			
			// 루시의 자동차가 터널의 바닥에 충돌한 경우 'Crashed into tunnel floor' 반환
			if (curDepth >= depth)
				return "Crashed into tunnel floor";
			
			// 루시의 자동차가 석순에 충돌한 경우 'Crashed into stalagmite' 반환
			if (curDepth >= depth - stalagmites[idx + 1])
				return "Crashed into stalagmite";
		}
		
		// 터널의 끝에 무사히 도달할 수 있는 경우 'Reached end of tunnel' 반환
		return "Reached end of tunnel";
	}
}