package silver1.num21558;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 민족의 수를 변수 ethnicityNum에 할당
		int ethnicityNum = Integer.parseInt(in.readLine());
		
		// 전체 병사의 수를 저장할 변수 totalCount 초기화
		int totalCount = 0;
		
		// 각 민족의 병사 수, 각 평화의 돌의 개수별 가장 큰 열의 수를 저장할 각 배열 초기화
		int[] ethnicities = new int[ethnicityNum];
		int[] maxColumns = new int[ethnicityNum];
		
		// 전체 병사를 배치할 수 있는 가능한 열의 수를 저장할 List 객체 columns 초기화
		List<Integer> columns = new ArrayList<>();
		
		// StringTokenizer 객체를 불러와 변수 st에 할당
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 각 민족의 병사 수를 순회
		for (int idx = 0; idx < ethnicities.length; idx++) {
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 민족의 병사 수를 배열 ethnicities에 저장
			ethnicities[idx] = Integer.parseInt(st.nextToken());
			
			// 전체 병사의 수를 갱신
			totalCount += ethnicities[idx];
		}
		
		// for 반복문을 사용해 전체 병사를 배치할 수 있는 가능한 열의 수를 순회
		for (int column = 1; column * column <= totalCount; column++) {
			
			// 해당 열로 전체 병사를 배치할 수 없는 경우 다음 열의 수를 순회
			if (totalCount % column != 0)
				continue;
			
			// add() 메서드를 사용해 전체 병사를 배치할 수 있는 열의 수를 columns에 저장
			columns.add(column);
			
			// 열의 수가 중복되지 않는 경우 다른 가능한 열의 수를 columns에 추가
			if (column * column != totalCount)
				columns.add(totalCount / column);
		}
		
		// sort() 메서드를 사용해 전체 병사를 배치할 수 있는 가능한 열의 수를 오름차순으로 정렬
		Collections.sort(columns);
		
		// for 반복문을 사용해 각 열을 순회
		for (int column : columns) {
			
			// 해당 열을 만들기 위해 배치한 병사의 수 및 필요한 평화의 돌의 개수를 저장할 각 변수 초기화
			int curCount = 0;
			int stoneCount = ethnicityNum;
			
			// for 반복문을 사용해 각 민족의 병사 수를 순회
			for (int ethnicity : ethnicities) {
				
				// 해당 열을 만들기 위해 배치한 병사의 수를 갱신
				curCount += ethnicity;
				
				// 해당 열을 만들기 위해 배치한 병사의 수가 열의 크기로 나누어 떨어지는 경우 필요한 평화의 돌의 개수를 갱신
				if (curCount % column == 0)
					stoneCount--;
			}
			
			// fill() 메서드를 사용해 각 평화의 돌의 개수별 가장 큰 열의 수를 갱신
			Arrays.fill(maxColumns, stoneCount, ethnicityNum, column);
		}
		
		// for 반복문을 사용해 각 평화의 돌의 개수별 가장 큰 열의 수를 출력
		for (int maxColumn : maxColumns)
			out.write(maxColumn + " ");
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}