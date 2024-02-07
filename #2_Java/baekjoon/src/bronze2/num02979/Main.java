package bronze2.num02979;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 주차 요금을 각 변수에 할당
		int costA = Integer.parseInt(st.nextToken());
		int costB = Integer.parseInt(st.nextToken());
		int costC = Integer.parseInt(st.nextToken());
		
		// 해당 시간에 각 트럭이 존재했는지를 나타내는 2차원 배열 parkingLot 초기화
		boolean[][] parkingLot = new boolean[3][100];
		
		// for 반복문을 사용해 각 트럭의 시간 정보를 순회
		for (int truck = 0; truck < 3; truck++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 시간 정보를 각 변수에 할당
			int timeIn = Integer.parseInt(st.nextToken());
			int timeOut = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 해당 트럭의 주차장 주차 여부를 갱신
			for (int t = timeIn; t < timeOut; t++)
				parkingLot[truck][t] = true;
		}
		
		// 상근이가 내야 하는 주차 요금을 저장할 변수 parkingCharge 초기화
		int parkingCharge = 0;
		
		// for 반복문을 사용해 주차장의 각 시간을 순회
		for (int t = 1; t < 100; t++) {
			
			// 트럭의 대수를 저장할 변수 count 초기화
			int count = 0;
			
			// for 반복문을 사용해 각 트럭의 주차장 주차 여부를 순회
			for (int truck = 0; truck < 3; truck++) {
				
				// 트럭이 존재하는 경우 트럭의 대수를 갱신
				if (parkingLot[truck][t])
					count++;
			}
			
			// switch 조건문을 사용해 트럭 대수에 따라 주차 요금을 갱신
			switch (count) {
				case 1:
					parkingCharge += costA;
					break;
				case 2:
					parkingCharge += costB * 2;
					break;
				case 3:
					parkingCharge += costC * 3;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 상근이가 내야 하는 주차 요금을 출력
		out.write(String.valueOf(parkingCharge));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}