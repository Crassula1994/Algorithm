package bronze4.num02752;

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
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// 세 숫자를 저장할 배열 threeNumbers 초기화
		int[] threeNumbers = new int[3];
		
		// for 반복문을 사용해 입력 받은 세 숫자를 배열 threeNumbers에 저장
		for (int idx = 0; idx < 3; idx++)
			threeNumbers[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 threeNumbers를 오름차순으로 정렬
		Arrays.sort(threeNumbers);

		// for 반복문을 사용해 제일 작은 수, 그 다음 수, 제일 큰 수를 차례로 출력
		for (int idx = 0; idx < 3; idx++)
			out.write(threeNumbers[idx] + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}