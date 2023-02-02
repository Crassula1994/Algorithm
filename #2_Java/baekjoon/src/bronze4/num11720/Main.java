package bronze4.num11720;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 숫자의 개수를 변수 numLength에 할당
		int numLength = Integer.parseInt(in.readLine());
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자를 배열 numArray에 할당
		char[] numArray = in.readLine().toCharArray();
		
		// 총합을 저장할 변수 sum에 할당
		int sum = 0;
		
		// for 반복문을 사용해 배열 numArray의 각 원소를 순회
		for (int i = 0; i < numLength; i++)

			// 각 숫자를 정수형으로 형 변환하여 총합에 합산
			sum += numArray[i] - '0';
		
		// valueOf() 및 write() 메서드를 사용해 총합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}