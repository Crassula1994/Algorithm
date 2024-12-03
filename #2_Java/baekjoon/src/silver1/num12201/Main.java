package silver1.num12201;

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
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 바텐더가 따르는 와인 병의 개수 및 목표 잔의 층과 번호를 각 변수에 할당
			int bottleNum = Integer.parseInt(st.nextToken());
			int targetLevel = Integer.parseInt(st.nextToken());
			int targetNumber = Integer.parseInt(st.nextToken());
			
			// 현재 층의 잔의 개수를 저장할 변수 glassNum 초기화
			int glassNum = 1;
			
			// 이전 층의 각 잔에 존재하는 와인의 양을 저장할 배열 prevGlasses 초기화
			double[] prevGlasses = new double[glassNum + 1];
			
			// 1층에 존재하는 와인의 양을 초기화
			prevGlasses[1] = bottleNum * 750.0;
			
			// for 반복문을 사용해 각 층을 순회
			for (int level = 2; level <= targetLevel; level++) {
				
				// 해당 층에 존재하는 잔의 개수를 갱신
				glassNum += level;
				
				// 현재 층의 각 잔에 존재하는 와인의 양을 저장할 배열 curGlasses 초기화
				double[] curGlasses = new double[glassNum + 1];
				
				// for 반복문을 사용해 이전 층의 각 잔을 순회
				for (int number = 1, curRow = 1; number < prevGlasses.length; number++) {
					
					// 잔이 위치한 줄이 바뀐 경우 현재 줄의 위치를 갱신
					if (number > curRow * (curRow + 1) / 2)
						curRow++;
					
					// 해당 잔의 와인이 넘치는 경우
					if (prevGlasses[number] > 250) {
						
						// 넘치는 와인의 양을 계산해 변수 amount에 할당
						double amount = prevGlasses[number] - 250;
						
						// 이전 층에서 넘친 와인의 양을 현재 층의 잔에 갱신
						curGlasses[number] += amount / 3;
						curGlasses[number + curRow] += amount / 3;
						curGlasses[number + curRow + 1] += amount / 3;
					}
				}
				
				// 이전 층의 각 잔에 존재하는 와인의 양을 현재 층의 와인의 양으로 갱신
				prevGlasses = curGlasses;
			}
			
			// min(), format(), write() 메서드를 사용해 테스트 케이스의 번호와 목표 잔에 존재하는 와인의 양을 출력
			out.write(String.format("Case #%d: %.7f", tc, Math.min(250, prevGlasses[targetNumber])));
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}