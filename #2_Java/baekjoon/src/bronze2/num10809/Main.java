package bronze2.num10809;

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
		
		// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 문자를 배열 characterArray에 할당
		char[] characterArray = in.readLine().toCharArray();
		
		// 각 알파벳의 등장 위치를 저장할 배열 location에 할당
		int[] location = new int[26];
		
		// fill() 메서드를 사용해 location 배열의 각 원소를 -1로 초기화
		Arrays.fill(location, -1);
		
		// for 반복문을 사용해 배열 characterArray의 각 원소를 순회
		for (int i = 0; i < characterArray.length; i++) {
			
			// 해당 문자가 등장한 적이 없었던 경우 등장한 위치를 갱신
			if (location[characterArray[i] - 'a'] == -1)
				location[characterArray[i] - 'a'] = i;
		}

		// for 반복문을 사용해 배열 location의 각 원소를 순회
		for (int j = 0; j < location.length; j++)
			
			// write() 메서드를 사용해 원소를 출력
			out.write(location[j] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}