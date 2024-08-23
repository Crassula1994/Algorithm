package gold4.num09278;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 자리를 바꿀 방법의 수를 나눌 제수를 저장할 상수 DIVISOR 초기화
	static final int DIVISOR = 1000000;
	
	// 50원을 가진 사람이 얼마나 더 많은지에 따라 그 방법의 수를 저장할 배열 counts 초기화
	static int[] counts;
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 각 테스트 케이스를 저장할 변수 testCase 초기화
		String testCase;
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while ((testCase = in.readLine()) != null) {
			
			// toCharArray() 메서드를 사용해 줄에 위치한 사람의 위치를 배열 line에 저장
			char[] line = testCase.toCharArray();
			
			// 50원을 가진 사람이 얼마나 더 많은지에 따라 그 방법의 수를 저장할 배열 counts 초기화
			counts = new int[line.length / 2 + 1];
			
			// 첫 번째 사람의 종류에 따라 그 방법의 수를 초기화
			counts[0] = (line[0] == ')') ? 0 : 1;
			
			// for 반복문을 사용해 각 사람의 위치를 순회
			for (int idx = 1; idx < line.length; idx++) {
				
				// 최대로 더 가질 수 있는 50원을 가진 사람의 수를 변수 limit에 할당
				int limit = (idx + 1) / 2;
				
				// 현재 위치에 자리를 바꿀 수 있는 사람이 있는 경우
				if (line[idx] == '.') {
					
					// for 반복문을 사용해 50원을 가진 사람이 얼마나 더 많은지에 따라 그 방법의 수를 갱신
					for (int remainder = limit; remainder > 0; remainder--)
						counts[remainder] = (counts[remainder] + counts[remainder - 1]) % DIVISOR;
					
				// 현재 위치에 자리를 바꿀 수 없는 100원을 가진 사람이 있는 경우
				} else if (line[idx] == ')') {
					
					// for 반복문을 사용해 최대로 더 가질 수 있는 50원을 가진 사람이 한 사람 줄어든 것과 같으므로 그 방법의 수를 갱신
					for (int remainder = limit; remainder > 0; remainder--)
						counts[remainder] = counts[remainder - 1];
					
					// 50원을 가진 사람이 없는 경우 그 방법의 수는 0이므로 0으로 초기화
					counts[0] = 0;
				}
			}
			
			// write() 메서드를 사용해 자리를 바꿀 방법의 수를 출력
			out.write(counts[line.length / 2] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}