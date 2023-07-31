package gold4.num02661;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 수열의 길이, 가장 작은 수를 나타낼 수열을 저장할 각 변수 초기화
	static int sequenceLen;
	static StringBuilder sequence = new StringBuilder();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 sequenceLen에 할당
		sequenceLen = Integer.parseInt(in.readLine());
		
		// sequenceFinder() 메서드를 호출해 가장 작은 수를 나타내는 좋은 수열을 출력
		sequenceFinder(0, out);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// sequenceFinder() 메서드 정의
	public static void sequenceFinder(int length, BufferedWriter out) throws IOException {

		// 찾고자 하는 길이에 도달한 경우
		if (length == sequenceLen) {
			
			// toString() 및 write() 메서드를 사용해 가장 작은 수를 나타내는 좋은 수열을 출력
			out.write(sequence.toString());
			
			// flush() 메서드를 사용해 지금까지의 내용을 출력
			out.flush();
			
			// exit() 메서드를 사용해 JVM 정상 종료
			System.exit(0);
		}
		
		// for 반복문을 사용해 수열에 사용할 수 있는 각 숫자를 순회
		for (int number = 1; number <= 3; number++) {
			
			// append() 메서드를 사용해 해당 숫자를 좋은 수열에 추가
			sequence.append(number);
			
			// 해당 숫자를 추가했을 시 좋은 수열인지를 나타내는 변수 isGood 초기화
			boolean isGood = true;
			
			// for 반복문을 사용해 해당 숫자가 포함된 각 길이를 순회
			for (int len = 1; len <= sequence.length() / 2; len++) {
				
				// substring() 메서드를 사용해 각 숫자를 비교할 두 구간을 각 변수에 할당
				String firstStr = sequence.substring(sequence.length() - len);
				String secondStr = sequence.substring(sequence.length() - 2 * len, sequence.length() - len);
				
				// 두 구간이 같은 경우 좋은 수열인지를 나타내는 변수 갱신 후 반복문 탈출
				if (firstStr.equals(secondStr)) {
					isGood = false;
					break;
				}
			}
			
			// 해당 숫자를 추가했을 시 좋은 수열이면 sequenceFinder() 메서드 재귀 호출
			if (isGood)
				sequenceFinder(length + 1, out);
			
			// length() 및 deleteCharAt() 메서드를 사용해 추가한 숫자를 제거
			sequence.deleteCharAt(sequence.length() - 1);
		}
	}
}