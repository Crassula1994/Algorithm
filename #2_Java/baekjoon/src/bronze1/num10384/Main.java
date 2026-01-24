package bronze1.num10384;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// append() 메서드를 사용해 해당 테스트 케이스의 번호를 sb에 저장
			sb.append("Case ").append(tc).append(": ");
			
			// readLine() 및 toLowerCase() 메서드를 사용해 입력 받은 문장을 소문자로 변환해 변수 sentence에 할당
			String sentence = in.readLine().toLowerCase();
			
			// 각 알파벳의 등장 횟수를 저장할 배열 counts 초기화
			int[] counts = new int[26];
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < sentence.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 글자를 변수 letter에 할당
				char letter = sentence.charAt(idx);
				
				// 해당 글자가 알파벳인 경우 해당 알파벳의 개수를 갱신
				if (letter >= 'a' && letter <= 'z')
					counts[letter - 'a']++;
			}
			
			// 알파벳 중 가장 적은 개수를 저장할 변수 minCount 초기화
			int minCount = Integer.MAX_VALUE;
			
			// for 반복문을 사용해 각 알파벳의 개수를 순회
			for (int count : counts) {
				
				// 해당 알파벳이 하나도 없는 경우 알파벳 중 가장 적은 개수를 갱신 후 반복문 탈출
				if (count == 0) {
					minCount = 0;
					break;
				}
				
				// 해당 알파벳의 개수가 현재까지 가장 적은 경우 알파벳 중 가장 적은 개수를 갱신
				if (count < minCount)
					minCount = count;
			}
			
			// switch 조건문을 사용해 해당 문장이 팬그램인지 여부를 sb에 저장
			switch (minCount) {
				case 0:
					sb.append("Not a pangram\n");
					break;
				case 1:
					sb.append("Pangram!\n");
					break;
				case 2:
					sb.append("Double pangram!!\n");
					break;
				default:
					sb.append("Triple pangram!!!\n");
			}
		}
		
		// toString() 및 write() 메서드를 사용해 각 테스트 케이스의 팬그램 여부를 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}