package silver4.num01758;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 스타박스 앞에 서 있는 사람의 수를 변수 personNum에 할당
		int personNum = Integer.parseInt(in.readLine());
		
		// 강호가 받을 수 있는 팁의 최댓값을 저장할 변수 maxTip 초기화
		long maxTip = 0;
		
		// 각 사람이 주려고 하는 팁을 저장할 배열 tips 초기화
		Integer[] tips = new Integer[personNum];
		
		// for 반복문을 사용해 각 사람이 주려고 하는 팁을 배열 tips에 저장
		for (int idx = 0; idx < tips.length; idx++)
			tips[idx] = Integer.parseInt(in.readLine());
		
		// reverseOrder() 및 sort() 메서드를 사용해 각 사람이 주려고 하는 팁을 내림차순으로 정렬
		Arrays.sort(tips, Collections.reverseOrder());
		
		// for 반복문을 사용해 강호가 받을 수 있는 팁의 최댓값을 갱신
		for (int idx = 0; idx < tips.length; idx++)
			maxTip += Math.max(tips[idx] - idx, 0);
		
		// valueOf() 및 write() 메서드를 사용해 강호가 받을 수 있는 팁의 최댓값을 출력
		out.write(String.valueOf(maxTip));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}