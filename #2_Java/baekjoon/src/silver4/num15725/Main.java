package silver4.num15725;

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
		
		// readLine() 메서드를 사용해 입력 받은 다항식을 변수 multinomial에 할당
		String multinomial = in.readLine();
		
		// 변수 x의 등장 위치를 저장할 변수 locationX 초기화
		int locationX = -1;
		
		// for 반복문을 사용해 다항식의 각 문자를 순회
		for (int idx = 0; idx < multinomial.length(); idx++) {
			
			// 변수 x의 등장 위치를 찾은 경우 변수 x의 등장 위치를 갱신 후 반복문 탈출
			if (multinomial.charAt(idx) == 'x') {
				locationX = idx;
				break;
			}
		}
		
		// x가 존재하지 않는 경우 0을 출력
		if (locationX == -1) {
			out.write(String.valueOf(0));
			
		// x의 계수가 1인 경우 1을 출력
		} else if (locationX == 0) {
			out.write(String.valueOf(1));
			
		// x의 계수가 -1인 경우 -1을 출력
		} else if (locationX == 1 && multinomial.charAt(0) == '-') {
			out.write(String.valueOf(-1));
			
		// x의 계수가 1 또는 -1이 아닌 경우 계수를 출력
		} else {
			out.write(multinomial.substring(0, locationX));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}