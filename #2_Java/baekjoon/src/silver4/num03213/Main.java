package silver4.num03213;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 친구의 수를 변수 friendNum에 할당
		int friendNum = Integer.parseInt(in.readLine());
		
		// 각 피자의 양을 먹을 수 있는 친구의 수, 피자를 시켜야 하는 양을 저장할 각 변수 초기화
		int oneQuarter = 0;
		int oneHalf = 0;
		int threeQuarter = 0;
		int pizzaNum = 0;
		
		// for 반복문을 사용해 각 친구의 먹는 양을 순회
		for (int friend = 0; friend < friendNum; friend++) {
			
			// readLine() 메서드를 사용해 입력 받은 친구의 먹는 양을 변수 intake에 할당
			String intake = in.readLine();
			
			// switch 조건문을 사용해 각 피자의 양을 먹을 수 있는 친구의 수를 갱신
			switch (intake) {
				case "1/4":
					oneQuarter++;
					break;
				case "1/2":
					oneHalf++;
					break;
				default:
					threeQuarter++;
					break;
			}
		}
		
		// 4분의 3 조각을 먹는 친구를 고려해 피자를 시켜야 하는 양을 갱신
		pizzaNum += threeQuarter;
		
		// max() 메서드를 사용해 4분의 1 조각을 먹는 친구의 수를 갱신
		oneQuarter = Math.max(0, oneQuarter - threeQuarter);
		
		// 2분의 1 조각을 먹는 친구를 고려해 피자를 시켜야 하는 양을 갱신
		pizzaNum += oneHalf / 2;
		
		// 2분의 1 조각을 먹는 친구 1명이 남는 경우 피자를 시켜야 하는 양 및 4분의 1 조각을 먹는 친구의 수를 갱신
		if (oneHalf % 2 == 1) {
			pizzaNum++;
			oneQuarter = Math.max(0, oneQuarter - 2);
		}
		
		// 4분의 1 조각을 먹는 친구를 고려해 피자를 시켜야 하는 양을 갱신
		pizzaNum = (oneQuarter % 4 == 0) ? pizzaNum + oneQuarter / 4 : pizzaNum + oneQuarter / 4 + 1;
		
		// valueOf() 및 write() 메서드를 사용해 피자를 시켜야 하는 양을 출력
		out.write(String.valueOf(pizzaNum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}