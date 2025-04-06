package bronze1.num02896;

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
		
		// 만들 수 있는 최대 칵테일의 양을 저장할 maxAmount 초기화
		double maxAmount = Integer.MAX_VALUE;
		
		// 각 주스를 구매한 양 및 칵테일을 만드는 데 필요한 주스의 비율을 저장할 각 배열 초기화
		double[] purchaseAmount = new double[3];
		double[] proportions = new double[3];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 주스를 구매한 양을 배열 purchaseAmount에 저장
		for (int idx = 0; idx < purchaseAmount.length; idx++)
			purchaseAmount[idx] = Double.parseDouble(st.nextToken());
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 칵테일을 만드는 데 필요한 주스의 비율을 순회
		for (int idx = 0; idx < 3; idx++) {
			
			// nextToken() 및 parseDouble() 메서드를 사용해 칵테일을 만드는 데 필요한 주스의 비율을 배열 proportions에 저장
			proportions[idx] = Double.parseDouble(st.nextToken());
			
			// min() 메서드를 사용해 만들 수 있는 최대 칵테일의 양을 갱신
			maxAmount = Math.min(purchaseAmount[idx] / proportions[idx], maxAmount);
		}
		
		// for 반복문을 사용해 각 주스가 얼만큼 남는지를 출력
		for (int idx = 0; idx < 3; idx++)
			out.write(String.format("%.6f ", purchaseAmount[idx] - maxAmount * proportions[idx]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}