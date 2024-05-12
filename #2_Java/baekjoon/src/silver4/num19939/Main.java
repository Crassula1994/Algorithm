package silver4.num19939;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 공의 개수와 바구니의 개수를 각 변수에 할당
		int ballNum = Integer.parseInt(st.nextToken());
		int basketNum = Integer.parseInt(st.nextToken());
		
		// for 반복문을 사용해 각 바구니를 순회
		for (int basket = 1; basket <= basketNum; basket++) {
			
			// 바구니에 담고 남은 공의 개수를 갱신
			ballNum -= basket;
			
			// 바구니에 더 이상 공을 나눠 담을 수 없는 경우 반복문 탈출
			if (ballNum < 0)
				break;
		}
		
		// 바구니에 더 이상 공을 나눠 담을 수 없는 경우 -1을 출력
		if (ballNum < 0) {
			out.write(String.valueOf(-1));
			
		// 바구니에 공을 나눠 담을 수 있는 경우
		} else {
			
			// 모든 바구니에 골고루 남은 공을 나눌 수 있는지 여부에 따라 공의 개추 차이를 계산해 변수 difference에 할당
			int difference = (ballNum % basketNum == 0) ? basketNum - 1 : basketNum;
			
			// valueOf() 및 write() 메서드를 사용해 가장 많이 담긴 바구니와 적게 담긴 바구니의 공의 개수를 출력
			out.write(String.valueOf(difference));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}