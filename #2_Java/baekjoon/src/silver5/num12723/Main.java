package silver5.num12723;

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
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 벡터의 차원을 변수 dimension에 할당
			int dimension = Integer.parseInt(in.readLine());
			
			// 두 벡터의 최소 내적을 저장할 변수 minProduct 초기화
			int minProduct = 0;
			
			// 두 벡터의 성분을 저장할 각 배열 초기화
			int[] vector1 = new int[dimension];
			int[] vector2 = new int[dimension];
			
			// StringTokenizer 객체를 불러와 각 변수에 할당
			StringTokenizer vector1Str = new StringTokenizer(in.readLine());
			StringTokenizer vector2Str = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 각 벡터의 성분을 각 배열에 저장
			for (int idx = 0; idx < dimension; idx++) {
				vector1[idx] = Integer.parseInt(vector1Str.nextToken());
				vector2[idx] = Integer.parseInt(vector2Str.nextToken());
			}
			
			// sort() 메서드를 사용해 각 벡터의 성분을 오름차순으로 정렬
			Arrays.sort(vector1);
			Arrays.sort(vector2);
			
			// for 반복문을 사용해 두 벡터의 최소 내적을 갱신
			for (int idx = 0; idx < dimension; idx++)
				minProduct += vector1[idx] * vector2[dimension - idx - 1];
			
			// write() 메서드를 사용해 두 벡터의 최소 내적을 출력
			out.write("Case #" + tc + ": " + minProduct + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}