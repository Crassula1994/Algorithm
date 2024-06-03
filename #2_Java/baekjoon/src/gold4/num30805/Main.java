package gold4.num30805;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 수열 A의 길이를 변수 lengthA에 할당
		int lengthA = Integer.parseInt(in.readLine());
		
		// 수열 A의 원소를 저장할 배열 sequenceA 초기화
		int[] sequenceA = new int[lengthA];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열 A의 원소를 배열 sequenceA에 저장
		for (int idx = 0; idx < sequenceA.length; idx++)
			sequenceA[idx] = Integer.parseInt(st.nextToken());
		
		// readLine() 및 parseInt() 메서드를 사용해 수열 B의 길이를 변수 lengthB에 할당
		int lengthB = Integer.parseInt(in.readLine());
		
		// 수열 B의 원소를 저장할 배열 sequenceB 초기화
		int[] sequenceB = new int[lengthB];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 수열 B의 원소를 배열 sequenceB에 저장
		for (int idx = 0; idx < sequenceB.length; idx++)
			sequenceB[idx] = Integer.parseInt(st.nextToken());
		
		// sequenceAnalyzer() 메서드를 호출해 각 숫자의 등장 인덱스를 저장한 각 배열에 할당
		Stack<Integer>[] numbersA = sequenceAnalyzer(sequenceA);
		Stack<Integer>[] numbersB = sequenceAnalyzer(sequenceB);
		
		// 공통 부분 수열 중 사전 순으로 가장 나중인 수열을 저장할 List 객체 subSequence 초기화
		List<Integer> subSequence = new ArrayList<>();
		
		// 공통 부분 수열에 추가한 마지막 원소의 인덱스를 저장할 각 변수 초기화
		int lastIdxA = -1;
		int lastIdxB = -1;
		
		// for 반복문을 사용해 100부터 1까지의 각 숫자를 순회
		for (int number = 100; number >= 1; number--) {
			
			// while 반복문을 사용해 공통 부분 수열에 추가한 마지막 원소의 인덱스보다 작은 인덱스를 numbersA에서 제거
			while (!numbersA[number].isEmpty() && numbersA[number].peek() < lastIdxA)
				numbersA[number].pop();
			
			// while 반복문을 사용해 공통 부분 수열에 추가한 마지막 원소의 인덱스보다 작은 인덱스를 numbersB에서 제거
			while (!numbersB[number].isEmpty() && numbersB[number].peek() < lastIdxB)
				numbersB[number].pop();
			
			// size() 및 min() 메서드를 사용해 해당 숫자를 추가할 횟수를 변수 counts에 할당
			int counts = Math.min(numbersA[number].size(), numbersB[number].size());
			
			// for 반복문을 사용해 해당 숫자를 추가할 횟수를 순회
			for (int count = 0; count < counts; count++) {

				// pop() 메서드를 사용해 공통 부분 수열에 추가한 마지막 원소의 인덱스를 갱신
				lastIdxA = numbersA[number].pop();
				lastIdxB = numbersB[number].pop();
				
				// add() 메서드를 사용해 해당 숫자를 subSequence에 추가
				subSequence.add(number);
            }
		}
		
		// size(), valueOf(), write() 메서드를 사용해 공통 부분 수열 중 사전 순으로 가장 나중인 수열의 크기를 출력
		out.write(String.valueOf(subSequence.size()));
		
		// 공통 부분 수열의 크기가 0이 아닌 경우
		if (!subSequence.isEmpty()) {
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
			
			// for 반복문을 사용해 공통 부분 수열을 출력
			for (int number : subSequence)
				out.write(number + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// sequenceAnalyzer() 메서드 정의
	@SuppressWarnings("unchecked")
	public static Stack<Integer>[] sequenceAnalyzer(int[] sequence) {
		
		// 주어진 수열의 각 숫자의 등장 인덱스를 저장할 배열 numbers 초기화
		Stack<Integer>[] numbers = new Stack[101];
		
		// for 반복문을 사용해 주어진 수열의 각 숫자의 등장 인덱스를 저장할 List 객체 초기화
		for (int idx = 0; idx < numbers.length; idx++)
			numbers[idx] = new Stack<>();
		
		// for 반복문을 사용해 각 숫자의 등장 인덱스를 배열 numbers에 추가
		for (int idx = sequence.length - 1; idx >= 0; idx--)
			numbers[sequence[idx]].push(idx);
		
		// 주어진 수열의 각 숫자의 등장 인덱스를 저장한 배열 반환
		return numbers;
	}
}