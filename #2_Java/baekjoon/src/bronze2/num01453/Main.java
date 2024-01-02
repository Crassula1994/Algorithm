package bronze2.num01453;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 손님의 수를 변수 customerNum에 할당
		int customerNum = Integer.parseInt(in.readLine());
		
		// 거절 당하는 사람의 수를 저장할 변수 count 초기화
		int count = 0;
		
		// 각 자리의 점유 현황을 저장할 배열 seats 초기화
		boolean[] seats = new boolean[101];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 손님을 순회
		for (int customer = 0; customer < customerNum; customer++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 손님이 앉고 싶어하는 자리를 변수 seat에 할당
			int seat = Integer.parseInt(st.nextToken());
			
			// 해당 자리에 사람이 있는 경우 거절 당하는 사람의 수를 갱신
			if (seats[seat]) {
				count++;
				
			// 해당 자리에 사람이 없는 경우 해당 자리를 앉아 있는 것으로 처리
			} else {
				seats[seat] = true;
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 거절 당하는 사람의 수를 출력
		out.write(String.valueOf(count));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}