package gold4.num17298;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// Element 클래스 정의
	public static class Element {
		
		// 수열의 원소의 인덱스와 그 값을 저장할 각 변수 초기화
		int index;
		int value;
		
		// 매개변수를 입력 받는 생성자 정의
		public Element(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 크기를 변수 size에 할당
		int size = Integer.parseInt(in.readLine());
		
		// 오큰수를 저장할 배열 nextGreaterElement 초기화
		int[] nextGreaterElement = new int[size];
		
		// 오큰수를 찾을 Stack 객체 elementFinder 초기화
		Stack<Element> elementFinder = new Stack<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 수열의 각 원소를 순회
		for (int idx = 0; idx < size; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 해당 수열의 원소를 변수 element에 할당
			int element = Integer.parseInt(st.nextToken());
			
			// elementFinder가 비어 있거나 가장 마지막에 저장된 값보다 해당 원소가 작거나 같은 경우
			if (elementFinder.isEmpty() || elementFinder.peek().value >= element) {
				
				// push() 메서드를 사용해 해당 원소를 elementFinder에 추가
				elementFinder.push(new Element(idx, element));
				
				// 다음 원소를 순회
				continue;
			}
			
			// while 반복문을 사용해 elementFinder가 빌 때까지 순회
			while (!elementFinder.isEmpty()) {
				
				// 가장 마지막에 저장된 값보다 해당 원소가 작거나 같은 경우 반복문 탈출
				if (elementFinder.peek().value >= element)
					break;
				
				// pop() 메서드를 사용해 해당 원소보다 작은 이전 원소를 변수 prevElement에 할당
				Element prevElement = elementFinder.pop();
				
				// 해당 원소의 오큰수를 갱신
				nextGreaterElement[prevElement.index] = element;
			}
			
			// push() 메서드를 사용해 해당 원소를 elementFinder에 추가
			elementFinder.push(new Element(idx, element));
		}
		
		// for 반복문을 사용해 각 인덱스의 오큰수를 순회
		for (int idx = 0; idx < size; idx++) {
			
			// 오큰수가 존재하지 않는 경우 -1을 출력
			if (nextGreaterElement[idx] == 0) {
				out.write(-1 + " ");
				
			// 오큰수가 존재하는 경우 오큰수를 출력
			} else {
				out.write(nextGreaterElement[idx] + " ");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}