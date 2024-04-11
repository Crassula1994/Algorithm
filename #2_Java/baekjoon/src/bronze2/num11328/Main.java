package bronze2.num11328;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 메서드를 사용해 입력 받은 두 문자열을 각 변수에 할당
			String stringA = st.nextToken();
			String stringB = st.nextToken();
			
			// 두 문자열의 길이가 다른 경우 'Impossible' 출력
			if (stringA.length() != stringB.length()) {
				out.write("Impossible");
			
			// 두 문자열의 길이가 같은 경우
			} else {
				
				// 각 문자열의 알파벳의 개수를 저장할 각 배열 초기화
				int[] alphabetA = new int[26];
				int[] alphabetB = new int[26];
				
				// for 반복문을 사용해 첫 번째 문자열의 알파벳의 개수를 갱신
				for (int idx = 0; idx < stringA.length(); idx++)
					alphabetA[stringA.charAt(idx) - 'a']++;
				
				// for 반복문을 사용해 두 번째 문자열의 알파벳의 개수를 갱신
				for (int idx = 0; idx < stringB.length(); idx++)
					alphabetB[stringB.charAt(idx) - 'a']++;
				
				// 두 번째 문자열을 첫 번째 문자열로 만들 수 있는지 여부를 나타낼 변수 isPossible 초기화
				boolean isPossible = true;
				
				// for 반복문을 사용해 각 알파벳의 개수를 순회
				for (int idx = 0; idx < 26; idx++) {
					
					// 두 알파벳의 개수가 다른 경우
					if (alphabetA[idx] != alphabetB[idx]) {
						
						// write() 메서드를 사용해 'Impossible' 출력
						out.write("Impossible");
						
						// 두 번째 문자열을 첫 번째 문자열로 만들 수 있는지 여부를 갱신 후 반복문 탈출
						isPossible = false;
						break;
					}
				}
				
				// 두 번째 문자열을 첫 번째 문자열로 만들 수 있는 경우 'Possible' 출력
				if (isPossible)
					out.write("Possible");
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}