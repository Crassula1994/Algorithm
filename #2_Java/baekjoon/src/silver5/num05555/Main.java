package silver5.num05555;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 찾고자 하는 문자열 및 반지의 개수를 각 변수에 할당
		String targetString = in.readLine();
		int ringNum = Integer.parseInt(in.readLine());
		
		// 찾고자 하는 문자열을 포함하는 반지의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 반지를 순회
		for (int ring = 0; ring < ringNum; ring++) {
			
			// readLine() 메서드를 사용해 해당 반지에 새겨진 문자열을 변수 ringString에 할당
			String ringString = in.readLine();
			
			// 잘린 문자열이 있는지 확인하기 위해 해당 반지에 새겨진 문자열을 한 번 더 입력
			ringString += ringString;
			
			// 해당 문자열에 찾고자 하는 문자열이 포함된 경우 찾고자 하는 문자열을 포함하는 반지의 개수 갱신
			if (ringString.contains(targetString))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 찾고자 하는 문자열을 포함하는 반지의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}