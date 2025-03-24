package gold3.num25970;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// Pattern 클래스 정의
	static class Pattern {
		
		// 해당 데이터의 10진수 값 및 길이를 저장할 각 변수 초기화
		long value;
		int length;
		
		// 매개변수를 입력 받는 생성자 정의
		public Pattern(String pattern) {
			this.value = Long.parseLong(pattern, 2);
			this.length = pattern.length();
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 판단 데이터의 수를 변수 dataNum에 할당
		int dataNum = Integer.parseInt(in.readLine());
		
		// '차고의 낮음' 및 '차고의 높음' 판단 데이터를 저장할 각 배열 초기화
		Pattern[] lowData = new Pattern[dataNum];
		Pattern[] highData = new Pattern[dataNum];
		
		// for 반복문을 사용해 입력 받은 '차고의 낮음' 판단 데이터를 배열 lowData에 저장
		for (int idx = 0; idx < lowData.length; idx++)
			lowData[idx] = new Pattern(in.readLine());
		
		// for 반복문을 사용해 입력 받은 '차고의 높음' 판단 데이터를 배열 highData에 저장
		for (int idx = 0; idx < highData.length; idx++)
			highData[idx] = new Pattern(in.readLine());
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 실시간 데이터의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 실시간 데이터를 순회
		while (testCase-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 실시간 데이터를 변수 realTimeData에 할당
			String realTimeData = in.readLine();
			
			// dataCounter() 메서드를 호출해 해당 실시간 데이터의 현재 차고를 변수 curHeight에 할당
			int curHeight = dataCounter(realTimeData, highData) - dataCounter(realTimeData, lowData);
			
			// 차고가 높은 경우 정해진 형식으로 차고를 출력
			if (curHeight > 0) {
				out.write("LOW " + curHeight);
				
			// 차고가 낮은 경우 정해진 형식으로 차고를 출력
			} else if (curHeight < 0) {
				out.write("HIGH " + (-curHeight));
				
			// 차고가 안정된 상태인 경우 'GOOD'을 출력
			} else {
				out.write("GOOD");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// dataCounter() 메서드 정의
	public static int dataCounter(String source, Pattern[] patterns) {
		
		// 실시간 데이터에 존재하는 패턴의 개수를 저장할 변수 count 초기화
		int count = 0;
		
		// for 반복문을 사용해 각 패턴을 순회
		for (Pattern pattern : patterns) {
			
			// 현재 데이터의 10진법 값을 저장할 변수 curValue 초기화
			long curValue = 0;
			
			// for 반복문을 사용해 실시간 데이터의 각 비트를 순회
			for (int idx = 0; idx < source.length(); idx++) {
				
				// charAt() 메서드를 사용해 현재 데이터의 10진법 값을 갱신
				curValue = ((curValue & ~(1L << (pattern.length - 1))) << 1) | (source.charAt(idx) - '0');
				
				// 아직 패턴의 길이에 도달하지 못한 경우 다음 비트를 순회
				if (idx < pattern.length - 1)
					continue;
				
				// 현재 데이터가 패턴과 일치하는 경우 실시간 데이터에 존재하는 패턴의 개수를 갱신
				if (curValue == pattern.value)
					count++;
			}
		}
		
		// 실시간 데이터에 존재하는 패턴의 개수를 반환
		return count;
	}
}