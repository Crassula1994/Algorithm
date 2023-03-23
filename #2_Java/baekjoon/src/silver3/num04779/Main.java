package silver3.num04779;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// 전체 문자열을 저장할 배열 string 초기화
	static char[] string;
	
    // ----------------------------------------------------------------------------------------------------
	
    // main() 메서드 정의
    public static void main(String[] args) throws IOException {
     
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// while 반복문을 사용해 모든 줄의 입력을 순회
		while (true) {
			
			// 3의 지수를 저장할 변수 초기화
			int exponent = 0;
			
			// 예외가 발생하지 않는 경우 readLine() 및 parseInt() 메서드를 사용해 입력 받은 3의 지수를 변수 power에 할당
			try {
				exponent = Integer.parseInt(in.readLine());		
			
			// 예외가 발생하는 경우 반복문 탈출
			} catch (NumberFormatException e) {
				break;
			}

			// pow() 메서드를 사용해 전체 문자열의 길이를 계산하고 변수 stringLen에 할당
			int stringLen = (int) Math.pow(3, exponent);
			
			// 전체 문자열을 저장할 배열 string 초기화
			string = new char[stringLen];
			
			// fill() 메서드를 사용해 string 배열의 초기값을 '-'로 초기화
			Arrays.fill(string, '-');
			
			// cantorSetMaker() 메서드를 호출해 칸토어 집합을 생성
			cantorSetMaker(0, stringLen);

			// for 반복문을 사용해 문자열을 차례로 출력
			for (int idx = 0; idx < stringLen; idx++)
				out.write(string[idx]);
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }

    // ----------------------------------------------------------------------------------------------------
    
    // cantorSetMaker() 메서드 정의
    public static void cantorSetMaker(int startIdx, int length) {

    	// 길이가 3 미만인 경우 메서드 종료
    	if (length < 3)
    		return;
    	
    	// 해당 길이를 3등분한 새로운 길이를 변수 newLength에 할당
    	int newLength = length / 3;
    	
    	// for 반복문을 사용해 해당 위치를 3등분한 부분의 가운데 부분을 빈 칸으로 변경
    	for (int idx = startIdx + newLength; idx < startIdx + newLength * 2; idx++)
    		string[idx] = ' ';
    	
    	// cantorSetMaker() 메서드 재귀 호출
    	cantorSetMaker(startIdx, newLength);
    	cantorSetMaker(startIdx + newLength * 2, newLength);
	}
}