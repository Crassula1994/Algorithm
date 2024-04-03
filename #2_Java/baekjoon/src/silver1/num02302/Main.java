package silver1.num02302;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 좌석의 개수 및 고정석의 개수를 각 변수에 할당
		int seatNum = Integer.parseInt(in.readLine());
		int fixedNum = Integer.parseInt(in.readLine());
		
		// 사람들이 좌석에 앉을 수 있는 방법의 가짓수를 저장할 변수 totalCnt 초기화
		int totalCnt = 1;
		
		// 좌석에 앉을 수 있는 방법의 가짓수를 저장할 배열 seats 초기화
		int[] seats = new int[seatNum + 1];
		
		// 좌석이 없을 때 방법의 가짓수를 초기화
		seats[0] = -1;
		
		// for 반복문을 사용해 고정석에서의 방법의 가짓수를 -1로 초기화
		for (int f = 0; f < fixedNum; f++)
			seats[Integer.parseInt(in.readLine())] = -1;
		
		// for 반복문을 사용해 각 좌석에서의 방법의 가짓수를 순회
		for (int seat = 1; seat <= seatNum; seat++) {

			// 해당 좌석이 고정석인 경우
			if (seats[seat] == -1) {
				
				// 이전 좌석이 고정석이 아닌 경우 방법의 가짓수를 갱신
				if (seats[seat - 1] != -1)
					totalCnt *= seats[seat - 1];
				
				// 다음 좌석을 순회
				continue;
			}
			
			// 이전 좌석이 고정석인 경우 방법의 가짓수를 1로 초기화
			if (seats[seat - 1] == -1) {
				seats[seat] = 1;
				
			// 이전 좌석의 방법의 가짓수가 1인 경우 방법의 가짓수를 2로 초기화
			} else if (seats[seat - 1] == 1) {
				seats[seat] = 2;
				
			// 이전 좌석이 고정석이 아니고 좌석의 방법의 가짓수가 2 이상인 경우 방법의 가짓수를 갱신
			} else {
				seats[seat] = seats[seat - 1] + seats[seat - 2];
			}
			
			// 해당 좌석이 마지막 좌석인 경우 방법의 가짓수를 갱신
			if (seat == seatNum)
				totalCnt *= seats[seat];
		}
			
		// valueOf() 및 write() 메서드를 사용해 사람들이 좌석에 앉을 수 있는 방법의 가짓수를 출력
		out.write(String.valueOf(totalCnt));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}