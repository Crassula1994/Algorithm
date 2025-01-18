package bronze1.num14647;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 빙고판의 크기를 각 변수에 할당
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		// 모든 9의 개수 및 행 또는 열에 가장 많이 존재하는 9의 개수를 저장할 각 변수 초기화
		int totalCount = 0;
		int maxCount = 0;
		
		// 각 행과 열에 존재하는 9의 개수를 저장할 각 배열 초기화
		int[] rowCounts = new int[height];
		int[] columnCounts = new int[width];
		
		// for 반복문을 사용해 각 빙고판의 줄을 순회
		for (int r = 0; r < height; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 각 빙고판의 칸을 순회
			for (int c = 0; c < width; c++) {
				
				// nextToken() 메서드를 사용해 해당 칸의 숫자를 변수 number에 할당
				String number = st.nextToken();
				
				// 해당 칸에 존재하는 9의 개수를 저장할 변수 count 초기화
				int count = 0;
				
				// for 반복문을 사용해 각 숫자의 자릿수를 순회
				for (int idx = 0; idx < number.length(); idx++) {
					
					// 해당 자릿수가 9인 경우 해당 칸에 존재하는 9의 개수를 갱신
					if (number.charAt(idx) == '9')
						count++;
				}
				
				// 모든 9의 개수 및 각 행과 열에 존재하는 9의 개수를 갱신
				totalCount += count;
				rowCounts[r] += count;
				columnCounts[c] += count;
				
				// max() 메서드를 사용해 행 또는 열에 가장 많이 존재하는 9의 개수를 갱신
				maxCount = Math.max(rowCounts[r], maxCount);
				maxCount = Math.max(columnCounts[c], maxCount);
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 준오가 맞아야 하는 횟수를 출력
		out.write(String.valueOf(totalCount - maxCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}