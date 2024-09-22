package silver5.num15312;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 알파벳의 획수를 저장할 배열 alphabets 초기화
	static int[] alphabets = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 메서드를 사용해 입력 받은 종민이의 영어 이름과 그녀의 영어 이름을 각 변수에 할당
		String nameJM = in.readLine();
		String nameHER = in.readLine();
		
		// length() 메서드를 사용해 두 사람의 이름의 길이를 변수 length에 할당
		int length = nameJM.length();
		
		// 두 이름의 궁합 결과를 저장할 배열 results 초기화
		int[] results = new int[length * 2];
		
		// for 반복문을 사용해 각 알파벳에 해당하는 획수를 배열 results에 저장
		for (int idx = 0; idx < length; idx++) {
			results[idx * 2] = alphabets[nameJM.charAt(idx) - 'A'];
			results[idx * 2 + 1] = alphabets[nameHER.charAt(idx) - 'A'];
		}
		
		// for 반복문을 사용해 두 자리 숫자가 남을 때까지 순회
		for (int count = 1; count < results.length - 1; count++) {
			
			System.out.print(count + "회차 : ");
			
			for (int idx = 0; idx < results.length; idx++)
				System.out.print(results[idx] + " ");
			System.out.println();
			
			// for 반복문을 사용해 각 회차의 이름 궁합의 결과를 갱신
			for (int idx = 0; idx < results.length - count; idx++)
				results[idx] = (results[idx] + results[idx + 1]) % 10;
		}
		
		System.out.print("결과회차 : ");
		for (int idx = 0; idx < results.length; idx++)
			System.out.print(results[idx] + " ");
		System.out.println();
		
		// valueOf() 및 write() 메서드를 사용해 이름 궁합의 결과를 두 자리 숫자로 출력
		out.write(String.valueOf(results[0]) + String.valueOf(results[1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}