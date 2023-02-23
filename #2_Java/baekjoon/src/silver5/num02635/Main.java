package silver5.num02635;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자를 변수 number에 할당
		int number = Integer.parseInt(in.readLine());
		
		// 해당 수열의 최대 길이를 저장할 변수 maxLength 초기화
		int maxLength = 0;
		
		// 해당 수열의 구성 원소를 저장할 List 객체 maxSequence 초기화
		List<Integer> maxSequence = new ArrayList<>();
		
		// for 반복문을 사용해 해당 숫자 이하의 양의 정수를 차례로 순회
		for (int n = 1; n <= number; n++) {
			
			// 해당 수열의 값을 저장할 List 객체 sequence 초기화
			List<Integer> sequence = new ArrayList<>();
			
			// sequence에 수열의 첫 번째 수와 두 번째 수를 추가
			sequence.add(number);
			sequence.add(n);
			
			// while 반복문을 사용해 음수가 나올 때까지 순회
			while (true) {
				
				// 수열에서 앞의 두 수를 뺀 값을 변수 element에 할당
				int element = sequence.get(sequence.size() - 2) - sequence.get(sequence.size() - 1);
				
				// element가 음수인 경우 반복문 탈출
				if (element < 0) {
					break;
					
				// element가 음수가 아닌 경우 수열에 element 추가
				} else {
					sequence.add(element);
				}
			}
			
			// 해당 수열의 길이가 최대 길이인 경우 수열 및 최대 수열을 갱신
			if (sequence.size() > maxLength) {
				maxLength = sequence.size();
				maxSequence = sequence;
			}
		}
		
		// write() 메서드를 사용해 최대 수열의 길이를 출력
		out.write(maxLength + "\n");
		
		// for 반복문을 사용해 maxSequence의 각 원소를 순회하며 출력
		for (int idx = 0; idx < maxLength; idx++)
			out.write(maxSequence.get(idx) + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}