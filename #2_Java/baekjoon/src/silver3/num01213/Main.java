package silver3.num01213;

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
		
		// readLine() 메서드를 사용해 입력 받은 임한수의 영어 이름을 변수 name에 할당
		String name = in.readLine();
		
		// 각 알파벳의 개수를 저장할 배열 alphabets 초기화
		int[] alphabets = new int[26];
		
		// for 반복문을 사용해 알파벳의 개수를 갱신
		for (int idx = 0; idx < name.length(); idx++)
			alphabets[name.charAt(idx) - 'A']++;
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 팰린드롬을 만들 수 있는지 여부, 홀수인 알파벳의 인덱스를 저장할 각 변수 초기화
		boolean isPossible = true;
		int centerIdx = -1;
		
		// for 반복문을 사용해 각 알파벳의 개수를 순회
		for (int idx = 0; idx < alphabets.length; idx++) {
			
			// 해당 알파벳의 개수가 홀수인 경우
			if (alphabets[idx] % 2 == 1) {
				
				// 홀수인 알파벳이 이미 존재하는 경우 팰린드롬을 만들 수 있는지 여부 갱신 후 반복문 탈출
				if (centerIdx != -1) {
					isPossible = false;
					break;
				}
				
				// 홀수인 알파벳을 갱신
				centerIdx = idx;
			}
				
			// for 반복문을 사용해 해당 알파벳의 개수의 절반을 StringBuilder 객체에 추가
			for (int n = 0; n < alphabets[idx] / 2; n++)
				sb.append((char) (65 + idx));
		}
		
		// 팰린드롬을 만들 수 없는 경우 "I'm Sorry Hansoo" 출력
		if (!isPossible) {
			out.write("I'm Sorry Hansoo");
			
		// 팰린드롬을 만들 수 있는 경우
		} else {
			
			// 홀수인 알파벳이 있는 경우 해당 알파벳을 StringBuilder 객체에 추가
			if (centerIdx != -1)
				sb.append((char) (65 + centerIdx));
			
			// for 반복문을 사용해 알파벳을 거꾸로 순회
			for (int idx = alphabets.length - 1; idx >= 0; idx--) {
				
				// for 반복문을 사용해 해당 알파벳의 개수의 절반을 StringBuilder 객체에 추가
				for (int n = 0; n < alphabets[idx] / 2; n++)
					sb.append((char) (65 + idx));
			}
			
			// toString() 및 write() 메서드를 사용해 임한수의 이름으로 만든 팰린드롬을 출력
			out.write(sb.toString());
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}