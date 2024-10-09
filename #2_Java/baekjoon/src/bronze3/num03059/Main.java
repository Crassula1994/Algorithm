package bronze3.num03059;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 데이터의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 데이터를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 메서드를 사용해 입력 데이터를 변수 testData에 할당
			String testData = in.readLine();
			
			// 등장하지 않는 알파벳 대문자의 아스키 코드 값의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// 각 알파벳이 등장했는지 여부를 저장할 배열 alphabets 초기화
			boolean[] alphabets = new boolean[26];
			
			// for 반복문을 사용해 각 알파벳이 등장했는지 여부를 갱신
			for (int idx = 0; idx < testData.length(); idx++)
				alphabets[testData.charAt(idx) - 'A'] = true;
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < alphabets.length; idx++) {
				
				// 해당 알파벳이 등장하지 않은 경우 등장하지 않는 알파벳 대문자의 아스키 코드 값의 합을 갱신
				if (!alphabets[idx])
					sum += idx + 65;
			}
			
			// write() 메서드를 사용해 등장하지 않는 알파벳 대문자의 아스키 코드 값의 합을 출력
			out.write(sum + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}