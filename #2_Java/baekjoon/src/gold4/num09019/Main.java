package gold4.num09019;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 각 숫자가 계산되었는지 여부를 저장할 배열 calculated 초기화
	static String[] calculated;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 레지스터의 초기 값과 최종 값을 각 변수에 할당
			int initialVal = Integer.parseInt(st.nextToken());
			int finalVal = Integer.parseInt(st.nextToken());
			
			// 각 숫자가 계산되었는지 여부를 저장할 배열 calculated 초기화
			calculated = new String[10000];
			
			// commandFinder() 메서드를 호출해 필요한 최소한의 명령어 나열을 찾아 변수 shortCommand에 갱신
			commandFinder(initialVal, finalVal);
			
			// write() 메서드를 사용해 필요한 최소한의 명령어 나열을 출력
			out.write(calculated[finalVal] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// commandFinder() 메서드 정의 
	public static void commandFinder(int initialVal, int finalVal) {
		
		// 다음에 계산할 위치를 저장할 Queue 객체 calculationList 초기화
		Queue<Integer> calculationList = new LinkedList<>();
		
		// offer() 메서드를 사용해 입력 받은 초기 값을 calculationList에 추가 및 방문 처리
		calculationList.offer(initialVal);
		calculated[initialVal] = "";
		
		// while 반복문을 사용해 calculationList가 빌 때까지 순회
		while (!calculationList.isEmpty()) {
			
			// poll() 메서드를 사용해 계산할 값을 변수 currentVal에 할당
			int currentVal = calculationList.poll();
			
			// 해당 값이 최종 결과와 동일한 경우 반복문 탈출
			if (currentVal == finalVal)
				break;

			// 각 명령어를 수행한 결과를 각 변수에 할당
			int resultD = (2 * currentVal) % 10000;
			int resultS = (currentVal == 0) ? 9999 : currentVal - 1;
			int resultL = (currentVal % 1000) * 10 + currentVal / 1000;
			int resultR = (currentVal / 10) + (currentVal % 10) * 1000;
			
			// 'D' 명령어를 수행한 결과를 계산한 적이 없는 경우
			if (calculated[resultD] == null) {
				
				// offer() 메서드를 사용해 계산 결과를 calculationList에 추가 및 방문 처리
				calculationList.offer(resultD);
				calculated[resultD] = calculated[currentVal] + "D";
			}
			
			// 'S' 명령어를 수행한 결과를 계산한 적이 없는 경우
			if (calculated[resultS] == null) {
				
				// offer() 메서드를 사용해 계산 결과를 calculationList에 추가 및 방문 처리
				calculationList.offer(resultS);
				calculated[resultS] = calculated[currentVal] + "S";
			}
			
			// 'L' 명령어를 수행한 결과를 계산한 적이 없는 경우
			if (calculated[resultL] == null) {
				
				// offer() 메서드를 사용해 계산 결과를 calculationList에 추가 및 방문 처리
				calculationList.offer(resultL);
				calculated[resultL] = calculated[currentVal] + "L";
			}
			
			// 'S' 명령어를 수행한 결과를 계산한 적이 없는 경우
			if (calculated[resultR] == null) {
				
				// offer() 메서드를 사용해 계산 결과를 calculationList에 추가 및 방문 처리
				calculationList.offer(resultR);
				calculated[resultR] = calculated[currentVal] + "R";
			}
		}
	}
}