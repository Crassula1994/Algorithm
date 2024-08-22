package silver4.num26934;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 한 번에 충전할 수 있는 금액을 저장할 배열 charges 초기화
	static int[] charges = {500, 200, 100};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 여행하는 데 필요한 금액을 변수 totalCost에 할당
		int totalCost = Integer.parseInt(in.readLine());
		
		// 충전한 금액이 남는 경우 여행하는 데 필요한 금액을 갱신
		if (totalCost % 100 != 0)
			totalCost = (totalCost / 100 + 1) * 100;
		
		// 버스 카드를 충전할 최소 횟수를 저장할 변수 minCount 초기화
		int minCount = 0;
		
		// for 반복문을 사용해 버스 카드를 충전할 최소 횟수 및 남은 금액을 갱신
		for (int charge : charges) {
			minCount += totalCost / charge;
			totalCost %= charge;
		}
		
		// valueOf() 및 write() 메서드를 사용해 버스 카드를 충전할 최소 횟수를 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}