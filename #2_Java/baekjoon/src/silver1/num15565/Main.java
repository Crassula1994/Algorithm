package silver1.num15565;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 인형의 개수 및 필요한 라이언 인형의 개수를 각 변수에 할당
		int dollNum = Integer.parseInt(st.nextToken());
		int requiredNum = Integer.parseInt(st.nextToken());
		
		// 각 인형의 순서를 저장할 배열 dolls 초기화
		int[] dolls = new int[dollNum];
		
		// 라이언 인형의 위치를 저장할 List 객체 lionDolls 초기화
		List<Integer> lionDolls = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 각 인형을 순회
		for (int idx = 0; idx < dolls.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 인형을 배열 dolls에 저장
			dolls[idx] = Integer.parseInt(st.nextToken());
			
			// 라이언 인형인 경우 해당 위치를 lionDolls에 추가
			if (dolls[idx] == 1)
				lionDolls.add(idx);
		}
		
		// 필요한 라이언 인형의 개수를 만족하는 집합이 존재하지 않는 경우 -1을 출력
		if (lionDolls.size() < requiredNum) {
			out.write(String.valueOf(-1));
			
		// 필요한 라이언 인형의 개수를 만족하는 집합이 존재하는 경우 
		} else {
		
			// 필요한 만큼의 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집합의 크기를 저장할 변수 minSize 초기화
			int minSize = Integer.MAX_VALUE;
			
			// for 반복문을 사용해 각 라이언 인형을 순회
			for (int idx = 0; idx < lionDolls.size() - requiredNum + 1; idx++) {
				
				// get() 메서드를 사용해 각 위치를 각 변수에 할당
				int start = lionDolls.get(idx);
				int end = lionDolls.get(idx + requiredNum - 1);
				
				// 집합의 크기를 계산해 변수 size에 할당
				int size = end - start + 1;
				
				// min() 메서드를 사용해 필요한 만큼의 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집합의 크기를 갱신
				minSize = Math.min(size, minSize);
			}
			
			// valueOf() 및 write() 메서드를 사용해 필요한 만큼의 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집합의 크기를 출력
			out.write(String.valueOf(minSize));
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}