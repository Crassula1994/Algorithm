package silver5.num32172;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 현권이가 찾은 수열을 저장할 배열 sequence 초기화
		int[] sequence = new int[length + 1];
		
		// 수열에 존재하는 값을 저장할 Set 객체 elements 초기화
		Set<Integer> elements = new HashSet<>();
		
		// for 반복문을 사용해 각 수열의 원소를 순회
		for (int idx = 0; idx < sequence.length; idx++) {
			
			// 해당 수열의 값을 배열 sequence에 저장
			sequence[idx] = (idx == 0) ? 0 : sequence[idx - 1] - idx;
			
			// 해당 수열의 값이 음수이거나 이미 존재하는 값인 경우 해당 수열의 값을 갱신
			if (sequence[idx] < 0 || elements.contains(sequence[idx]))
				sequence[idx] = sequence[idx - 1] + idx;
			
			// add() 메서드를 사용해 해당 수열의 원소를 elements에 추가
			elements.add(sequence[idx]);
		}
		
		// valueOf() 및 write() 메서드를 사용해 수열의 마지막 원소를 출력
		out.write(String.valueOf(sequence[length]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}