package silver2.num15787;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 기차의 수와 명령의 수를 각 변수에 할당
		int trainNum = Integer.parseInt(st.nextToken());
		int commandNum = Integer.parseInt(st.nextToken());
		
		// 각 기차에 탑승한 승객이 앉은 상태를 저장할 배열 trainSeats 초기화
		int[] trainSeats = new int[trainNum];
		
		// 기차에 승객이 앉은 상태를 기록한 목록을 나타낼 Set 객체 trainList 초기화
		Set<Integer> trainList = new HashSet<>();
		
		// while 반복문을 사용해 각 명령을 순회
		while (commandNum-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 명령의 종류, 기차의 번호, 좌석의 번호를 각 변수에 할당
			int category = Integer.parseInt(st.nextToken());
			int targetTrain = Integer.parseInt(st.nextToken()) - 1;
			int targetSeat = (category < 3) ? Integer.parseInt(st.nextToken()) - 1 : 0;
			
			// switch 조건문을 사용해 각 명령을 순회
			switch (category) {
			
				// 1번 명령인 경우 해당 좌석에 사람을 태운 것으로 처리
				case 1:
					trainSeats[targetTrain] |= 1 << targetSeat;
					break;
					
				// 2번 명령인 경우 해당 좌석의 사람이 하차한 것으로 처리
				case 2:
					trainSeats[targetTrain] &= ~(1 << targetSeat);
					break;
					
				// 3번 명령인 경우 가장 마지막 좌석의 사람이 하차하고 한 칸씩 사람들이 뒤로 이동하여 앉은 것으로 처리
				case 3:
					trainSeats[targetTrain] &= ~(1 << 19);
					trainSeats[targetTrain] <<= 1;
					break;
					
				// 4번 명령인 경우 한 칸씩 사람들이 앞으로 이동하여 앉은 것으로 처리
				default:
					trainSeats[targetTrain] >>= 1;
			}
		}
		
		// for 반복문을 사용해 각 기차의 승객이 앉은 상태를 trainList에 저장
		for (int train : trainSeats) 
			trainList.add(train);
		
		// size(), valueOf(), write() 메서드를 사용해 은하수를 건널 수 있는 기차의 수를 출력
		out.write(String.valueOf(trainList.size()));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}