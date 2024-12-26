package silver5.num22282;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 논문의 수를 변수 paperNum에 할당
		int paperNum = Integer.parseInt(in.readLine());
		
		// H-인덱스의 값을 저장할 변수 maxIndexH 초기화
		int maxIndexH = 0;
		
		// 각 논문의 인용 수를 저장할 저장할 배열 papers 초기화
		int[] papers = new int[paperNum];
		
		// for 반복문을 사용해 각 논문의 인용 수를 배열 papers에 저장
		for (int idx = 0; idx < papers.length; idx++)
			papers[idx] = Integer.parseInt(in.readLine());
		
		// sort() 메서드를 사용해 각 논문을 인용 수에 따라 오름차순 정렬
		Arrays.sort(papers);
		
		// for 반복문을 사용해 가능한 각 H-인덱스의 값을 순회
		for (int indexH = 1; indexH <= paperNum; indexH++) {
			
			// H-인덱스의 조건을 만족하는 값을 찾은 경우 H-인덱스의 값을 갱신
			if (papers[paperNum - indexH] >= indexH)
				maxIndexH = indexH;
		}
		
		// valueOf() 및 write() 메서드를 사용해 H-인덱스의 값을 출력
		out.write(String.valueOf(maxIndexH));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}