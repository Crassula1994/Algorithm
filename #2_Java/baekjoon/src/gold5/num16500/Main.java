package gold5.num16500;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열과 단어의 개수를 각 변수에 할당
		String targetString = in.readLine();
		int wordNum = Integer.parseInt(in.readLine());
		
		// 주어진 단어 및 각 위치까지의 문자열을 만들 수 있는지 여부를 저장할 각 배열 초기화
		String[] words = new String[wordNum];
		boolean[] combinable = new boolean[targetString.length()];
		
		// for 반복문을 사용해 입력 받은 단어를 배열 words에 저장
		for (int idx = 0; idx < words.length; idx++)
			words[idx] = in.readLine();
		
		// for 반복문을 사용해 문자열의 각 위치를 순회
		for (int idx = 0; idx < targetString.length(); idx++) {
			
			// for 반복문을 사용해 각 단어를 순회
			for (String word : words) {
				
				// 첫 위치이거나 이전까지의 단어를 만들 수 있는 경우
				if (idx == 0 || combinable[idx - 1]) {
					
					// 해당 단어의 길이가 해당 위치에서 문자열의 범위를 벗어나는 경우 다음 단어를 순회
					if (idx + word.length() > targetString.length())
						continue;
					
					/* 해당 위치에서 시작하는 부분 문자열이 주어진 단어와 일치하는 경우
					단어가 끝나는 위치에서 문자열을 만들 수 있는지 여부를 갱신 */
					if (targetString.substring(idx, idx + word.length()).equals(word))
						combinable[idx + word.length() - 1] = true;
				}
			}
		}
		
		// length(), valueOf(), write() 메서드를 사용해 주어진 단어를 조합하여 문자열을 만들 수 있는지 여부를 출력
		out.write((combinable[targetString.length() - 1]) ? String.valueOf(1) : String.valueOf(0));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}