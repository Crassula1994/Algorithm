package bronze3.num14215;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 삼각형의 변을 각 변수에 할당
		int sideA = Integer.parseInt(st.nextToken());
		int sideB = Integer.parseInt(st.nextToken());
		int sideC = Integer.parseInt(st.nextToken());
		
		// max() 메서드를 사용해 가장 긴 변의 길이를 변수 maxSide에 할당
		int maxSide = Math.max(Math.max(sideA, sideB), sideC);
		
		// 삼각형의 둘레를 저장할 변수 sideSum 초기화
		int sideSum = sideA + sideB + sideC;
			
		// 삼각형인 경우 삼각형의 둘레를 출력
		if (sideSum - maxSide > maxSide) {
			out.write(String.valueOf(sideSum));

		// 삼각형이 아닌 경우 삼각형의 조건을 만족하는 값을 출력
		} else {
			out.write(String.valueOf(2 * (sideSum - maxSide) - 1));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
    }
}