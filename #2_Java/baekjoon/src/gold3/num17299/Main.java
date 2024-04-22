package gold3.num17299;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 수열의 각 원소와 그 오등큰수를 저장할 각 배열 초기화
		int[] sequence = new int[size];
		int[] nextGFE = new int[size];
		
		// 각 숫자의 등장 횟수를 저장할 Map 객체 counter 초기화
		Map<Integer, Integer> counter = new HashMap<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 수열의 원소를 순회
		for (int idx = 0; idx < sequence.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 원소를 배열 sequence에 저장
			sequence[idx] = Integer.parseInt(st.nextToken());
			
			// 해당 원소의 오등큰수를 초기화
			nextGFE[idx] = -1;
			
			// getOrDefault() 및 put() 메서드를 사용해 해당 원소의 개수를 갱신해 counter에 저장
			counter.put(sequence[idx], counter.getOrDefault(sequence[idx], 0) + 1);
		}
		
		// 각 원소의 오등큰수를 찾을 Stack 객체 elementFinder 초기화
		Stack<Integer> elementFinder = new Stack<>();
		
		// for 반복문을 사용해 수열의 각 원소를 순회
		for (int idx = 0; idx < sequence.length; idx++) {
			
			// elementFinder가 비어 있거나 이전의 원소의 오등큰수가 아닌 경우
			if (elementFinder.isEmpty() || counter.get(sequence[elementFinder.peek()]) >= counter.get(sequence[idx])) {
				
				// push() 메서드를 사용해 해당 원소의 인덱스를 elementFinder에 추가
				elementFinder.push(idx);
				
				// 다음 원소를 순회
				continue;
			}
				
			// while 반복문을 사용해 elementFinder가 빌 때까지 순회
			while (!elementFinder.isEmpty()) {
				
				// 이전의 원소의 오등큰수가 아닌 경우 반복문 탈출
				if (counter.get(sequence[elementFinder.peek()]) >= counter.get(sequence[idx]))
					break;
				
				// pop() 메서드를 사용해 오등큰수를 찾은 원소의 인덱스를 변수 prevIdx에 할당
				int prevIdx = elementFinder.pop();
				
				// 해당 원소의 오등큰수를 갱신
				nextGFE[prevIdx] = sequence[idx];
			}
			
			// push() 메서드를 사용해 해당 원소의 인덱스를 elementFinder에 추가
			elementFinder.push(idx);
		}
		
		// for 반복문을 사용해 각 원소의 오등큰수를 출력
		for (int idx = 0; idx < size; idx++)
			out.write(nextGFE[idx] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}