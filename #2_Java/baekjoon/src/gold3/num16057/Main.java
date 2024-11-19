package gold3.num16057;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 부동산의 꼭짓점의 개수를 변수 pointNum에 할당
		int pointNum = Integer.parseInt(in.readLine());
		
		// 부동산의 면적과 부동산의 모서리에 위치한 정수 좌표인 점의 개수를 저장할 각 변수 초기화
		long area = 0;
		long boundaryPoints = 0;
		
		// 꼭짓점의 좌표를 저장할 2차원 배열 cornerPoints 초기화
		long[][] cornerPoints = new long[pointNum + 1][2];
		
		// for 반복문을 사용해 각 꼭짓점의 좌표를 순회
		for (int idx = 0; idx < pointNum; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseLong() 메서드를 사용해 입력 받은 각 꼭짓점의 좌표를 2차원 배열 cornerPoints에 저장
			cornerPoints[idx][0] = Long.parseLong(st.nextToken());
			cornerPoints[idx][1] = Long.parseLong(st.nextToken());
		}
		
		// 부동산의 면적과 부동산의 모서리에 위치한 정수 좌표인 점의 개수를 구하기 위해 첫 꼭짓점의 좌표를 마지막에 할당
		cornerPoints[pointNum][0] = cornerPoints[0][0];
		cornerPoints[pointNum][1] = cornerPoints[0][1];
		
		// for 반복문을 사용해 각 꼭짓점을 순회
		for (int idx = 0; idx < pointNum; idx++) {
			
			// 신발끈 공식(Shoelace Formula)을 사용해 부동산의 면적을 갱신
			area += cornerPoints[idx][0] * cornerPoints[idx + 1][1] - cornerPoints[idx][1] * cornerPoints[idx + 1][0];
			
			/* 부동산의 모서리에 위치한 정수 좌표의 개수는 해당 모서리의 양 꼭짓점 사이의 가로 및 세로 거리의 최대공약수와 같으므로 
			abs() 및 gcdCalculator() 메서드를 사용해 부동산의 모서리에 위치한 정수 좌표의 개수를 갱신 */
			boundaryPoints += gcdCalculator(Math.abs(cornerPoints[idx][0] - cornerPoints[idx + 1][0]),
					Math.abs(cornerPoints[idx][1] - cornerPoints[idx + 1][1]));
		}
		
		// abs() 메서드를 사용해 픽의 정리(Pick's Theorem)에 따라 지하수 검사를 시행할 지점의 개수를 계산하여 변수 testPoints에 할당
		long testPoints = (Math.abs(area) - boundaryPoints + 2) / 2;
		
		// valueOf() 및 write() 메서드를 사용해 지하수 검사를 시행할 지점의 개수를 출력
		out.write(String.valueOf(testPoints));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}

	// ----------------------------------------------------------------------------------------------------
	
	// gcdCalculator() 메서드 정의
	public static long gcdCalculator(long numberA, long numberB) {
		
		// 나머지가 0인 경우 numberA가 최대공약수이므로 이를 반환
		if (numberB == 0)
			return numberA;
		
		// gcdCalculator() 메서드를 재귀 호출해 최대공약수를 반환
		return gcdCalculator(numberB, numberA % numberB);
	}
}