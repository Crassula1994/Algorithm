package bronze4.num20673;

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
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 하나의 도시에서 나온 하루 신규 확진 수의 평균
		및 하루 신규 입원 수의 평균을 각 변수에 할당 */
		int avgCaseCount = Integer.parseInt(in.readLine());
		int avgHospCount = Integer.parseInt(in.readLine());
		
		// 도시의 색상 코드가 하양인 경우 'White'를 출력
		if (avgCaseCount <= 50 && avgHospCount <= 10) {
			out.write("White");
			
		// 도시의 색상 코드가 빨강인 경우 'Red'를 출력
		} else if (avgHospCount > 30) {
			out.write("Red");
			
		// 도시의 색상 코드가 노랑인 경우 'Yellow'를 출력
		} else {
			out.write("Yellow");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}