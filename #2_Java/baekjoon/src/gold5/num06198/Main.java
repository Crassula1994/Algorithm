package gold5.num06198;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// Main 클래스 정의
public class Main {

	// Building 클래스 정의
	public static class Building {
		
		// 빌딩의 번호와 높이를 저장할 각 변수 초기화
		int number;
		int height;
		
		// 인자를 입력 받는 생성자 정의
		public Building(int number, int height) {
			this.number = number;
			this.height = height;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 빌딩의 수를 변수 buildingNum에 할당
		int buildingNum = Integer.parseInt(in.readLine());
		
		// 각 관리인이 벤치마킹할 수 있는 빌딩의 수의 합을 저장할 변수 sum 초기화
		long sum = 0;
		
		// 각 빌딩의 높이에 따라 벤치마킹할 빌딩의 수를 확인할 Stack 객체 buildings 초기화
		Stack<Building> buildings = new Stack<>();
		
		// for 반복문을 사용해 각 빌딩을 순회
		for (int number = 1; number <= buildingNum; number++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 빌딩의 높이를 변수 height에 할당
			int height = Integer.parseInt(in.readLine());
			
			// buildings가 비어 있지 않고 buildings에 저장된 빌딩보다 높이가 같거나 더 높은 경우
			if (!buildings.isEmpty() && buildings.peek().height <= height) {
				
				// while 반복문을 사용해 buildings가 빌 때까지 순회
				while (!buildings.isEmpty()) {
					
					// 저장된 빌딩보다 높이가 더 낮아진 경우 반복문 탈출
					if (buildings.peek().height > height)
						break;
					
					// pop() 메서드를 사용해 벤치마킹할 수 있는 빌딩의 수의 합을 갱신
					sum += number - buildings.pop().number - 1;
				}
			}
			
			// add() 메서드를 사용해 해당 빌딩을 buildings에 추가
			buildings.add(new Building(number, height));
		}
		
		// while 반복문을 사용해 벤치마킹할 수 있는 빌딩의 수의 합을 갱신
		while (!buildings.isEmpty())
			sum += buildingNum - buildings.pop().number;
		
		// valueOf() 및 write() 메서드를 사용해 관리인이 벤치마킹할 수 있는 빌딩의 수의 합을 출력
		out.write(String.valueOf(sum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}