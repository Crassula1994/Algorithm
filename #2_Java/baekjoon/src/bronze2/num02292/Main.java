package bronze2.num02292;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 방의 번호를 변수 roomNum에 저장
		int roomNum = Integer.parseInt(in.readLine());
		
		// 1번 방으로부터의 거리를 저장할 변수 distance 초기화
		int distance = 0;
		
		// 각 거리의 마지막 방 번호를 저장할 변수 lastRoom 초기화
		int lastRoom = 1;
		
		// do while 반복문을 사용해 주어진 방 번호까지의 거리를 순회
		do {

			// 마지막 방의 번호를 갱신
			lastRoom += 6 * distance;

			// 1번 방으로부터의 거리 조정
			distance++;

		// 입력 받은 방이 마지막 방 전에 있는 경우 반복문 탈출
		} while (roomNum > lastRoom);
		
		// valueOf() 및 write() 메서드를 사용해 입력 받은 방까지의 거리를 출력
		out.write(String.valueOf(distance));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}