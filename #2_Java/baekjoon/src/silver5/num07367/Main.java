package silver5.num07367;

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
		
		// while 반복문을 사용해 각 테스트 케이스를 순회
		while (true) {
			
			// readLine() 및 parseInt() 메서드를 사용해 수열에 속한 값의 개수를 변수 elementNum에 할당
			int elementNum = Integer.parseInt(in.readLine());
			
			// 모든 테스트 케이스를 확인한 경우 반복문 탈출
			if (elementNum == 0)
				break;
			
			// 입력 받은 수열을 저장할 배열 sequence 초기화0
			String[] sequence = new String[elementNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 수열을 배열 sequence에 저장
			for (int idx = 0; idx < sequence.length; idx++)
				sequence[idx] = st.nextToken();
			
			// minBaseFinder() 및 write() 메서드를 사용해 해당 수열이 등차수열이 되는 최소 진법을 출력
			out.write(minBaseFinder(sequence));
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// minBaseFinder() 메서드 정의
	public static String minBaseFinder(String[] sequence) {
		
		// for 반복문을 사용해 10 이하의 각 진법을 순회
		for (int radix = 2; radix <= 10; radix++) {
			
			// 해당 진법으로 등차수열을 이루는지 여부를 저장할 변수 isArithmetic 초기화
			boolean isArithmetic = true;
			
			// for 반복문을 사용해 각 숫자를 순회
			for (int idx = 0, prevElement = 0, coDiff = 0; idx < sequence.length; idx++) {
				
				// 해당 진법으로 수열의 원소를 변환할 수 있는지 확인
				try {
					
					// parseInt() 메서드를 사용해 해당 진법으로 수열의 원소를 변환한 결과를 변수 curElement에 저장
					int curElement = Integer.parseInt(sequence[idx], radix);
					
					// 첫 번째 원소인 경우 직전 원소의 값을 갱신 후 다음 원소를 순회
					if (idx == 0) {
						prevElement = curElement;
						continue;
					}
					
					// 해당 원소와 직전 원소 사이의 차이를 계산해 변수 difference에 할당
					int difference = curElement - prevElement;
					
					// 두 번째 원소인 경우 공차를 갱신
					if (idx == 1) {
						coDiff = difference;
						
					// 세 번째 이상의 원소이고 해당 원소와 직전 원소 사이의 차이가 공차와 일치하지 않는 경우
					} else if (difference != coDiff) {
						
						// 해당 진법으로 등차수열을 이루는지 여부를 갱신 후 반복문 탈출
						isArithmetic = false;
						break;
					}
					
					// 직전 원소의 값을 갱신
					prevElement = curElement;
				
				// 해당 진법으로 수열의 원소를 변환할 수 없는 경우 해당 진법으로 등차수열을 이루는지 여부를 갱신 후 반복문 탈출
				} catch (NumberFormatException exception) {
					isArithmetic = false;
					break;
				}
			}
			
			// 해당 진법으로 등차수열을 이루는 경우 해당 진법을 반환
			if (isArithmetic)
				return "Minimum base = " + radix + ".";
		}
		
		// 해당 수열이 등차수열이 되는 10 이하의 진법이 없는 경우 정해진 문구를 반환
		return "No base <= 10 can be found.";
	}
}