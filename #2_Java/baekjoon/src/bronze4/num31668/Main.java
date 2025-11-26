package bronze4.num31668;

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
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 파묻튀밥 한 줄에 들어가는 파묻튀의 양,
		학교가 파묻튀를 사용한 양, 파묻튀밥 한 줄에 필요한 가지의 양을 각 변수에 할당 */
		int unitAmount = Integer.parseInt(in.readLine());
		int totalAmount = Integer.parseInt(in.readLine());
		int exchangeAmount = Integer.parseInt(in.readLine());
		
		// valueOf() 및 write() 메서드를 사용해 학생들이 구매해야 하는 가지의 양의 최솟값을 출력
		out.write(String.valueOf(totalAmount / unitAmount * exchangeAmount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}