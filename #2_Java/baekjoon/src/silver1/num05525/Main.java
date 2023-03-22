package silver1.num05525;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 I와 O로 이루어진 문자열 중 O의 개수, 주어진 문자열의 길이를 각 변수에 할당
		int oCount = Integer.parseInt(in.readLine());
		int stringLength = Integer.parseInt(in.readLine());
		
		// 찾고자 하는 I와 O로 이루어진 문자열을 저장할 변수 targetString 초기화
		String targetString = "I";
		
		// for 반복문을 사용해 교대로 나오는 문자열을 저장
		for (int o = 0; o < oCount; o++)
			targetString += "OI";
		
		// readLine() 메서드를 사용해 입력 받은 문자열을 변수 string에 할당
		String string = in.readLine();
		
		// 해당 문자열이 포함된 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 입력 받은 문자열의 부분 문자열을 차례로 순회
		for (int idx = 0; idx < stringLength - targetString.length(); idx++) {
			
			// substring() 메서드를 사용해 부분 문자열을 변수 subString에 할당
			String subString = string.substring(idx, idx + targetString.length());
			
			// 해당 부분 문자열이 찾고자 하는 문자열과 같은 경우 문자열이 포함된 개수를 갱신
			if (subString.equals(targetString))
				count++;
		}

		// valueOf() 및 write() 메서드를 사용해 해당 문자열이 포함된 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}