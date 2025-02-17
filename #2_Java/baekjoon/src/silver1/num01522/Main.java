package silver1.num01522;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 원래 문자열을 배열 originalString에 저장
		char[] originalString = in.readLine().toCharArray();
		
		// 해당 문자열에 존재하는 a의 개수, 각 구간에 존재하는 b의 개수, a를 연속으로 만들기 위해 필요한 최소 교환 횟수를 저장할 각 변수 초기화
		int countA = 0;
		int countB = 0;
		int minCount = Integer.MAX_VALUE;
		
		// for 반복문을 사용해 문자열의 각 알파벳을 순회
		for (char alphabet : originalString) {
			
			// 해당 알파벳이 a인 경우 해당 문자열에 존재하는 a의 개수를 갱신
			if (alphabet == 'a')
				countA++;
		}
		
		// 해당 문자열에 a가 존재하지 않는 경우 0을 출력
		if (countA == 0) {
			out.write(String.valueOf(0));
			
		// 해당 문자열에 a가 존재하는 경우
		} else {
			
			// for 반복문을 사용해 각 구간의 시작 위치를 순회
			for (int start = 0; start < originalString.length; start++) {
				
				// 연속되는 a가 존재해야 하는 구간의 끝 위치를 변수 end에 할당
				int end = (start + countA - 1) % originalString.length;
				
				// 첫 번째 시작 위치인 경우
				if (start == 0) {
					
					// for 반복문을 사용해 첫 구간을 순회
					for (int idx = start; idx <= end; idx++)
						
						// 해당 알파벳이 b인 경우 해당 구간에 존재하는 b의 개수를 갱신
						if (originalString[idx] == 'b')
							countB++;
					
				// 첫 번째 시작 위치가 아닌 경우 해당 구간에 존재하는 b의 개수를 갱신
				} else {
					countB = (originalString[start - 1] == 'b') ? countB - 1 : countB;
					countB = (originalString[end] == 'b') ? countB + 1 : countB;
				}
				
				// min() 메서드를 사용해 a를 연속으로 만들기 위해 필요한 최소 교환 횟수를 갱신
				minCount = Math.min(countB, minCount);
			}
			
			// valueOf() 및 write() 메서드를 사용해 a를 연속으로 만들기 위해 필요한 최소 교환 횟수를 출력
			out.write(String.valueOf(minCount));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}