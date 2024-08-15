package silver5.num24753;

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
		
		// 좌석에 더 앉을 수 있는 친구의 수의 최댓값을 저장할 변수 maxCount 초기화
		int maxCount = 0;
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 좌석의 수 및 이미 좌석에 앉은 사람의 수를 각 변수에 할당
		int seatNum = Integer.parseInt(st.nextToken());
		int occupiedNum = Integer.parseInt(st.nextToken());
		
		// 각 좌석의 점유 상태를 저장할 배열 seats 초기화
		boolean[] seats = new boolean[seatNum + 1];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 점유된 자리를 갱신
		for (int occupied = 0; occupied < occupiedNum; occupied++)
			seats[Integer.parseInt(st.nextToken())] = true;
		
		// for 반복문을 사용해 각 자리를 순회
		for (int idx = 1; idx < seats.length; idx++) {
			
			// 이미 해당 좌석에 사람이 있는 경우 다음 자리를 순회
			if (seats[idx])
				continue;
			
			// 좌석의 왼쪽 좌석에 이미 사람이 있는 경우 다음 자리를 순회
			if (seats[(idx == 1) ? seatNum : idx - 1])
				continue;
			
			// 좌석의 오른쪽 좌석에 이미 사람이 있는 경우 다음 자리를 순회
			if (seats[(idx == seatNum) ? 1 : idx + 1])
				continue;
			
			// 해당 좌석에 새로운 친구가 앉은 것으로 처리 및 더 앉을 수 있는 친구의 수의 최댓값을 갱신
			seats[idx] = true;
			maxCount++;
		}
		
		// valueOf() 및 write() 메서드를 사용해 좌석에 더 앉을 수 있는 친구의 수의 최댓값을 출력
		out.write(String.valueOf(maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}