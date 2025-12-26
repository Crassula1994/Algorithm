package bronze4.num31822;

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

		/* readLine(), substring(), parseInt() 메서드를 사용해 입력 받은 재수강할 과목의 과목 코드의 앞 5자리와
		신청 가능한 과목의 개수를 각 변수에 할당 */
		String targetCode = in.readLine().substring(0, 5);
		int lectureNum = Integer.parseInt(in.readLine());
		
		// 재수강으로 인정되는 과목의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 각 과목 코드를 순회
		while (lectureNum-- > 0) {
			
			// 입력 받은 과목 코드의 앞 5자리가 재수강할 과목과 일치하는 경우 재수강으로 인정되는 과목의 개수를 갱신
			if (in.readLine().startsWith(targetCode))
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 재수강으로 인정되는 과목의 개수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}