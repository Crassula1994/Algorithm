package bronze4.num20233;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 두 선택지의 각 가격과 매일 자전거를 이용한 시간을 각 변수에 할당
		int fixedCostA = Integer.parseInt(in.readLine());
		int variableCostA = Integer.parseInt(in.readLine());
		int fixedCostB = Integer.parseInt(in.readLine());
		int variableCostB = Integer.parseInt(in.readLine());
		int commuteTime = Integer.parseInt(in.readLine());
		
		// max() 메서드를 사용해 각 선택지를 선택했을 때 지불해야 하는 금액을 각 변수에 할당
		int totalCostA = fixedCostA + Math.max(variableCostA * (commuteTime - 30), 0) * 21;
		int totalCostB = fixedCostB + Math.max(variableCostB * (commuteTime - 45), 0) * 21;
		
		// write() 메서드를 사용해 각 선택지를 선택했을 때 지불해야 하는 금액을 출력
		out.write(totalCostA + " " + totalCostB);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}