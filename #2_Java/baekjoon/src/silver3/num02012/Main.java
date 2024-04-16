package silver3.num02012;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 학생의 수를 변수 studentNum에 할당
		int studentNum = Integer.parseInt(in.readLine());
		
		// 각 학생의 예상 등수를 저장할 배열 ranking 초기화
		int[] ranking = new int[studentNum + 1];
		
		// for 반복문을 사용해 입력 받은 각 사람의 예상 등수를 배열 ranking에 저장
		for (int idx = 1; idx < ranking.length; idx++)
			ranking[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 각 사람의 예상 등수를 오름차순으로 정렬
		Arrays.sort(ranking);
		
		// 불만도의 합을 저장할 변수 totalSum 초기화
		long totalSum = 0;
		
		// for 반복문을 사용해 불만도의 합을 갱신
		for (int idx = 1; idx < ranking.length; idx++)
			totalSum += Math.abs(ranking[idx] - idx);
		
		// valueOf() 및 write() 메서드를 사용해 불만도의 합의 최솟값을 출력
		out.write(String.valueOf(totalSum));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}