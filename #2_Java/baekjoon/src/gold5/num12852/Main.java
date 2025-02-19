package gold5.num12852;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// 입력 받은 자연수를 저장할 변수 number 초기화
	static int number;
	
	// 1로부터 주어진 자연수를 만들기 위한 최소 연산의 횟수와 해당 값을 만들기 위한 이전의 값을 저장할 각 배열 초기화
	static Integer[] calculation;
	static Integer[] lastCalculated;
	
	// ----------------------------------------------------------------------------------------------------
			
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자연수를 변수 number에 할당
		number = Integer.parseInt(in.readLine());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder(String.valueOf(number));
		
		// 1로부터 주어진 자연수를 만들기 위한 최소 연산의 횟수와 해당 값을 만들기 위한 이전의 값을 저장할 각 배열 초기화
		calculation = new Integer[number + 1];
		lastCalculated = new Integer[number + 1];
		
		// calculator() 메서드를 호출해 주어진 자연수를 만들기 위한 최소 연산의 횟수 및 이전의 값을 갱신
		calculator();
		
		// write() 메서드를 사용해 해당 자연수를 만들기 위한 최소 연산의 횟수를 출력
		out.write(calculation[number] + "\n");
		
		// 해당 자연수를 만드는 방법에 포함되어 있는 수를 찾기 위한 변수 currentNum 초기화
		int currentNum = number;
		
		// while 반복문을 사용해 1에 도달할 때까지 순회
		while (lastCalculated[currentNum] != null) {
			
			// append() 메서드를 사용해 해당 위치의 이전의 값을 sb에 저장
			sb.append(" ").append(lastCalculated[currentNum]);
			
			// 다음 위치의 값을 갱신
			currentNum = lastCalculated[currentNum];
		}
		
		// toString() 및 write() 메서드를 사용해 해당 자연수를 만드는 방법에 포함되어 있는 수를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// calculator() 메서드 정의
	public static void calculator() {
		
		// 다음에 연산할 위치를 저장할 Queue 객체 calculateList 초기화
		Queue<Integer> calculateList = new LinkedList<>();
		
		// 계산을 시작하는 1의 최소 연산의 횟수를 갱신
		calculation[1] = 0;
		
		// offer() 메서드를 사용해 시작하는 위치를 calculateList에 추가
		calculateList.offer(1);

		// while 반복문을 사용해 calculateList가 빌 때까지 순회
		while (!calculateList.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 계산 중인 숫자를 변수 currentNum에 할당
			int currentNum = calculateList.poll();
			
			// 해당 위치가 목적지인 경우 반복문 탈출
			if (currentNum == number)
				break;
			
			// 해당 위치에 3을 곱해도 범위를 벗어나지 않고, 방문한 적이 없는 경우
			if (currentNum * 3 <= number && calculation[currentNum * 3] == null) {
				
				// 해당 위치의 최소 연산의 횟수 및 이전의 값을 갱신
				calculation[currentNum * 3] = calculation[currentNum] + 1;
				lastCalculated[currentNum * 3] = currentNum;
				
				// offer() 메서드를 사용해 해당 위치를 calculateList에 추가
				calculateList.offer(currentNum * 3);
			}
			
			// 해당 위치에 2을 곱해도 범위를 벗어나지 않고, 방문한 적이 없는 경우
			if (currentNum * 2 <= number && calculation[currentNum * 2] == null) {
				
				// 해당 위치의 최소 연산의 횟수 및 이전의 값을 갱신
				calculation[currentNum * 2] = calculation[currentNum] + 1;
				lastCalculated[currentNum * 2] = currentNum;
				
				// offer() 메서드를 사용해 해당 위치를 calculateList에 추가
				calculateList.offer(currentNum * 2);
			}
			
			// 해당 위치에 1을 더해도 범위를 벗어나지 않고, 방문한 적이 없는 경우
			if (currentNum + 1 <= number && calculation[currentNum + 1] == null) {
				
				// 해당 위치의 최소 연산의 횟수 및 이전의 값을 갱신
				calculation[currentNum + 1] = calculation[currentNum] + 1;
				lastCalculated[currentNum + 1] = currentNum;
				
				// offer() 메서드를 사용해 해당 위치를 calculateList에 추가
				calculateList.offer(currentNum + 1);
			}
		}
	}
}