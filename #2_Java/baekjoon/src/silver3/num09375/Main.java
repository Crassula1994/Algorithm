package silver3.num09375;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 의상의 수를 변수 clothesNum에 할당
			int clothesNum = Integer.parseInt(in.readLine());
			
			// 의상의 종류별 개수를 저장할 Map 객체 clothesCnt 초기화
			Map<String, Integer> clothesCnt = new HashMap<>();
			
			// 알몸이 아닌 채로 의상을 입을 수 있는 경우의 수를 저장할 변수 count 초기화
			int count = 1;
			
			// for 반복문을 사용해 각 의상을 순회
			for (int clothes = 0; clothes < clothesNum; clothes++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 메서드를 사용해 입력 받은 의상의 종류를 변수 type에 할당
				st.nextToken();
				String type = st.nextToken();
				
				// 해당 의상의 종류가 clothesCnt에 추가되어 있는 경우
				if (clothesCnt.containsKey(type)) {
					
					// get() 및 replace() 메서드를 사용해 개수를 갱신
					clothesCnt.replace(type, clothesCnt.get(type) + 1);
					
				// 해당 의상의 종류가 clothesCnt에 없는 경우 추가
				} else {
					clothesCnt.put(type, 2);
				}
			}
			
			// for 반복문 및 entrySet() 메서드를 사용해 각 의상을 종류별로 입는 경우의 수를 계산
			for (Map.Entry<String, Integer> entry : clothesCnt.entrySet())
				count *= entry.getValue();
				
			// write() 메서드를 사용해 알몸인 경우의 수를 제외하고 의상을 종류별로 입는 경우의 수 출력
			out.write(count - 1 + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}