package bronze1.num02684;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// readLine() 메서드를 사용해 입력 받은 동전을 던진 결과를 변수 result에 할당
			String result = in.readLine();
			
			// 3-동전 수열의 개수를 저장할 배열 counter 초기화
			int[] counter = new int[8];
			
			// for 반복문을 사용해 각 동전 수열을 순회
			for (int s = 0; s < 38; s++) {
				
				// substring() 메서드를 사용해 해당 3-동전 수열을 변수 coinSeq에 할당
				String coinSeq = result.substring(s, s + 3);
				
				// switch 조건문을 사용해 각 3-동전 수열의 개수를 갱신
				switch (coinSeq) {
					case "TTT":
						counter[0]++;
						break;
					case "TTH":
						counter[1]++;
						break;
					case "THT":
						counter[2]++;
						break;
					case "THH":
						counter[3]++;
						break;
					case "HTT":
						counter[4]++;
						break;
					case "HTH":
						counter[5]++;
						break;
					case "HHT":
						counter[6]++;
						break;
					default:
						counter[7]++;
				}
			}
			
			// for 반복문을 사용해 각 3-동전 수열의 개수를 출력
			for (int idx = 0; idx < counter.length; idx++)
				out.write(counter[idx] + " ");
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}