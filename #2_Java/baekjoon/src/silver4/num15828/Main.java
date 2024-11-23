package silver4.num15828;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 버퍼의 크기를 변수 bufferSize에 할당
		int bufferSize = Integer.parseInt(in.readLine());
		
		// 현재 라우터에 남아있는 패킷의 정보를 저장할 Queue 객체 router 초기화
		Queue<Integer> router = new LinkedList<>();
		
		// while 반복문을 사용해 라우터가 처리할 각 정보를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 라우터가 처리해야 할 정보를 변수 packet에 할당
			int packet = Integer.parseInt(in.readLine());
			
			// 입력이 끝난 경우 반복문 탈출
			if (packet == -1)
				break;
			
			// 라우터가 패킷 하나를 처리한 경우 라우터에서 해당 패킷을 제거 후 다음 정보를 순회
			if (packet == 0) {
				router.poll();
				continue;
			}
			
			// 버퍼가 가득 찬 경우 다음 정보를 순회
			if (router.size() == bufferSize)
				continue;
				
			// add() 메서드를 사용해 해당 번호의 패킷을 router에 저장
			router.add(packet);
		}
		
		// 라우터가 비어 있는 경우 'empty'를 출력
		if (router.isEmpty()) {
			out.write("empty");
			
		// 라우터가 비어 있지 않은 경우
		} else {
			
			// for 반복문을 사용해 라우터에 남아 있는 패킷을 출력
			for (int packet : router)
				out.write(packet + " ");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}