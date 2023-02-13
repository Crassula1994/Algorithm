package silver4.num11399;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 사람의 수를 변수 length에 할당
		int length = Integer.parseInt(in.readLine());

		// 각 사람이 돈을 인출하는 데 필요한 시간을 저장할 배열 time 초기화
		int[] time = new int[length];
		
		// 각 사람이 돈을 인출하는 데 필요한 최소 시간을 저장할 변수 minTime 초기화
		int minTime = 0;
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 사람의 인출 소요 시간을 배열 time에 저장
		for (int idx = 0; idx < length; idx++)
			time[idx] = Integer.parseInt(st.nextToken());
		
		// sort() 메서드를 사용해 배열 time을 오름차순으로 정렬
		Arrays.sort(time);
		
		// for 반복문을 사용해 배열 time의 각 원소를 순회하며 최소 인출 소요 시간을 계산
		for (int idx = 0; idx < length; idx++)
			minTime += time[idx] * (length - idx);
		
		// valueOf() 및 write() 메서드를 사용해 최소 인출 소요 시간을 출력
		out.write(String.valueOf(minTime));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}