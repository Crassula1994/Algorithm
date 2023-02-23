package silver4.num02839;

//필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 설탕의 양을 변수 sugar에 저장
		int sugar = Integer.parseInt(in.readLine());
		
		// 설탕 봉지의 수를 저장할 변수 packages 초기화
		int packages = 0;
		
		// while 반복문을 사용해 설탕의 양이 0이 될 때까지 순회
		while (sugar != 0) {
			
			// 설탕이 5kg으로 나누어 떨어질 경우 설탕 봉지의 수 갱신 후 반복문 탈출
			if (sugar % 5 == 0) {
				packages += sugar / 5;
				break;
			}
			
			// 3kg 봉투 하나를 덜어내고 봉지의 수 갱신
			sugar -= 3;
			packages++;
			
			// 설탕이 3kg 또는 5kg으로 나누어 떨어지지 않는 경우 설탕 봉지의 수를 -1로 설정 후 반복문 탈출
			if (0 < sugar && 3 > sugar) {
				packages = -1;
				break;
			}
		}
				
		// valueOf() 및 write() 메서드를 사용해 설탕 봉지의 수를 출력
		out.write(String.valueOf(packages));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}