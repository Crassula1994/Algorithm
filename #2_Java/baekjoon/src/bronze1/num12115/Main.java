package bronze1.num12115;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 데이터베이스의 각 크기를 각 변수에 할당
		int rowNum = Integer.parseInt(st.nextToken());
		int columnNum = Integer.parseInt(st.nextToken());
		
		// 데이터베이스에 저장된 내용을 저장할 2차원 배열 database 초기화
		int[][] database = new int[rowNum][columnNum];
		
		// for 반복문을 사용해 데이터베이스의 각 행을 순회
		for (int r = 0; r < rowNum; r++) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 데이터베이스에 저장된 내용을 2차원 배열 database에 저장
			for (int c = 0; c < columnNum; c++)
				database[r][c] = Integer.parseInt(st.nextToken());
		}
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 질의의 수를 변수 queryNum에 할당
		int queryNum = Integer.parseInt(in.readLine());
		
		// while 반복문을 사용해 각 질의를 순회
		while (queryNum-- > 0) {
			
			// 해당 질의에 대한 답을 저장할 변수 answer 초기화
			int answer = 0;
			
			// 입력 받은 질의를 저장할 배열 query 초기화
			int[] query = new int[columnNum];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 입력 받은 질의의 각 숫자를 배열 query에 저장
			for (int idx = 0; idx < columnNum; idx++)
				query[idx] = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 데이터베이스의 각 행과 열을 순회
			outer: for (int r = 0; r < rowNum; r++) {
				for (int c = 0; c < columnNum; c++) {
					
					// 해당 질의의 숫자가 -1인 경우 다음 열을 순회
					if (query[c] == -1)
						continue;
					
					// 해당 행의 값이 질의의 숫자와 일치하지 않는 경우 다음 행을 순회
					if (database[r][c] != query[c])
						continue outer;
				}
				
				// 해당 질의에 대한 답을 갱신
				answer++;
			}
			
			// write() 메서드를 사용해 해당 질의에 대한 답을 출력
			out.write(answer + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}