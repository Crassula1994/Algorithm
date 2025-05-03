package bronze5.num31429;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// 각 등수의 팀이 푼 문제 수와 푼 문제들의 패널티의 합을 저장할 2차원 배열 ranks 초기화
	static int[][] ranks = {
			{12, 1600}, {11, 894}, {11, 1327}, {10, 1311}, {9, 1004}, {9, 1178}, {9, 1357}, {8, 837},
			{7, 1055}, {6, 556}, {6, 773}
	};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 팀의 등수를 변수 rank에 할당
		int rank = Integer.parseInt(in.readLine()) - 1;
		
		// write() 메서드를 사용해 해당 팀이 푼 문제 수와 푼 문제들의 페널티의 합을 출력
		out.write(ranks[rank][0] + " " + ranks[rank][1]);

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}