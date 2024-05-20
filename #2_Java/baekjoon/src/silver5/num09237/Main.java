package silver5.num09237;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 이장님을 초대할 수 있는 가장 빠른 날짜를 저장할 변수 minDay 초기화
		int minDay = 0;
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 묘목의 수를 변수 saplingNum에 할당
		int saplingNum = Integer.parseInt(in.readLine());
		
		// 각 묘목이 자라는 데 걸리는 일수를 저장할 배열 saplings 초기화
		Integer[] saplings = new Integer[saplingNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 묘목이 자라는 데 걸리는 일수를 배열 saplings에 저장
		for (int idx = 0; idx < saplings.length; idx++)
			saplings[idx] = Integer.parseInt(st.nextToken());
		
		// reverseOrder() 및 sort() 메서드를 사용해 자라는 데 오래 걸리는 묘목 순으로 정렬
		Arrays.sort(saplings, Collections.reverseOrder());
		
		// for 반복문을 사용해 이장님을 초대할 수 있는 가장 빠른 날짜를 갱신
		for (int idx = 0; idx < saplings.length; idx++)
			minDay = Math.max(saplings[idx] + idx + 1, minDay);
		
		// valueOf() 및 write() 메서드를 사용해 이장님을 초대할 수 있는 가장 빠른 날짜를 출력
		out.write(String.valueOf(minDay + 1));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}