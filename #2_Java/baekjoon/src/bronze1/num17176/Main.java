package bronze1.num17176;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 수열의 길이를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());
		
		// 평문을 암호화해서 주어진 암호문을 만들 수 있는지 여부를 저장할 변수 isPossible 초기화
		boolean isPossible = true;
		
		// 각 글자의 개수를 저장할 배열 counts 초기화
		int[] counts = new int[53];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 글자의 개수를 갱신
		for (int element = 0; element < length; element++)
			counts[Integer.parseInt(st.nextToken())]++;
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 평문을 배열 clearText에 저장
		char[] clearText = in.readLine().toCharArray();
		
		// for 반복문을 사용해 각 글자를 순회
		for (char character : clearText) {
			
			// 해당 글자를 정수로 바꾼 결과를 저장할 변수 targetIdx 초기화
			int targetIdx = 0;
			
			// 해당 글자가 알파벳 대문자인 경우 해당 글자를 정수로 바꾼 결과를 갱신
			if (character >= 'A' && character <= 'Z') {
				targetIdx = character - 'A' + 1;
			
			// 해당 글자가 알파벳 소문자인 경우 해당 글자를 정수로 바꾼 결과를 갱신
			} else if (character >= 'a' && character <= 'z') {
				targetIdx = character - 'a' + 27;
			}
			
			// 해당 글자가 더 이상 존재하지 않는 경우 평문을 암호화해서 주어진 암호문을 만들 수 있는지 여부를 갱신 후 반복문 탈출
			if (counts[targetIdx] == 0) {
				isPossible = false;
				break;
			}
			
			// 해당 글자의 개수를 갱신
			counts[targetIdx]--;
		}
		
		// write() 메서드를 사용해 평문을 암호화해서 주어진 암호문을 만들 수 있는지 여부를 출력
		out.write((isPossible) ? "y" : "n");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}