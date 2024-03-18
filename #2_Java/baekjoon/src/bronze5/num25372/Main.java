package bronze5.num25372;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 문자열의 총 개수를 변수 stringNum에 할당
		int stringNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 문자열을 순회
		for (int s = 0; s < stringNum; s++) {
			
			// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
			String string = in.readLine();
			
			// 사용할 수 있는 비밀번호인 경우 'yes' 출력
			if (string.length() >= 6 && string.length() <= 9) {
				out.write("yes");
				
			// 사용할 수 없는 비밀번호인 경우 'no' 출력
			} else {
				out.write("no");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}