package bronze5.num34443;

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
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 참여할 해커톤 횟수
		및 해커톤 1회당 학생들이 평균적으로 얻는 상품 가치를 각 변수에 할당 */
		int hackathonNum = Integer.parseInt(in.readLine());
		in.readLine();
		int unitValue = Integer.parseInt(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 학생들이 해커톤에서 기대할 수 있는 총 상품 가치를 출력
		out.write(String.valueOf(hackathonNum * unitValue));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}