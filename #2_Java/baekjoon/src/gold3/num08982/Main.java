package gold3.num08982;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 꼭짓점의 개수를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// 수족관에 남아 있는 물의 양을 저장할 변수 remains 초기화
		int remains = 0;
		
		// 각 꼭짓점의 정보를 저장할 2차원 배열 points 초기화
		int[][] points = new int[pointNum][2];
		
		// for 반복문을 사용해 각 꼭짓점의 정보를 순회
		for (int idx = 0; idx < pointNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 세로줄 번호 및 가로줄 번호를 배열 points에 저장
			points[idx][0] = Integer.parseInt(st.nextToken());
			points[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// 수족관의 너비를 변수 width에 할당
		int width = points[pointNum - 1][0];
		
		// 수족관의 각 위치에서의 깊이와 빠져 나간 물의 양을 저장할 각 배열 초기화
		int[] depths = new int[width];
		int[] leakages = new int[width];
		
		// for 반복문을 사용해 각 수족관 바닥을 순회
		for (int idx = 1; idx < pointNum - 1; idx += 2) {
			
			// 해당 바닥의 시작과 끝 위치 및 깊이를 각 변수에 할당
			int start = points[idx][0];
			int end = points[idx + 1][0];
			int depth = points[idx][1];
			
			// for 반복문을 사용해 해당 수족관 바닥의 깊이를 배열 depths에 저장
			for (int loc = start; loc < end; loc++)
				depths[loc] = depth;
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 구멍의 개수를 변수 holeNum에 할당
		int holeNum = Integer.parseInt(in.readLine());
		
		// 각 구멍의 위치를 저장할 Set 객체 holes 초기화
		Set<Integer> holes = new HashSet<>();
		
		// while 반복문을 사용해 각 구멍의 위치를 순회
		while (holeNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken(), parseInt(), add() 메서드를 사용해 해당 구멍의 위치를 holes에 저장
			holes.add(Integer.parseInt(st.nextToken()));
		}
		
		// for 반복문을 사용해 각 수족관 바닥의 위치를 왼쪽에서 오른쪽으로 순회
		for (int idx = 0, surface = 0; idx < width; idx++) {
			
			// 해당 위치에 구멍이 있거나 현재 해수면의 위치가 현재 위치의 깊이보다 깊은 경우 현재 해수면의 위치를 갱신
			if (holes.contains(idx) || surface > depths[idx])
				surface = depths[idx];
			
			// 현재 위치에서 빠져 나간 물의 양을 갱신
			leakages[idx] = surface;
		}
		
		// for 반복문을 사용해 각 수족관 바닥의 위치를 오른쪽에서 왼쪽으로 순회
		for (int idx = width - 1, surface = leakages[width - 1]; idx >= 0; idx--) {
			
			// 해당 위치에 구멍이 있거나 현재 해수면의 위치가 현재 위치의 깊이보다 깊은 경우 현재 해수면의 위치를 갱신
			if (holes.contains(idx) || surface > depths[idx])
				surface = depths[idx];
			
			// max() 메서드를 사용해 현재 위치에서 빠져 나간 물의 양을 갱신
			leakages[idx] = Math.max(surface, leakages[idx]);
		}
		
		// for 반복문을 사용해 수족관에 남아 있는 물의 양를 순회
		for (int idx = 0; idx < width; idx++)
			remains += depths[idx] - leakages[idx];
		
		// valueOf() 및 write() 메서드를 사용해 수족관에 남아 있는 물의 양을 출력
		out.write(String.valueOf(remains));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}