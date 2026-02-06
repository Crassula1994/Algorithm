package bronze3.num17094;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 문자열의 길이 및 문자열을 각 변수에 할당
		int length = Integer.parseInt(in.readLine());
		String string = in.readLine();
		
		// 문자 e의 등장 횟수를 저장할 변수 countE 초기화
		int countE = 0;
		
		// for 반복문을 사용해 문자열의 각 문자를 순회
		for (int idx = 0; idx < length; idx++) {
			
			// 해당 문자가 e인 경우 문자 e의 등장 횟수를 갱신
			if (string.charAt(idx) == 'e')
				countE++;
		}
		
		// 문자 2의 등장 횟수를 계산해 변수 count2에 할당
		int count2 = length - countE;
		
		// 2의 등장 횟수가 더 많은 경우 '2'를 출력
		if (count2 > countE) {
			out.write("2");
			
		// e의 등장 횟수가 더 많은 경우 'e'를 출력
		} else if (count2 < countE) {
			out.write("e");
			
		// 2와 e의 등장 횟수가 같은 경우 'yee'를 출력
		} else {
			out.write("yee");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}