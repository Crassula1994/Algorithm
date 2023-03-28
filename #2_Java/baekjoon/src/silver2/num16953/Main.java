package silver2.num16953;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 숫자를 각 변수에 할당
		int startNum = Integer.parseInt(st.nextToken());
		int targetNum = Integer.parseInt(st.nextToken());
		
		// calcCounter() 메서드를 호출해 숫자를 목표로 하는 숫자로 바꾸는 데 필요한 연산의 최솟값을 변수 minCount에 할당
		int minCount = calcCounter(startNum, targetNum);
		
		// valueOf() 및 write() 메서드를 사용해 연산의 최솟값을 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// calcCounter() 메서드 정의 
	public static int calcCounter(int startNum, int targetNum) {
		
		// 다음에 방문할 위치를 저장할 Queue 객체 visitList 초기화
		Queue<Integer> visitList = new LinkedList<>();
		
		// 연산 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// offer() 메서드를 사용해 시작 위치를 visitList에 추가
		visitList.offer(startNum);
		
		// while 반복문을 사용해 visitList가 빌 때까지 순회
		while (!visitList.isEmpty()) {
			
			// 현재 visitList의 원소의 크기를 변수 size에 할당
			int size = visitList.size();
			
			// for 반복문을 사용해 연산 횟수가 같은 결과를 순회
			for (int n = 0; n < size; n++) {
				
				// poll() 메서드를 사용해 현재 방문 중인 위치를 변수 currentNum에 할당
				int currentNum = visitList.poll();
				
				// 해당 위치가 목표로 하는 숫자인 경우 연산 횟수 반환
				if (currentNum == targetNum)
					return count + 1;
				
				// 각 연산의 결과를 각 변수에 할당
				int nextNum1 = currentNum * 2;
				long nextNum2 = currentNum * 10L + 1L;
				
				// 2를 곱하는 연산 결과가 범위를 벗어나지 않는 경우 해당 위치를 visitList에 추가
				if (nextNum1 <= targetNum)
					visitList.offer(nextNum1);
				
				// 가장 오른쪽에 1을 추가하는 연산 결과가 범위를 벗어나지 않는 경우 해당 위치를 visitList에 추가
				if (nextNum2 <= targetNum)
					visitList.offer((int) nextNum2);
			}
			
			// 연산 횟수 갱신
			count++;
		}
		
		// 목표로 하는 숫자를 만들지 못하는 경우 -1 반환
		return -1;
	}
}