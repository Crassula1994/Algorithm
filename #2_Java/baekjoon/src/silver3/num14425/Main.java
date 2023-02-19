package silver3.num14425;

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
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 개수를 각 변수에 할당
		int inLength = Integer.parseInt(st.nextToken());
		int outLength = Integer.parseInt(st.nextToken());
		
		// 문자열을 저장할 Set 객체 stringSet 초기화
		Set<String> stringSet = new HashSet<>();
		
		// for 반복문을 사용해 각 문자열을 순회
		for (int i = 0; i < inLength; i++) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
			String string = in.readLine();
			
			// add() 메서드를 사용해 해당 문자열을 추가
			stringSet.add(string);
		}
		
		// 포함되어 있는 문자열의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 문자열를 조회
		for (int j = 0; j < outLength; j++) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
			String string = in.readLine();
			
			// stringSet에 해당 문자열이 존재하는 경우 포함되어 있는 문자열의 개수 갱신
			if (stringSet.contains(string))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 포함되어 있는 문자열의 개수 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}