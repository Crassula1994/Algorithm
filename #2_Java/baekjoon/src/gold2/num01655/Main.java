package gold2.num01655;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 백준이가 외치는 정수의 개수를 변수 numberCnt에 할당
		int numberCnt = Integer.parseInt(in.readLine());
		
		// 백준이가 외치는 정수를 반으로 나누어 저장할 각 PrirorityQueue 객체 초기화
		PriorityQueue<Integer> highNumbers = new PriorityQueue<>();
		PriorityQueue<Integer> lowNumbers = new PriorityQueue<>((n1, n2) -> {
			return n2 - n1;
		});
		
		// for 반복문을 사용해 각 정수를 순회
		for (int n = 0; n < numberCnt; n++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 백준이가 외치는 정수를 변수 number에 할당
			int number = Integer.parseInt(in.readLine());
			
			// 첫 숫자인 경우 아래쪽 절반에 저장
			if (lowNumbers.isEmpty()) {
				lowNumbers.offer(number);
				
			// 정수가 정확히 반씩 저장되어 있는 경우
			} else if (highNumbers.size() == lowNumbers.size()) {
				
				// 백준이가 외친 정수가 아래쪽 절반에 저장된 숫자 중 가장 큰 숫자보다 더 큰 경우
				if (number > lowNumbers.peek()) {
					
					// offer() 메서드를 사용해 해당 숫자를 위쪽 절반에 저장
					highNumbers.offer(number);
					
					// poll() 및 offer() 메서드를 사용해 위쪽 절반에서 가장 작은 숫자를 아래쪽 절반에 저장
					lowNumbers.offer(highNumbers.poll());
					
				// 백준이가 외친 정수가 아래쪽 절반에 저장된 숫자 중 가장 큰 숫자보다 더 작거나 같은 경우 아래쪽 절반에 저장
				} else {
					lowNumbers.offer(number);
				}
			
			// 정수가 아래쪽 절반에 더 많이 저장되어 있는 경우
			} else {
				
				// 백준이가 외친 정수가 아래쪽 절반에 저장된 숫자 중 가장 큰 숫자보다 더 크거나 같은 경우 위쪽 절반에 저장
				if (number >= lowNumbers.peek()) {
					highNumbers.offer(number);
					
				// 백준이가 외친 정수가 아래쪽 절반에 저장된 숫자 중 가장 큰 숫자보다 더 작은 경우
				} else {
					
					// offer() 메서드를 사용해 해당 숫자를 아래쪽 절반에 저장
					lowNumbers.offer(number);
					
					// poll() 및 offer() 메서드를 사용해 아래쪽 절반에서 가장 큰 숫자를 위쪽 절반에 저장
					highNumbers.offer(lowNumbers.poll());
				}
			}
			
			// peek() 및 write() 메서드를 사용해 현재 정수의 중간 값을 출력
			out.write(lowNumbers.peek() + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}