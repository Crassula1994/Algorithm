package silver3.num02606;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 웜 바이러스에 걸리게 되는 컴퓨터의 수를 저장할 변수 count 초기화
	static int count = 0;
	
	// 각 컴퓨터의 감염 확인을 위해 필요한 각 배열 초기화
	static boolean[][] connection;
	static boolean[] infected;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 컴퓨터의 수와 컴퓨터 쌍의 수를 각 변수에 할당
		int comCnt = Integer.parseInt(in.readLine());
		int connCnt = Integer.parseInt(in.readLine());
		
		// 각 컴퓨터의 연결 정보를 저장할 2차원 배열 connection 초기화
		connection = new boolean[comCnt + 1][comCnt + 1];
		
		// 각 컴퓨터의 감염 확인 여부를 저장할 배열 infected 초기화
		infected = new boolean[comCnt + 1];

		// for 반복문을 사용해 각 네트워크 연결을 순회
		for (int conn = 0; conn < connCnt; conn++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 연결 정보를 각 변수에 할당
			int fromCom = Integer.parseInt(st.nextToken());
			int toCom = Integer.parseInt(st.nextToken());
			
			// 연결 정보를 갱신
			connection[fromCom][toCom] = true;
			connection[toCom][fromCom] = true;
		}
		
		// infectedCounter() 메서드를 호출해 웜 바이러스에 걸리게 되는 컴퓨터의 수 갱신
		infectedCounter(1);
		
		// valueOf() 및 write() 메서드를 사용해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 1번 컴퓨터 제외 후 출력
		out.write(String.valueOf(count - 1));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// infectedCounter() 메서드 정의
	public static void infectedCounter(int startCom) {
		
		// 첫 시작 컴퓨터 감염 처리 및 개수 갱신
		infected[startCom] = true;
		count++;
		
		// for 반복문을 사용해 연결된 컴퓨터 순회
		for (int c = 0; c < connection.length; c++) {
			
			// 컴퓨터와 연결되어 있고 감염 처리가 되지 않은 경우 infectedCounter() 메서드 재귀 호출
			if (connection[startCom][c] && !infected[c])
				infectedCounter(c);
		}
	}
}