package bronze3.num09325;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 자동차의 가격과 옵션의 개수를 각 변수에 할당
			int totalPrice = Integer.parseInt(in.readLine());
			int optionNum = Integer.parseInt(in.readLine());
			
			// for 반복문을 사용해 각 옵션의 정보를 순회
			for (int option = 0; option < optionNum; option++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 옵션의 개수 및 가격을 각 변수에 할당
				int quantity = Integer.parseInt(st.nextToken());
				int price = Integer.parseInt(st.nextToken());
				
				// 해당 옵션의 가격을 자동차 가격에 갱신
				totalPrice += quantity * price;
			}
			
			// write() 메서드를 사용해 자동차의 최종 가격을 출력
			out.write(totalPrice + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}