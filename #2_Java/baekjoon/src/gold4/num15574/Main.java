package gold4.num15574;

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
	
	// Signal 클래스 정의
	static class Signal implements Comparable<Signal> {
		
		// 신호의 각 좌표를 나타낼 각 변수 초기화
		int coordinateX;
		int coordinateY;
		
		// 매개변수를 입력 받는 생성자 정의
		public Signal(int coordinateX, int coordinateY) {
			this.coordinateX = coordinateX;
			this.coordinateY = coordinateY;
		}

		// compareTo() 메서드 정의
		@Override
		public int compareTo(Signal anotherSignal) {
			
			// x좌표가 같은 경우 y좌표를 기준으로 오름차순 정렬
			if (this.coordinateX == anotherSignal.coordinateX)
				return this.coordinateY - anotherSignal.coordinateY;
			
			// x좌표를 기준으로 오름차순 정렬
			return this.coordinateX - anotherSignal.coordinateX;
		}
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 신호의 개수를 변수 signalNum에 할당
		int signalNum = Integer.parseInt(in.readLine());
		
		// 가장 긴 통신 시스템의 길이를 저장할 변수 maxLength 초기화
		double maxLength = 0;
		
		// 신호의 좌표 및 각 좌표에서 가장 긴 통신 시스템의 길이를 저장할 각 배열 초기화
		Signal[] signals = new Signal[signalNum];
		double[] maxLengths = new double[signalNum];
		
		// for 반복문을 사용해 각 신호를 순회
		for (int idx = 0; idx < signals.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 좌표를 각 변수에 할당
			int coordinateX = Integer.parseInt(st.nextToken());
			int coordinateY = Integer.parseInt(st.nextToken());
			
			// 해당 신호의 좌표를 배열 signals에 저장
			signals[idx] = new Signal(coordinateX, coordinateY);
		}
		
		// sort() 메서드를 사용해 해당 신호를 x좌표를 기준으로 오름차순 정렬
		Arrays.sort(signals);
		
		// for 반복문을 사용해 각 신호를 순회
		for (int cur = 1; cur < signalNum; cur++) {
			
			// for 반복문을 사용해 이전의 신호를 순회
			for (int prev = 0; prev < cur; prev++) {
				
				// 이전의 신호의 X좌표가 현재 신호의 X좌표와 같은 경우 다음 좌표를 순회
				if (signals[prev].coordinateX == signals[cur].coordinateX)
					continue;
				
				// distCalculator() 메서드를 호출해 이전 신호와 현재 신호를 이었을 때의 길이를 계산해 변수 length에 할당
				double length = maxLengths[prev] + distCalculator(signals[prev], signals[cur]);
				
				// max() 메서드를 사용해 현재 신호에서 최대 통신 시스템의 길이를 갱신
				maxLengths[cur] = Math.max(length, maxLengths[cur]);
			}
		}
		
		// for 반복문을 사용해 가장 긴 통신 시스템의 거리를 갱신
		for (double length : maxLengths)
			maxLength = Math.max(length, maxLength);
		
		// format() 및 write() 메서드를 사용해 가장 긴 통신 시스템의 거리를 출력
		out.write(String.format("%.7f", maxLength));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------
	
	// distCalculator() 메서드 정의
	public static double distCalculator(Signal signalA, Signal signalB) {
		
		// pow() 메서드를 사용해 두 신호 사이의 각 좌표의 편차 제곱을 각 변수에 할당
		double diffX = Math.pow(signalA.coordinateX - signalB.coordinateX, 2);
		double diffY = Math.pow(signalA.coordinateY - signalB.coordinateY, 2);
		
		// sqrt() 메서드를 사용해 두 신호 사이의 거리를 계산해 반환
		return Math.sqrt(diffX + diffY);
	}
}