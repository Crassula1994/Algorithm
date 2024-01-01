package bronze2.num01919;

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
		
		// readLine() 메서드를 사용해 입력 받은 두 영어 단어를 각 변수에 할당
		String wordA = in.readLine();
		String wordB = in.readLine();
		
		// 두 단어가 애너그램 관계에 있도록 만들기 위해서 제거해야 하는 최소 개수의 문자 수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// 각 단어의 알파벳 개수를 저장할 각 배열 초기화
		int[] alphabetsA = new int[26];
		int[] alphabetsB = new int[26];
		
		// for 반복문을 사용해 첫 번째 단어의 알파벳 개수를 갱신
		for (int idx = 0; idx < wordA.length(); idx++)
			alphabetsA[wordA.charAt(idx) - 'a']++;
		
		// for 반복문을 사용해 두 번째 단어의 알파벳 개수를 갱신
		for (int idx = 0; idx < wordB.length(); idx++)
			alphabetsB[wordB.charAt(idx) - 'a']++;
		
		// for 반복문을 사용해 두 단어가 애너그램 관계에 있도록 만들기 위해서 제거해야 하는 최소 개수의 문자 수를 갱신
		for (int alphabet = 0; alphabet < 26; alphabet++)
			minCount += Math.abs(alphabetsA[alphabet] - alphabetsB[alphabet]);
		
		// valueOf() 및 write() 메서드를 사용해 두 단어가 애너그램 관계에 있도록 만들기 위해서 제거해야 하는 최소 개수의 문자 수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}