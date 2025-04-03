package bronze1.num11158;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (testCase-- > 0) {
			
			// 해당 문장을 읽고 친구가 숫자를 센 횟수를 저장할 변수 count 초기화
			int count = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// countTokens() 메서드를 사용해 해당 문장의 각 단어를 저장할 배열 words 초기화
			String[] words = new String[st.countTokens()];
			
			// for 반복문을 사용해 각 단어를 배열 words에 저장
			for (int idx = 0; idx < words.length; idx++)
				words[idx] = st.nextToken();
			
			// for 반복문을 사용해 각 단어를 순회
			for (int idx = 0; idx < words.length; idx++) {
				
				// 'u' 또는 'ur'인 경우 친구가 숫자를 센 횟수를 갱신 후 다음 단어를 순회
				if (words[idx].equals("u") || words[idx].equals("ur")) {
					count++;
					continue;
				}
				
				// 해당 단어에 'lol'이 포함된 경우 친구가 숫자를 센 횟수를 갱신 후 다음 단어를 순회
				if (words[idx].contains("lol")) {
					count++;
					continue;
				}
				
				// 'would' 또는 'should'이고 다음 단어가 'of'인 경우 친구가 숫자를 센 횟수를 갱신
				if ((words[idx].equals("would") || words[idx].equals("should"))
						&& idx < words.length - 1 && words[idx + 1].equals("of"))
					count++;
			}
			
			// write() 메서드를 사용해 해당 문장을 읽고 친구가 센 숫자의 개수를 출력
			out.write((count * 10) + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}