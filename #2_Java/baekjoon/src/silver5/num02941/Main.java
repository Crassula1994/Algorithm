package silver5.num02941;

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
	
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자열을 배열 characterArray에 저장
		char[] characterArray = in.readLine().toCharArray();
		
		// 알파벳의 수를 저장할 변수 count 초기화
		int count = characterArray.length;
		
		// for 반복문을 사용해 배열 characterArray의 각 원소를 순회
		for (int i = 0; i < characterArray.length; i++) {
			
			// '-' 문자가 나온 경우 count 수 조정
			if (characterArray[i] == '-')
				count--;
		
			// '=' 문자가 나온 경우 count 수 조정
			if (characterArray[i] == '=') {
				count--;
				
				// '=' 문자의 앞의 문자가 'dz'인 경우 count 수 조정
				if (i > 1 && characterArray[i - 1] == 'z' && characterArray[i - 2] == 'd')
					count --;
			}
				
			// 'j' 문자가 나오고 앞의 문자가 'l' 또는 'n'인 경우 count 수 조정
			if (i > 0 && characterArray[i] == 'j' && (characterArray[i - 1] == 'l' || characterArray[i - 1] == 'n'))
				count--;
		}

		// valueOf(), write() 메서드를 사용해 알파벳의 수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}