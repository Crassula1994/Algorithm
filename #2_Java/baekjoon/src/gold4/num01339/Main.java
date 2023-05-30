package gold4.num01339;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 단어의 개수를 변수 wordNum에 할당
		int wordNum = Integer.parseInt(in.readLine());
		
		// 각 알파벳의 자릿수를 저장할 배열 counter 초기화
		int[] counter = new int[26];
		
		// for 반복문을 사용해 각 단어를 순회
		for (int w = 0; w < wordNum; w++) {
			
			// readLine() 메서드를 사용해 입력 받은 단어를 변수 word에 할당
			String word = in.readLine();
			
			// for 반복문을 사용해 단어의 각 알파벳을 순회
			for (int idx = 0; idx < word.length(); idx++) {
				
				// charAt() 메서드를 사용해 해당 알파벳의 인덱스를 변수 index에 할당
				int index = word.charAt(idx) - 'A';
				
				// length() 및 pow() 메서드를 사용해 해당 알파벳의 자릿수를 갱신
				counter[index] = counter[index] + (int) Math.pow(10, (word.length() - idx - 1));
			}
		}
		
		// sort() 메서드를 사용해 배열 counter를 오름차순으로 정렬
		Arrays.sort(counter);
		
		// 주어진 단어의 합의 최댓값을 저장할 변수 maxSum 초기화
		int maxSum = 0;
		
		// for 반복문을 사용해 값이 존재하는 각 알파벳을 순회
		for (int idx = 25; idx > 15; idx--) {
			
			// 해당 알파벳이 존재하지 않는 경우 반복문 탈출
			if (counter[idx] == 0)
				break;
			
			// 주어진 단어의 합의 최댓값을 갱신
			maxSum += counter[idx] * (idx - 16);
		}
		
		// valueOf() 및 write() 메서드를 사용해 주어진 단어의 합의 최댓값를 출력
		out.write(String.valueOf(maxSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}