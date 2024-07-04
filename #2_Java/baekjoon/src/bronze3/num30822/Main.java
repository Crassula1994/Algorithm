package bronze3.num30822;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 만들고자 하는 목표 문자열을 상수 TARGET_STRING에 할당
	static final String TARGET_STRING = "uospc";
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 길이 및 문자열을 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		String string = in.readLine();
		
		// 만들 수 있는 'usopc'의 최대 개수를 저장할 변수 maxCount 초기화
		int maxCount = Integer.MAX_VALUE;
		
		// 각 알파벳의 개수를 저장할 배열 alphabets 초기화
		int[] alphabets = new int[26];
		
		// for 반복문을 사용해 각 알파벳의 개수를 갱신
		for (int idx = 0; idx < length; idx++)
			alphabets[string.charAt(idx) - 'a']++;
		
		// for 반복문을 사용해 만들 수 있는 'usopc'의 최대 개수를 갱신
		for (int idx = 0; idx < TARGET_STRING.length(); idx++)
			maxCount = Math.min(alphabets[TARGET_STRING.charAt(idx) - 'a'], maxCount);
		
		// valueOf() 및 write() 메서드를 사용해 만들 수 있는 'usopc'의 최대 개수를 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}