package gold4.num07662;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 데이터의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 데이터를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 연산의 개수를 변수 calcNum에 할당
			int calcNum = Integer.parseInt(in.readLine());
			
			// TreeMap 객체 dualPriorityQueue 초기화
			TreeMap<Integer, Integer> dualPriorityQueue = new TreeMap<>();
			
			// for 반복문을 사용해 각 연산을 순회
			for (int c = 0; c < calcNum; c++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken(), charAt(), parseInt() 메서드를 사용해 입력 받은 연산의 종류 및 정수를 각 변수에 할당
				char calculation = st.nextToken().charAt(0);
				int number = Integer.parseInt(st.nextToken());
				
				// switch 조건문을 사용해 각 연산을 수행
				switch (calculation) {
				
					// 'D'가 입력된 경우
					case 'D':
						
						// dualPriorityQueue가 빈 경우 다음 명령어를 순회
						if (dualPriorityQueue.isEmpty()) {
							continue;
						
						// dualPriorityQueue가 비어 있지 않고, 최댓값을 삭제하는 연산인 경우
						} else if (number == 1) {
							
							// lastKey() 메서드를 사용해 최댓값을 지니는 정수를 변수 maxVal에 할당
							int maxVal = dualPriorityQueue.lastKey();
							
							// get() 메서드를 사용해 해당 값의 개수를 변수 count에 할당
							int count = dualPriorityQueue.get(maxVal);
							
							// 해당 값의 개수가 1개인 경우 해당 값을 dualPriorityQueue에서 제거
							if (count == 1) {
								dualPriorityQueue.remove(maxVal);
								
							// 해당 값의 개수가 1개 이상인 경우 해당 값의 개수를 갱신
							} else {
								dualPriorityQueue.put(maxVal, count - 1);
							}
						
						// dualPriorityQueue가 비어 있지 않고, 최솟값을 삭제하는 연산인 경우
						} else {
							
							// firstKey() 메서드를 사용해 최솟값을 지니는 정수를 변수 minVal에 할당
							int minVal = dualPriorityQueue.firstKey();
							
							// get() 메서드를 사용해 해당 값의 개수를 변수 count에 할당
							int count = dualPriorityQueue.get(minVal);
							
							// 해당 값의 개수가 1개인 경우 해당 값을 dualPriorityQueue에서 제거
							if (count == 1) {
								dualPriorityQueue.remove(minVal);
								
							// 해당 값의 개수가 1개 이상인 경우 해당 값의 개수를 갱신
							} else {
								dualPriorityQueue.put(minVal, count - 1);
							}
						}
						
						// 조건문 탈출
						break;
					
					// 'I'가 입력된 경우
					default:
						
						// getOrDefault() 및 put() 메서드를 사용해 dualPriorityQueue에 정수 추가
						dualPriorityQueue.put(number, dualPriorityQueue.getOrDefault(number, 0) + 1);
				}
			}
			
			// dualPriorityQueue가 빈 경우 'EMPTY' 출력
			if (dualPriorityQueue.isEmpty()) {
				out.write("EMPTY" + "\n");
				
			// dualPriorityQueue가 비지 않은 경우 최댓값과 최솟값 출력
			} else {
				out.write(dualPriorityQueue.lastKey() + " " + dualPriorityQueue.firstKey() + "\n");
			}
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}