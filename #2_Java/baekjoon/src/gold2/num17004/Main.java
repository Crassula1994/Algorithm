package gold2.num17004;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;  
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 원래 문자열의 길이를 저장할 변수 length 초기화
	static int length;
	
	// 각 문자열의 위치까지 등장한 알파벳의 개수를 저장할 2차원 배열 alphabets 초기화
	static int[][] alphabets;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 원래 문자열과 목표 문자열을 각 배열에 할당
		char[] sourceString = in.readLine().toCharArray();
		char[] targetString = in.readLine().toCharArray();
		
		// 목표 문자열을 최소 한 번은 부분열로 갖는 부분 문자열의 수를 저장할 변수 totalCount 초기화
		long totalCount = 0;
		
		// 원래 문자열의 길이를 변수 length에 저장
		length = sourceString.length;
		
		// 각 문자열의 위치까지 등장한 알파벳의 개수를 저장할 2차원 배열 alphabets 초기화
		alphabets = new int[length + 1][26];
		
		// for 반복문을 사용해 원래 문자열의 각 글자를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// for 반복문을 사용해 현재 위치까지 등장한 알파벳의 개수를 초기화
			for (int alphabet = 0; alphabet < 26; alphabet++)
				alphabets[idx + 1][alphabet] = alphabets[idx][alphabet];
			
			// 현재 위치의 알파벳의 개수를 갱신
			alphabets[idx + 1][sourceString[idx] - 'a']++;
		}
		
		// for 반복문을 사용해 각 부분 문자열의 시작 위치를 순회
		outer: for (int idx = 0; idx < length; idx++) {
			
			// 현재 부분 문자열의 시작 위치를 저장할 변수 startIdx 초기화
			int startIdx = idx;
			
			// for 반복문을 사용해 목표 문자열의 각 문자를 순회
			for (char alphabet : targetString) {
				
				// alphabetFinder() 메서드를 호출해 목표 문자열의 문자가 있는 위치를 부분 문자열의 시작 위치로 갱신
				startIdx = alphabetFinder(startIdx, alphabet);
				
				// 목표 문자열을 부분열로 갖지 않는 경우 다음 시작 위치를 순회
				if (startIdx > length)
					continue outer;
			}

			// 목표 문자열을 최소 한 번은 부분열로 갖는 부분 문자열의 수를 갱신
			totalCount += length - startIdx + 1;
		}
		
		// valueOf() 및 write() 메서드를 사용해 목표 문자열을 최소 한 번은 부분열로 갖는 부분 문자열의 수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// alphabetFinder() 메서드 정의
	public static int alphabetFinder(int startIdx, char alphabet) {
		
		// 해당 알파벳의 순서, 찾아야 하는 알파벳의 개수, 알파벳을 찾기 위한 범위의 끝을 각 변수에 할당
		int targetOrder = alphabet - 'a';
		int targetCount = alphabets[startIdx][targetOrder] + 1;
		int endIdx = length + 1;
		
		// while 반복문을 사용해 해당 알파벳을 찾을 때까지 순회
		while (startIdx < endIdx) {
			
			// 범위의 중간 값을 계산해 변수 midIdx에 할당
			int midIdx = (startIdx + endIdx) / 2;
			
			// 범위의 중간 값의 목표 알파벳의 개수가 찾아야 하는 알파벳의 개수보다 적은 경우 범위의 시작을 갱신
			if (alphabets[midIdx][targetOrder] < targetCount) {
				startIdx = midIdx + 1;
				
			// 범위의 중간 값의 목표 알파벳의 개수가 찾아야 하는 알파벳의 개수보다 크거나 같은 경우 범위의 끝을 갱신
			} else {
				endIdx = midIdx;
			}
		}
		
		// 해당 알파벳의 위치를 반환
		return endIdx;
	}
}