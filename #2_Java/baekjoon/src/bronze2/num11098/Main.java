package bronze2.num11098;

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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 선수의 수를 변수 playerNum에 할당
			int playerNum = Integer.parseInt(in.readLine());
			
			// 가장 비싼 선수의 이름 및 가격을 저장할 각 변수 초기화
			int maxPrice = Integer.MIN_VALUE;
			String newPlayer = "";
			
			// for 반복문을 사용해 입력 받은 각 선수의 정보를 순회
			for (int player = 0; player < playerNum; player++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseInt() 메서드를 사용해 각 선수의 가격과 이름을 각 변수에 할당
				int price = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				
				// 저장된 가장 비싼 선수보다 비싼 선수인 경우 가장 비싼 선수의 이름 및 가격을 갱신
				if (price > maxPrice) {
					maxPrice = price;
					newPlayer = name;
				}
			}
			
			// write() 메서드를 사용해 가장 비싼 선수의 이름을 출력
			out.write(newPlayer + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}