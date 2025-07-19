package bronze5.num32326;

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
		
		// 식사의 총 비용을 저장할 변수 totalCost 초기화
		int totalCost = 0;
		
		// for 반복문을 사용해 식사의 총 비용을 갱신
		for (int price = 3; price <= 5; price++)
			totalCost += Integer.parseInt(in.readLine()) * price;
		
		// valueOf() 및 write() 메서드를 사용해 식사의 총 비용을 출력
		out.write(String.valueOf(totalCost));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}