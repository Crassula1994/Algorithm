package silver5.num27964;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 토핑의 개수를 변수 toppingNum에 할당
		int toppingNum = Integer.parseInt(in.readLine());
		
		// 치즈로 되어 있는 토핑을 저장할 Set 객체 cheeses 초기화
		Set<String> cheeses = new HashSet<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 토핑을 순회
		for (int t = 0; t < toppingNum; t++) {
			
			// nextToken() 메서드를 사용해 입력 받은 토핑을 변수 topping에 할당
			String topping = st.nextToken();
			
			// 해당 토핑이 치즈 토핑이 아닌 경우 다음 토핑을 순회
			if (topping.length() < 6 || !topping.endsWith("Cheese"))
				continue;
			
			// add() 메서드를 사용해 치즈 토핑을 cheese에 추가
			cheeses.add(topping);
		}

		// 해당 치즈 토핑으로 콰트로치즈 피자를 만들 수 있는 경우 'yummy' 출력
		if (cheeses.size() >= 4) {
			out.write("yummy");
		
		// 해당 치즈 토핑으로 콰트로치즈 피자를 만들 수 없는 경우 'sad' 출력
		} else {
			out.write("sad");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}