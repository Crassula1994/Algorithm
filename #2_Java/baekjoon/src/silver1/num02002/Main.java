package silver1.num02002;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 차의 대수를 변수 carNum에 할당
		int carNum = Integer.parseInt(in.readLine());
		
		// 대근이가 적은 차량 목록을 각각 저장할 Map 객체 entranceList 초기화
		Map<String, Integer> entranceList = new HashMap<>();
		
		// 영식이가 적은 차량 목록을 저장할 배열 exitList 초기화
		String[] exitList = new String[carNum];
		
		// for 반복문을 사용해 입력 받은 대근이가 적은 차량 목록을 entranceList에 추가
		for (int order = 1; order <= carNum; order++)
			entranceList.put(in.readLine(), order);
		
		// for 반복문을 사용해 입력 받은 영식이가 적은 차량 목록을 exitList에 저장
		for (int idx = 0; idx < exitList.length; idx++)
			exitList[idx] = in.readLine();

		// 터널 내부에서 반드시 추월을 했을 것으로 여겨지는 차의 대수를 저장할 변수 overtakeCnt 초기화
		int overtakeCnt = 0;
		
		// for 반복문을 사용해 대근이가 적은 차량 목록을 순회
		for (int i = 0; i < exitList.length - 1; i++) {
			
			// get() 메서드를 사용해 해당 차량의 터널 입구에서의 순서를 변수 currentOrder에 할당
			int currentOrder = entranceList.get(exitList[i]);
			
			// for 반복문을 사용해 대근이가 적은 차량 목록에서 해당 차량의 다음 차량을 순회
			for (int j = i + 1; j < exitList.length; j++) {
				
				// get() 메서드를 사용해 다음 차량의 터널 입구에서의 순서를 변수 nextOrder에 할당
				int nextOrder = entranceList.get(exitList[j]);
				
				// 해당 차량이 터널 내부에서 반드시 추월을 했을 것으로 여겨지는 차인 경우
				if (currentOrder > nextOrder) {
					
					// 터널 내부에서 반드시 추월을 했을 것으로 여겨지는 차의 대수 갱신 후 반복문 탈출
					overtakeCnt++;
					break;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 터널 내부에서 반드시 추월을 했을 것으로 여겨지는 차의 대수를 출력
		out.write(String.valueOf(overtakeCnt));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}