package bronze1.num02693;

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

		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 개수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());

		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {

			// 각 테스트 케이스의 숫자를 저장할 배열 array 초기화
			int[] array = new int[10];

			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());

			// for 반복문을 사용해 입력 받은 숫자를 배열 array에 저장
			for (int idx = 0; idx < array.length; idx++)
				array[idx] = Integer.parseInt(st.nextToken());

			// sort() 메서드를 사용해 배열 array를 오름차순으로 정렬
			Arrays.sort(array);

			// write() 메서드를 사용해 세 번째로 큰 값을 출력
			out.write(array[7] + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}