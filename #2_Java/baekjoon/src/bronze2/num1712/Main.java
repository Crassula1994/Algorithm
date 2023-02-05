package bronze2.num1712;

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
		
		// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 비용 및 가격을 각 변수에 저장
		long fixedCost = Long.parseLong(st.nextToken());
		long variableCost = Long.parseLong(st.nextToken());
		long price = Long.parseLong(st.nextToken());
		
		// 손익분기점이 존재하지 않는 경우 -1 출력
		if (variableCost >= price) {
			out.write(String.valueOf(-1));

		// 손익분기점이 존재하는 경우
		} else {
			
			// 손익분기점을 계산해 변수 breakEvenPoint에 할당
			long breakEvenPoint = fixedCost / (price - variableCost) + 1;
			
			// valueOf() 및 wirte() 메서드를 사용해 손익분기점 출력
			out.write(String.valueOf(breakEvenPoint));
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}