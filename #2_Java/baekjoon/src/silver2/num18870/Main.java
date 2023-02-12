package silver2.num18870;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 좌표의 수를 변수 cdNum에 저장
		int cdNum = Integer.parseInt(in.readLine());
		
		// 각 좌표를 저장할 배열 coordinates 초기화
		int[] coordinates = new int[cdNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 좌표를 순회
		for (int idx = 0; idx < cdNum; idx++)

			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 좌표를 배열 coordinates에 저장
			coordinates[idx] = Integer.parseInt(st.nextToken());	
		
		// copyOf() 메서드를 사용해 coordinates 배열을 복제해 배열 sortedArray에 할당
		int[] sortedArray = Arrays.copyOf(coordinates, cdNum);
		
		// sort() 메서드를 사용해 배열 sortedArray를 정렬
		Arrays.sort(sortedArray);
		
		// 각 좌표의 값을 축소한 값을 저장할 Map 객체 mapping 초기화
		Map<Integer, Integer> mapping = new HashMap<>();

		// for 반복문을 사용해 배열 sortedArray의 각 원소를 순회
		for (int idx = 0, newIdx = 0; idx < cdNum; idx++) {
			
			// 중복되는 값인 경우 다음 원소로 넘기기
			if (idx > 0 && sortedArray[idx] == sortedArray[idx - 1])
				continue;
			
			// put() 메서드를 사용해 mapping에 축소된 좌표 값을 추가덳
			mapping.put(sortedArray[idx], newIdx++);
		}
		
		// for 반복문을 사용해 배열 coordinates의 각 원소를 순회
		for (int idx = 0; idx < cdNum; idx++)
			
			// get() 및 write() 메서드를 사용해 축소된 좌표 값을 출력
			out.write(mapping.get(coordinates[idx]) + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}