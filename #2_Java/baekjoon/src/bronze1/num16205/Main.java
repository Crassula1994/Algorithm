package bronze1.num16205;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 해당 변수의 표기법 및 변수명을 각 변수에 할당
		int category = Integer.parseInt(st.nextToken());
		String variableName = st.nextToken();
		
		// StringBuilder 객체를 불러와 변수 sb에 할당
		StringBuilder sb = new StringBuilder();
		
		// 해당 변수가 카멜 표기법인 경우
		if (category == 1) {
			
			// append() 메서드를 사용해 카멜 표기법을 사용한 경우의 변수명을 sb에 추가
			sb.append(variableName).append("\n");
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 0; idx < variableName.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
				char alphabet = variableName.charAt(idx);
				
				// 해당 알파벳이 대문자인 경우 언어바와 소문자로 변환한 알파벳을 sb에 추가
				if (alphabet < 'a') {
					sb.append("_").append((char) (alphabet + 32));
					
				// 해당 알파벳이 소문자인 경우 해당 알파벳을 sb에 추가
				} else {
					sb.append(alphabet);
				}
			}
			
			// charAt(), substring(), append() 메서드를 사용해 첫 알파벳을 대문자로 변환하고 sb에 추가
			sb.append("\n").append((char) (variableName.charAt(0) - 32)).append(variableName.substring(1));
			
		// 해당 변수가 스네이크 표기법인 경우
		} else if (category == 2) {
			
			// split() 메서드를 사용해 해당 변수명을 각 단어로 구분하고 배열 words에 저장
			String[] words = variableName.split("_");
			
			// append() 메서드를 사용해 첫 번째 단어를 sb에 그대로 추가
			sb.append(words[0]);
			
			// for 반복문을 사용해 나머지 단어의 첫 알파벳을 대문자로 바꾸어 sb에 추가
			for (int idx = 1; idx < words.length; idx++)
				sb.append((char) (words[idx].charAt(0) - 32)).append(words[idx].substring(1));
			
			// append() 메서드를 사용해 스네이크 표기법을 사용한 경우의 변수명을 sb에 추가
			sb.append("\n").append(variableName).append("\n");
			
			// for 반복문을 사용해 모든 단어의 첫 알파벳을 대문자로 바꾸어 sb에 추가
			for (int idx = 0; idx < words.length; idx++)
				sb.append((char) (words[idx].charAt(0) - 32)).append(words[idx].substring(1));
			
		// 해당 변수가 파스칼 표기법인 경우
		} else {
			
			// charAt() 메서드를 사용해 첫 알파벳을 소문자로 변환한 결과를 변수 firstSmallLetter에 할당
			char firstSmallLetter = (char) (variableName.charAt(0) + 32);
			
			// charAt(), substring(), append() 메서드를 사용해 첫 알파벳을 소문자로 변환하고 sb에 추가
			sb.append(firstSmallLetter).append(variableName.substring(1)).append("\n").append(firstSmallLetter);
			
			// for 반복문을 사용해 각 알파벳을 순회
			for (int idx = 1; idx < variableName.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 알파벳을 변수 alphabet에 할당
				char alphabet = variableName.charAt(idx);
				
				// 해당 알파벳이 대문자인 경우 언어바와 소문자로 변환한 알파벳을 sb에 추가
				if (alphabet < 'a') {
					sb.append("_").append((char) (alphabet + 32));
					
				// 해당 알파벳이 소문자인 경우 해당 알파벳을 sb에 추가
				} else {
					sb.append(alphabet);
				}
			}
			
			// append() 메서드를 사용해 파스칼 표기법을 사용한 경우의 변수명을 sb에 추가
			sb.append("\n").append(variableName);
		}
		
		// toString() 및 write() 메서드를 사용해 각 표기법을 사용한 경우의 변수명을 출력
		out.write(sb.toString());
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}