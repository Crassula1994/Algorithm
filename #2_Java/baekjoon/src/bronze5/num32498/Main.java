package bronze5.num32498;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 후보 문제의 수를 변수 problemNum에 할당
		int problemNum = Integer.parseInt(in.readLine());
		
		// 규칙에 의해 제외된 후보 문제의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 각 후보 문제를 순회
		while (problemNum-- > 0) {
			
			// 해당 문제의 난이도가 홀수인 경우 규칙에 의해 제외된 후보 문제의 수를 갱신
			if ((Integer.parseInt(in.readLine()) & 1) == 1)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 규칙에 의해 제외된 후보 문제의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}