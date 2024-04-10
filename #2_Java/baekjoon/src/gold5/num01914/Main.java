package gold5.num01914;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Main 클래스 정의
public class Main {
	
	// 하노이의 탑을 옮긴 순서를 저장할 List 객체 orders 초기화
	static List<Order> orders = new ArrayList<>();
	
	// Order 클래스 정의
	public static class Order {
		
		// 원판의 옮기는 위치를 나타낼 각 변수 초기화
		int start;
		int end;
		
		// 인자를 입력 받는 생성자 정의
		public Order(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 원판의 개수를 변수 diskNum에 할당
		int diskNum = Integer.parseInt(in.readLine());
		
		// pow() 및 subtract() 메서드를 사용해 하노이의 탑을 옮긴 횟수를 변수 count에 저장
		BigInteger count = new BigInteger("2").pow(diskNum).subtract(new BigInteger("1"));
		
		// toString() 및 write() 메서드를 사용해 원판을 옮긴 횟수를 출력
		out.write(count.toString());
		
		// 원판의 개수가 20개 이하인 경우
		if (diskNum <= 20) {
			
			// towerHanoi() 메서드를 호출해 수행 과정을 차례로 orders에 저장
			towerHanoi(diskNum, 1, 3, 2);
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
			
			// for 반복문을 사용해 각 수행 과정을 차례로 출력
			for (int idx = 0; idx < orders.size(); idx++)
				out.write(orders.get(idx).start + " " + orders.get(idx).end + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// towerHanoi() 메서드 정의
	public static void towerHanoi(int diskNum, int start, int end, int mid) {
		
		// 원판이 1개인 경우 orders에 수행 과정 추가
		if (diskNum == 1) {
			orders.add(new Order(start, end));
			
		// 원판이 1개가 아닌 경우
		} else {
			
			// 가장 밑 원반을 제외한 다른 원반을 중간 막대로 옮기는 towerHanoi() 메서드 재귀 호출
			towerHanoi(diskNum - 1, start, mid, end);
			
			// add() 메서드를 사용해 orders에 수행 과정 추가
			orders.add(new Order(start, end));
			
			// 중간 막대에 있는 나머지 원반을 목표 막대로 옮기는 towerHanoi() 메서드 재귀 호출
			towerHanoi(diskNum - 1, mid, end, start);
		}
	}
}