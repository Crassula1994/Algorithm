package bronze1.num18229;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수, 손을 뻗는 횟수, 점원까지의 거리를 각 변수에 할당
		int customerNum = Integer.parseInt(st.nextToken());
		int stretchCount = Integer.parseInt(st.nextToken());
		int targetDistance = Integer.parseInt(st.nextToken());
		
		// 결제한 사람 및 해당 사람이 손을 뻗은 횟수를 저장할 각 변수 초기화
		int payer = 0;
		int minCount = stretchCount + 1;
		
		// for 반복문을 사용해 각 사람을 순회
		outer: for (int customer = 1; customer <= customerNum; customer++) {
			
			// 현재 사람이 손을 뻗은 거리를 저장할 변수 distance 초기화
			int distance = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 손을 뻗은 횟수를 순회
			for (int count = 1; count < minCount; count++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 현재 사람이 손을 뻗은 거리를 갱신
				distance += Integer.parseInt(st.nextToken());
				
				// 현재까지 가장 빠른 횟수로 점원에 도달한 경우 결제한 사람 및 해당 사람이 손을 뻗은 횟수를 갱신 후 다음 사람을 순회
				if (distance >= targetDistance) {
					payer = customer;
					minCount = count;
					continue outer;
				}
			}
		}
		
		// write() 메서드를 사용해 결제한 사람 및 해당 사람이 손을 뻗은 횟수를 출력
		out.write(payer + " " + minCount);
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}