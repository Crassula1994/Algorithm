package silver3.num02910;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Number 클래스 정의
	public static class Number {
		
		// 각 숫자, 등장 횟수, 나온 순서를 저장할 각 변수 초기화
		int value;
		int count = 1;
		int order;
		
		// 인자를 입력 받는 생성자 정의
		public Number(int value, int order) {
			this.value = value;
			this.order = order;
		}
	}

	// main() 메서드 정의
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 메시지의 길이 및 최대 숫자를 각 변수에 할당
		int msgLen = Integer.parseInt(st.nextToken());
		int maxNum = Integer.parseInt(st.nextToken());
		
		// 각 숫자를 저장할 Map 객체 counter 초기화
		Map<Integer, Number> counter = new HashMap<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// 각 숫자의 등장 순서를 저장할 변수 order 초기화
		int order = 0;
		
		// for 반복문을 사용해 각 메시지의 숫자를 순회
		for (int m = 0; m < msgLen; m++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 메시지의 숫자를 변수 number에 할당
			int number = Integer.parseInt(st.nextToken());
			
			// 해당 숫자가 이미 counter에 있는 경우 개수를 갱신
			if (counter.containsKey(number)) {
				counter.get(number).count++;
			
			// 해당 숫자가 counter에 없는 경우 해당 숫자를 추가
			} else {
				counter.put(number, new Number(number, ++order));
			}
		}
		
		// 각 숫자의 개수를 차례로 출력할 PriorityQueue 객체 numberPrinter 초기화
		PriorityQueue<Number> numberPrinter = new PriorityQueue<>((n1, n2) -> {
			return (n1.count == n2.count) ? n1.order - n2.order : n2.count - n1.count;
		});
		
		// for 반복문을 사용해 counter의 모든 숫자를 numberPrinter에 추가
		for (int key : counter.keySet())
			numberPrinter.offer(counter.get(key));
		
		// while 반복문을 사용해 numberPrinter가 빌 때까지 순회
		while (!numberPrinter.isEmpty()) {
			
			// poll() 메서드를 사용해 현재 출력할 숫자를 변수 number에 할당
			Number number = numberPrinter.poll();
			
			// for 반복문을 사용해 해당 숫자를 출력
			for (int c = 0; c < number.count; c++)
				out.write(number.value + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}