package bronze4.num10808;

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

		// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
		String word = in.readLine();
		
		// 각 알파벳의 개수를 저장할 배열 alphabets 초기화
		int[] alphabets = new int[26];
		
		// for 반복문을 사용해 각 알파벳의 개수를 갱신
		for (int idx = 0; idx < word.length(); idx++)
			alphabets[word.charAt(idx) - 'a']++;

		// for 반복문을 사용해 각 알파벳의 개수를 출력
		for (int alphabet : alphabets)
			out.write(alphabet + " ");

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}