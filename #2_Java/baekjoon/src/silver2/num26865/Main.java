package silver2.num26865;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 컴퓨터의 수 및 허브의 포트 수를 각 변수에 할당
		int computerNum = Integer.parseInt(st.nextToken());
		int portNum = Integer.parseInt(st.nextToken());
		
		// 가능한 최소 네트워크 지연 시간을 저장할 변수 minLatency 초기화
		int minLatency = 0;
		
		// 각 컴퓨터의 데이터 전송 시간 및 각 포트에서의 지연 시간을 저장할 각 배열 초기화
		int[] transferTimes = new int[computerNum];
		int[] ports = new int[portNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 컴퓨터의 데이터 전송 시간을 배열 transferTimes에 저장
		for (int idx = 0; idx < transferTimes.length; idx++)
			transferTimes[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 각 컴퓨터의 데이터 전송 시간을 오름차순으로 정렬
		Arrays.sort(transferTimes);
		
		// for 반복문을 사용해 각 컴퓨터의 데이터 전송 시간을 순회
		for (int idx = 0, curPort = 0; idx < transferTimes.length; idx++) {
			
			// 현재 컴퓨터를 현재 허브의 포트에 연결
			ports[curPort] += transferTimes[idx];
			
			// 가능한 최소 네트워크 지연 시간을 갱신
			minLatency += ports[curPort];
			
			// 다음에 연결할 포트를 갱신
			curPort = (curPort + 1) % portNum;
		}
		
		// valueOf() 및 write() 메서드를 사용해 가능한 최소 네트워크 지연 시간을 출력
		out.write(String.valueOf(minLatency));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}