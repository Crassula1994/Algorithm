package silver4.num25089;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// 최대로 사용할 수 있는 모든 잉크 양의 합을 저장할 변수 totalAmount 초기화
			int totalAmount = 0;
			
			// 최대로 사용할 수 있는 각 색상의 잉크 양을 저장할 배열 maxAmounts 초기화
			int[] maxAmounts = new int[4];
			
			// fill() 메서드를 사용해 최대로 사용할 수 있는 각 색상의 잉크 양을 초기화
			Arrays.fill(maxAmounts, 1000000);
			
			// for 반복문을 사용해 각 프린터를 순회
			for (int printer = 0; printer < 3; printer++) {
				
				// StringTokenizer 객체를 불러와 변수 st에 할당
				StringTokenizer st = new StringTokenizer(in.readLine());
				
				// for 반복문을 사용해 최대로 사용할 수 있는 각 색상의 잉크 양을 갱신
				for (int idx = 0; idx < maxAmounts.length; idx++)
					maxAmounts[idx] = Math.min(Integer.parseInt(st.nextToken()), maxAmounts[idx]);
			}
			
			// for 반복문을 사용해 최대로 사용할 수 있는 모든 잉크 양의 합을 갱신
			for (int idx = 0; idx < maxAmounts.length; idx++)
				totalAmount += maxAmounts[idx];
			
			// write() 메서드를 사용해 해당 테스트 케이스의 번호를 출력
			out.write("Case #" + tc + ": ");
			
			// 어떠한 색상도 인쇄할 수 없는 경우 'IMPOSSIBLE' 출력
			if (totalAmount < 1000000) {
				out.write("IMPOSSIBLE");
				
			// 색상을 인쇄할 수 있는 경우
			} else {
				
				// for 반복문을 사용해 각 색상을 순회
				for (int idx = 0, targetAmount = 1000000; idx < maxAmounts.length; idx++) {
					
					// 필요한 잉크를 모두 충당한 경우 0을 출력 후 다음 색상을 순회
					if (targetAmount == 0) {
						out.write(0 + " ");
						continue;
					}
					
					// 필요한 잉크보다 더 많은 잉크가 있는 경우
					if (targetAmount < maxAmounts[idx]) {
						
						// write() 메서드를 사용해 필요한 잉크의 양을 출력
						out.write(targetAmount + " ");
						
						// 필요한 잉크의 양을 갱신
						targetAmount = 0;
						
					// 필요한 잉크와 같거나 더 적은 잉크가 있는 경우
					} else {
						
						// write() 메서드를 사용해 해당 잉크의 양을 출력
						out.write(maxAmounts[idx] + " ");
						
						// 필요한 잉크의 양을 갱신
						targetAmount -= maxAmounts[idx];
					}
				}
			}
			
			// newLine() 메서드를 사용해 줄바꿈 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}