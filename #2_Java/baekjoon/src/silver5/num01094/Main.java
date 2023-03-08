package silver5.num01094;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 막대의 크기를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// toBinaryString() 메서드를 사용해 이진수로 변환한 결과를 변수 binaryLen에 할당
		String binaryLen = Integer.toBinaryString(length);
		
		// 막대의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 이진수의 숫자를 순회
		for (int idx = 0; idx < binaryLen.length(); idx++) {
			
			// 해당 숫자가 1인 경우 막대의 개수 갱신
			if (binaryLen.charAt(idx) == '1')
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 막대의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}