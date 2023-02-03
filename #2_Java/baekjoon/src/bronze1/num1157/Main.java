package bronze1.num1157;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 단어를 배열 word에 알파벳별로 나누어 저장
		char[] word = in.readLine().toCharArray();
		
		// 각 알파벳의 개수를 저장할 배열 countArray 초기화
		int[] countArray = new int[26];
		
		// 가장 많은 알파벳의 수와 해당 알파벳의 인덱스를 저장할 각 변수 초기화 
		int mode = 0;
		int modeIndex = 0;
		
		// for 반복문을 사용해 입력 받은 단어의 각 알파벳을 순회
		for (char alphabet : word) {
			
			// 해당 알파벳이 대문자인 경우 알파벳의 개수를 갱신
			if (alphabet - 'a' < 0) {
				countArray[alphabet - 'A'] += 1;
			
			// 해당 알파벳이 소문자인 경우 알파벳의 개수를 갱신
			} else {
				countArray[alphabet - 'a'] += 1;
			}
		}
			
		// for 반복문을 사용해 배열 countArray의 원소를 순회
		for (int i = 0; i < countArray.length; i++) {
			
			// 기존 최빈수 이상인 경우 최빈 알파벳을 갱신
			if (countArray[i] > mode) {
				mode = countArray[i];
				modeIndex = i;
			
			// 최빈 알파벳이 한 번 더 나온 경우 인덱스를 -1로 변경
			} else if (countArray[i] == mode) {
				modeIndex = -1;
			}
		}
		
		// 최빈 알파벳이 하나가 아닌 경우 '?' 출력
		if (modeIndex == -1) {
			out.write("?");
		
		// 최빈 알파벳이 하나인 경우 해당 대문자 알파벳을 출력
		} else {
			char answer = (char) (modeIndex + 65);
			out.write(answer);
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}