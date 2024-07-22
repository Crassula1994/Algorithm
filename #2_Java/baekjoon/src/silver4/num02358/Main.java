package silver4.num02358;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 점의 개수를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// 두 개 이상의 점을 지나면서 x축 또는 y축에 평행한 직선의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 x좌표 및 y좌표에 위치한 점의 개수를 저장할 각 Map 객체 초기화
		Map<Integer, Integer> countX = new HashMap<>();
		Map<Integer, Integer> countY = new HashMap<>();
		
		// for 반복문을 사용해 각 점을 순회
		for (int point = 0; point < pointNum; point++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 점의 좌표를 각 변수에 할당
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			
			// getOrDefault() 및 put() 메서드를 사용해 각 좌표에 위치한 점의 개수를 갱신
			countX.put(coordinateX, countX.getOrDefault(coordinateX, 0) + 1);
			countY.put(coordinateY, countY.getOrDefault(coordinateY, 0) + 1);
		}
		
		// for 반복문을 사용해 각 x좌표를 순회
		for (int coordinateX : countX.keySet()) {
			
			// 해당 x좌표에 존재하는 점이 2개 이상인 경우 두 개 이상의 점을 지나는 직선의 수를 갱신
			if (countX.get(coordinateX) >= 2)
				count++;
		}
		
		// for 반복문을 사용해 각 y좌표를 순회
		for (int coordinateY : countY.keySet()) {
			
			// 해당 y좌표에 존재하는 점이 2개 이상인 경우 두 개 이상의 점을 지나는 직선의 수를 갱신
			if (countY.get(coordinateY) >= 2)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 두 개 이상의 점을 지나면서 x축 또는 y축에 평행한 직선의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}