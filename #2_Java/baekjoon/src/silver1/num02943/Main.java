package silver1.num02943;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 토끼의 수와 토끼에게 딸기를 준 일수를 각 변수에 할당
		int rabbitNum = Integer.parseInt(st.nextToken());
		int dayNum = Integer.parseInt(st.nextToken());
		
		// sqrt() 메서드를 사용해 계산한 한 블록에 속한 토끼의 수와 블록의 수를 각 변수에 할당
		int divisor = (int) Math.sqrt(rabbitNum);
		int blockNum = (rabbitNum % divisor == 0) ? rabbitNum / divisor : rabbitNum / divisor + 1;
		
		// 각 토끼의 앞에 놓인 성냥갑과 컵에 있는 성냥의 개수를 저장할 각 배열 초기화
		int[] boxes = new int[rabbitNum];
		int[] cups = new int[blockNum];
		
		// for 반복문을 사용해 각 날짜를 순회
		for (int day = 0; day < dayNum; day++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 딸기의 수와 딸기를 주기 시작한 토끼의 번호를 각 변수에 할당
			int berryNum = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken()) - 1;
			
			// 현재 토끼의 번호 해당 날짜에 성냥을 넣은 성냥갑과 컵에 들어있는 성냥의 수를 저장할 각 변수 초기화
			int curRabbit = start;
			int count = 0;
			
			// while 반복문을 사용해 각 딸기를 준 토끼를 순회
			while (curRabbit < start + berryNum) {
				
				// 성냥갑에 성냥을 넣어야 하는 경우 성냥갑에 넣은 성냥과 해당 날짜에 넣은 성냥의 수, 현재 토끼의 번호를 갱신
				if (curRabbit % divisor != 0 || (start + berryNum != rabbitNum && curRabbit + divisor - 1 >= start + berryNum)) {
					boxes[curRabbit]++;
					count += boxes[curRabbit];
					curRabbit++;
					
				// 컵에 성냥을 넣어야 하는 경우 컵에 넣은 성냥과 해당 날짜에 넣은 성냥의 수, 현재 토끼의 번호를 갱신
				} else {
					cups[curRabbit / divisor]++;
					count += cups[curRabbit / divisor];
					curRabbit += divisor;
				}
			}
			
			// write() 메서드를 사용해 해당 날짜에 성냥을 넣은 성냥갑과 컵에 들어있는 성냥의 수를 출력
			out.write(count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}