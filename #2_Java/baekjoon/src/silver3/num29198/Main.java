package silver3.num29198;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 개수, 길이, 선택할 문자열의 개수를 각 변수에 할당
		int stringNum = Integer.parseInt(st.nextToken());
		int stringLen = Integer.parseInt(st.nextToken());
		int selectedNum = Integer.parseInt(st.nextToken());
		
		// 주어진 문자열 및 사전순으로 가장 앞에 오는 문자열의 알파벳 개수를 저장할 각 배열 초기화
		String[] strings = new String[stringNum];
		int[] alphabets = new int[26];
		
		// for 반복문을 사용해 입력 받은 문자열을 순회
		for (int idx = 0; idx < strings.length; idx++) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자열을 배열 string에 할당
			char[] string = in.readLine().toCharArray();
			
			// sort() 메서드를 사용해 입력 받은 문자열을 알파벳 순으로 정렬
			Arrays.sort(string);
			
			// 해당 문자열을 배열 strings에 저장
			strings[idx] = new String(string);
		}
		
		// sort() 메서드를 사용해 입력 받은 문자열을 사전 순으로 정렬
		Arrays.sort(strings);
		
		// for 반복문을 사용해 사전순으로 가장 앞에 오는 문자열을 구성하는 문자열을 순회
		for (int idx = 0; idx < selectedNum; idx++) {
			
			// for 반복문을 사용해 문자열의 각 알파벳 개수를 갱신
			for (int c = 0; c < stringLen; c++)
				alphabets[strings[idx].charAt(c) - 'A']++;
		}
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < alphabets.length; idx++) {
			
			// while 반복문을 사용해 해당 알파벳을 출력
			while (alphabets[idx]-- > 0)
				out.write((char) (idx + 65));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}