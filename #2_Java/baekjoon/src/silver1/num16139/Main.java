package silver1.num16139;

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
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 각 위치까지의 알파벳의 수를 저장할 2차원 배열 alphabets 초기화
		int[][] alphabets = new int[26][string.length()];
		
		// for 반복문을 사용해 문자열의 각 문자를 순회
		for (int idx = 0; idx < string.length(); idx++) {
			
			// charAt() 메서드를 사용해 해당 알파벳의 인덱스를 변수 charIdx에 할당
			int charIdx = string.charAt(idx) - 'a';
			
			// 첫 문자인 경우 해당 알파벳의 개수를 갱신
			if (idx == 0) {
				alphabets[charIdx][idx]++;
				
			// 첫 문자가 아닌 경우 해당 알파벳의 누적합을 갱신
			} else {
				
				// for 반복문을 사용해 각 알파벳을 순회
				for (int alphabet = 0; alphabet < 26; alphabet++) {
					
					// 해당 알파벳이라면 누적합을 갱신
					if (alphabet == charIdx) {
						alphabets[alphabet][idx] = alphabets[alphabet][idx - 1] + 1;
					
					// 해당 알파벳이 아닌 경우 누적합을 갱신
					} else {
						alphabets[alphabet][idx] = alphabets[alphabet][idx -1];
					}
				}
			}
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 질문의 수를 변수 questionNum에 할당
		int questionNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 질문을 순회
		for (int question = 0; question < questionNum; question++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 charAt() 메서드를 사용해 찾고자 하는 알파벳을 변수 target에 할당
			int target = st.nextToken().charAt(0) - 'a';
			
			// nextToken() 및 parseInt() 메서드를 사용해 검색 범위가 되는 문자의 위치를 각 변수에 할당
			int leftIdx = Integer.parseInt(st.nextToken());
			int rightIdx = Integer.parseInt(st.nextToken());
			
			// 왼쪽 끝 인덱스가 0인 경우 오른쪽 끝까지의 값을 그대로 출력
			if (leftIdx == 0) {
				out.write(alphabets[target][rightIdx] + "\n");
			
			// 왼쪽 끝 인덱스가 0이 아닌 경우 오른쪽 끝에서 왼쪽 끝까지의 값을 빼서 출력
			} else {
				out.write(alphabets[target][rightIdx] - alphabets[target][leftIdx - 1] + "\n");
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}