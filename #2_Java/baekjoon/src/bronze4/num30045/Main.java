package bronze4.num30045;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 홍보 글의 문장 수를 변수 sentenceNum에 할당
		int sentenceNum = Integer.parseInt(in.readLine());
		
		// 영일이 이모티콘을 넣은 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 각 홍보 글의 문장을 순회
		while (sentenceNum-- > 0) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문장을 배열 sentence에 저장
			char[] sentence = in.readLine().toCharArray();
			
			// for 반복문을 사용해 각 글자를 순회
			for (int idx = 0; idx < sentence.length - 1; idx++) {
				
				// 해당 글자가 0이나 O가 아닌 경우 다음 글자를 순회
				if (sentence[idx] != '0' && sentence[idx] != 'O')
					continue;
				
				// 해당 글자와 다음 글자가 '01'인 경우 영일이 이모티콘을 넣은 횟수를 갱신 후 반복문 탈출
				if (sentence[idx] == '0' && sentence[idx + 1] == '1') {
					count++;
					break;
				}
				
				// 해당 글자와 다음 글자가 'OI'인 경우 영일이 이모티콘을 넣은 횟수를 갱신 후 반복문 탈출
				if (sentence[idx] == 'O' && sentence[idx + 1] == 'I') {
					count++;
					break;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 영일이 이모티콘을 넣은 횟수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}