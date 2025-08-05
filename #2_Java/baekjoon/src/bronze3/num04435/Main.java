package bronze3.num04435;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Main 클래스 정의
public class Main {
	
	// 간달프와 사우론의 각 종족의 점수를 저장할 각 배열 초기화
	static int[] scoringGandalf = {1, 2, 3, 3, 4, 10};
	static int[] scoringSauron = {1, 2, 2, 2, 3, 5, 10};
	
	// ----------------------------------------------------------------------------------------------------
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {

		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 전투의 개수를 변수 battleNum에 할당
		int battleNum = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 전투를 순회
		for (int order = 1; order <= battleNum; order++) {
			
			// 해당 전투에서 간달프와 사우론의 각 군대의 점수의 합을 저장할 각 변수 초기화
			int scoreGandalf = 0;
			int scoreSauron = 0;
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 간달프 군대의 점수의 합을 갱신
			for (int idx = 0; idx < scoringGandalf.length; idx++)
				scoreGandalf += Integer.parseInt(st.nextToken()) * scoringGandalf[idx];
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// for 반복문을 사용해 사우론 군대의 점수의 합을 갱신
			for (int idx = 0; idx < scoringSauron.length; idx++)
				scoreSauron += Integer.parseInt(st.nextToken()) * scoringSauron[idx];
			
			// write() 메서드를 사용해 전투 번호를 출력
			out.write("Battle " + order + ": ");
			
			// 간달프의 군대가 이긴 경우 'Good triumphs over Evil'을 출력
			if (scoreGandalf > scoreSauron) {
				out.write("Good triumphs over Evil");
				
			// 사우론의 군대가 이긴 경우 'Evil eradicates all trace of Good'을 출력
			} else if (scoreGandalf < scoreSauron) {
				out.write("Evil eradicates all trace of Good");
				
			// 두 군대의 점수의 합이 같아 이기는 쪽이 없는 경우 'No victor on this battle field'를 출력
			} else {
				out.write("No victor on this battle field");
			}
			
			// newLine() 메서드를 사용해 줄바꿈을 출력
			out.newLine();
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}