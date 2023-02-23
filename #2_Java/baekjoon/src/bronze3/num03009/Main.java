package bronze3.num03009;

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
		
		// 입력 받은 각 좌표의 개수를 저장할 Map 객체 초기화
		Map<Integer, Integer> coordinateX = new HashMap<>();
		Map<Integer, Integer> coordinateY = new HashMap<>();
		
		// for 반복문을 사용해 세 개의 좌표를 순회
		for (int i = 0; i < 3; i++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 좌표를 각 변수에 할당
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// X 좌표의 값이 이미 존재하는 경우 개수 조정
			if (coordinateX.containsKey(x)) {
				coordinateX.replace(x, 2);
				
			// X 좌표의 값이 존재하지 않는 경우 개수 초기화
			} else {
				coordinateX.put(x, 1);
			}

			// Y 좌표의 값이 이미 존재하는 경우 개수 조정
			if (coordinateY.containsKey(y)) {
				coordinateY.replace(y, 2);
				
			// X 좌표의 값이 존재하지 않는 경우 개수 초기화
			} else {
				coordinateY.put(y, 1);
			}
		}
		
		// for 반복문을 사용해 X좌표의 모든 키의 값을 순회
		for (int key : coordinateX.keySet()) {
			
			// 해당 값이 1개만 존재하는 경우 출력 후 반복문 탈출
			if (coordinateX.get(key).equals(1)) {
				out.write(key + " ");
				break;
			}
		}
		
		// for 반복문을 사용해 Y좌표의 모든 키의 값을 순회
		for (int key : coordinateY.keySet()) {
			
			// 해당 값이 1개만 존재하는 경우 출력 후 반복문 탈출
			if (coordinateY.get(key).equals(1)) {
				out.write(String.valueOf(key));
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}