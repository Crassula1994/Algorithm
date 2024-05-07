package bronze3.num31798;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 세 정수를 각 변수에 할당
		int numberA = Integer.parseInt(st.nextToken());
		int numberB = Integer.parseInt(st.nextToken());
		int numberC = Integer.parseInt(st.nextToken());
		
		// 빈 칸에 들어갈 양의 정수를 저장할 변수 answer 초기화
		int answer = 0;
		
		// 왼쪽 위의 수가 빈 칸인 경우 빈 칸에 들어갈 양의 정수를 갱신
		if (numberA == 0) {
			answer = numberC * numberC - numberB;
		
		// 오른쪽 위의 수가 빈 칸인 경우 빈 칸에 들어갈 양의 정수를 갱신
		} else if (numberB == 0) {
			answer = numberC * numberC - numberA;
			
		// 아래의 수가 빈 칸인 경우 빈 칸에 들어갈 양의 정수를 갱신
		} else {
			answer = (int) Math.sqrt(numberA + numberB);
		}
		
		// valueOf() 및 write() 메서드를 사용해 빈 칸에 들어갈 양의 정수를 출력
		out.write(String.valueOf(answer));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}