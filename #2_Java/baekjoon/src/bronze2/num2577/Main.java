package bronze2.num2577;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 각 숫자를 곱한 결과를 변수 result에 저장
		int result = Integer.parseInt(in.readLine()) * Integer.parseInt(in.readLine()) * Integer.parseInt(in.readLine());
		
		// toString() 및 toCharArray() 메서드를 사용해 곱셈 결과의 각 자릿수를 배열 numArray에 저장
		char[] numArray = Integer.toString(result).toCharArray();
		
		// 곱셈 결과에서 각 숫자의 개수를 저장할 배열 counts 초기화
		int[] counts = new int[10];
		
		// for 반복문을 사용해 배열 numArray의 각 원소를 순회
		for (char num : numArray) {
			
			// 해당 숫자의 개수를 갱신
			counts[num - '0']++;
		}
		
		// for 반복문을 사용해 배열 counts를 순회하며 각 숫자를 출력
		for (int count : counts)
			out.write(count + "\n");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}