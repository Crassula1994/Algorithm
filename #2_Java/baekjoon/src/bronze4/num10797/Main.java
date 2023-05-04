package bronze4.num10797;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 주어진 날짜를 변수 date에 할당
		int date = Integer.parseInt(in.readLine());
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 차량 10부제를 위반하는 차량의 대수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 자동차 번호를 순회
		for (int num = 0; num < 5; num++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 자동차 번호를 변수 carNum에 할당
			int carNum = Integer.parseInt(st.nextToken());
			
			// 차량 10부제를 위반한 경우 위반 차량 대수를 갱신
			if (date == carNum)
				count++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 차량 10부제를 위반하는 차량의 대수를 출력
		out.write(String.valueOf(count));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}