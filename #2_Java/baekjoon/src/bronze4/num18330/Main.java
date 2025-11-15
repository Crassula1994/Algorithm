package bronze4.num18330;

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
		
		/* readLine() 및 parseInt() 메서드를 사용해 입력 받은 다음 달 휘발유 사용량
		및 이번 달 마히야의 연료 카드에 남아 있는 한도를 각 변수에 할당 */
		int nextUsage = Integer.parseInt(in.readLine());
		int remains = Integer.parseInt(in.readLine());
		
		// 마히야가 다음 달에 내야 하는 휘발유 값을 저장할 변수 totalCost 초기화
		int totalCost = 0;
		
		// 다음 달에 한도를 초과하는 경우 마히야가 다음 달에 내야 하는 휘발유 값을 갱신
		if (nextUsage > remains + 60) {
			totalCost += (remains + 60) * 1500;
			totalCost += (nextUsage - remains - 60) * 3000;
			
		// 다음 달에 한도를 초과하지 않는 경우 마히야가 다음 달에 내야 하는 휘발유 값을 갱신
		} else {
			totalCost += nextUsage * 1500;
		}
		
		// valueOf() 및 write() 메서드를 사용해 마히야가 다음 달에 내야 하는 휘발유 값을 출력
		out.write(String.valueOf(totalCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}