package gold3.num11049;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 행렬의 개수를 변수 matrixNum에 할당
		int matrixNum = Integer.parseInt(in.readLine());
			
		// 각 행렬의 크기 및 각 구간에서의 최소 연산 횟수를 저장할 각 2차원 배열 초기화
		int[][] matrixes = new int[matrixNum][2];
		int[][] minCalc = new int[matrixNum][matrixNum];
		
		// for 반복문을 사용해 입력 받은 행렬의 크기를 순회
		for (int idx = 0; idx < matrixes.length; idx++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 행렬의 크기를 2차원 배열 matrixes에 저장
			matrixes[idx][0] = Integer.parseInt(st.nextToken());
			matrixes[idx][1] = Integer.parseInt(st.nextToken());
		}
		
		// for 반복문을 사용해 각 구간의 크기를 순회
		for (int size = 1; size < matrixNum; size++) {
			
			// for 반복문을 사용해 각 구간의 시작을 순회
			for (int idx = 0; idx < matrixNum - size; idx++) {
				
				// 해당 구간의 최소 연산 횟수를 초기화
				minCalc[idx][idx + size] = Integer.MAX_VALUE;
			
				// for 반복문을 사용해 해당 구간을 두 개의 구간으로 구분하고 이를 차례로 순회
				for (int mid = idx; mid < idx + size; mid++) {
					
					// 두 구간의 최소 연산 횟수를 더해 연산 횟수를 저장할 변수 clac에 할당
					int calc = minCalc[idx][mid] + minCalc[mid + 1][idx + size];
					
					// 두 구간의 곱셈 결과 나오는 두 행렬의 곱셈 연산 횟수를 더해 연산 횟수를 갱신
					calc += matrixes[idx][0] * matrixes[mid][1] * matrixes[idx + size][1];
					
					// min() 메서드를 사용해 해당 구간의 최소 연산 횟수를 갱신
					minCalc[idx][idx + size] = Math.min(calc, minCalc[idx][idx + size]);
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 행렬 곱셈 연산의 최솟값을 출력
		out.write(String.valueOf(minCalc[0][matrixNum - 1]));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}