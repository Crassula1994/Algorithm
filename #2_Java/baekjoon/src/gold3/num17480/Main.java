package gold3.num17480;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 준석이가 말한 알파벳 종류의 개수를 저장할 배열 alphabets 초기화
	static int[] alphabets = new int[26];
	
	// 준석이가 만들 수 있는 문자열을 저장할 Set 객체 stringList 초기화
	static Set<String> stringList = new HashSet<>();
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 준석이가 말한 알파벳 종류의 개수를 변수 alphabetNum에 할당
		int alphabetNum = Integer.parseInt(in.readLine());
		
		// 알파벳의 총 개수를 저장할 변수 alphabetCount 초기화
		int alphabetCount = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// while 반복문을 사용해 준석이가 말한 각 알파벳의 종류를 순회
		while (alphabetNum-- > 0) {
			
			// nextToken(), charAt(), parseInt() 메서드를 사용해 해당 알파벳과 그 개수를 각 변수에 할당
			char alphabet = st.nextToken().charAt(0);
			int count = Integer.parseInt(st.nextToken());
			
			// 해당 알파벳의 개수를 배열 alphabets에 저장
			alphabets[alphabet - 'a'] = count;
			
			// 알파벳의 총 개수를 개신
			alphabetCount += count;
		}
		
		// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
		String word = in.readLine();
		
		// for 반복문을 사용해 각 부분 문자열을 순회
		for (int idx = 0; idx < word.length() - alphabetCount + 1; idx++) {
			
			// substring() 메서드를 사용해 해당 부분 문자열을 변수 subString에 할당
			String subString = word.substring(idx, idx + alphabetCount);
			
			// 해당 부분 문자열의 알파벳의 개수가 준석이가 말한 알파벳의 개수와 일치하지 않는 경우 다음 부분 문자열을 순회
			if (!subStringChecker(subString))
				continue;
			
			// stringMaker() 메서드를 호출해 준석이가 만들 수 있는 문자열을 갱신
			stringMaker(subString, 0, alphabetCount - 1);
		}
		
		// size(), valueOf(), write() 메서드를 사용해 준석이가 만들 수 있는 문자열의 개수를 출력
		out.write(String.valueOf(stringList.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------

	// subStringChecker() 메서드 정의
	public static boolean subStringChecker(String subString) {
		
		// 해당 부분 문자열의 각 알파벳 개수를 저장할 배열 subAlphabets 초기화
		int[] subAlphabets = new int[26];
		
		// for 반복문을 사용해 주어진 부분 문자열의 각 알파벳의 개수를 갱신
		for (char alphabet : subString.toCharArray())
			subAlphabets[alphabet - 'a']++;
		
		// for 반복문을 사용해 각 알파벳을 순회
		for (int idx = 0; idx < 26; idx++) {
			
			// 해당 부분 문자열의 알파벳의 개수가 준석이가 말한 알파벳의 개수와 다른 경우 false 반환
			if (subAlphabets[idx] != alphabets[idx])
				return false;
		}
		
		// 해당 부분 문자열의 알파벳의 개수가 준석이가 말한 알파벳의 개수와 같은 경우 true 반환
		return true;
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// stringMaker() 메서드 정의
	public static void stringMaker(String curString, int startIdx, int endIdx) {
		
		// 선택된 문자열의 길이와 가운데 위치를 계산해 변수 length에 할당
		int length = endIdx - startIdx + 1;
		int midIdx = (startIdx + endIdx) / 2;
		
		// 선택된 문자열의 길이가 1인 경우 stringList에 해당 문자열을 추가 후 메서드 종료
		if (length == 1) {
			stringList.add(curString);
			return;
		}
		
		// subStringReverser() 및 stringMaker() 메서드를 호출해 다음 선택할 문자열의 범위를 순회
		stringMaker(subStringReverser(curString, startIdx, midIdx), midIdx + 1, endIdx);
		stringMaker(subStringReverser(curString, midIdx + 1, endIdx), startIdx, midIdx);
		
		// 해당 문자열의 길이가 홀수인 경우
		if ((length & 1) == 1) {
			
			// subStringReverser() 및 stringMaker() 메서드를 호출해 다음 선택할 문자열의 범위를 순회
			stringMaker(subStringReverser(curString, startIdx, midIdx - 1), midIdx, endIdx);
			stringMaker(subStringReverser(curString, midIdx, endIdx), startIdx, midIdx - 1);
		}
	}
	
	// ----------------------------------------------------------------------------------------------------

	// subStringReverser() 메서드 정의
	public static String subStringReverser(String curString, int startIdx, int endIdx) {
		
		// toCharArray() 메서드를 사용해 주어진 문자열을 배열 reversedString에 할당
		char[] reversedString = curString.toCharArray();
		
		// while 반복문을 사용해 뒤집을 문자열의 범위의 문자를 모두 뒤집어 배열 reversedString에 저장
		while (startIdx < endIdx) {
			char temp = reversedString[startIdx];
			reversedString[startIdx] = reversedString[endIdx];
			reversedString[endIdx] = temp;
			startIdx++;
			endIdx--;
		}
		
		// 해당 부분을 뒤집은 문자열을 반환
		return new String(reversedString);
	}
}