package bronze1.num11018;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이슬르 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken(), parseInt(), parseDouble() 메서드를 사용해 입력 받은 로켓 단의 수 및 로켓 자체의 무게를 각 변수에 할당
			int stageNum = Integer.parseInt(st.nextToken());
			double rocketWeight = Double.parseDouble(st.nextToken());
			
			// 현재 로켓의 속도 및 높이를 저장할 각 변수 초기화
			double velocity = 0;
			double height = 0;
			
			// 각 로켓 단의 무게, 지속 시간, 추진력의 양을 저장할 2차원 배열 stages 초기화
			double[][] stages = new double[stageNum][3];
			
			// for 반복문을 사용해 각 로켓 단의 정보를 순회
			for (int idx = 0; idx < stageNum; idx++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 재할당
				st = new StringTokenizer(in.readLine());
				
				// nextToken() 및 parseDouble() 메서드를 사용해 입력 받은 로켓 단의 정보를 2차원 배열 stages에 저장
				stages[idx][0] = Double.parseDouble(st.nextToken());
				stages[idx][1] = Double.parseDouble(st.nextToken());
				stages[idx][2] = Double.parseDouble(st.nextToken());
				
				// 로켓 자체의 무게를 갱신
				rocketWeight += stages[idx][0];
			}
			
			// for 반복문을 사용해 각 로켓 단을 순회
			for (int idx = 0; idx < stageNum; idx++) {
				
				// 해당 로켓 단의 추진력에 의한 로켓의 가속도를 계산해 변수 acceleration에 할당
				double acceleration = stages[idx][2] / rocketWeight - 9.81;
				
				// 해당 로켓 단이 분리된 이후 로켓의 현재 높이, 속도, 무게를 갱신
				height += velocity * stages[idx][1] + 0.5 * acceleration * stages[idx][1] * stages[idx][1];
				velocity += acceleration * stages[idx][1];
				rocketWeight -= stages[idx][0];
			}
			
			// format() 및 write() 메서드를 사용해 로켓의 마지막 단이 분리되었을 때의 높이를 출력
			out.write(String.format("Data Set %d:\n%.2f\n\n", tc, height));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}