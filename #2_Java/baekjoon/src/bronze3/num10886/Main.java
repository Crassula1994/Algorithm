package bronze3.num10886;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Main 클래스 정의
public class Main {
	
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 설문 조사를 한 사람의 수를 변수 surveyeeNum에 할당
		int surveyeeNum = Integer.parseInt(in.readLine());
		
		// 귀엽지 않다는 의견과 귀엽다는 의견의 수를 저장할 각 변수 초기화
		int noCnt = 0;
		int yesCnt = 0;
		
		// for 반복문을 사용해 각 설문 조사를 순회
		for (int s = 0; s < surveyeeNum; s++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 설문 조사의 결과를 변수 result에 할당
			int result = Integer.parseInt(in.readLine());
			
			// 귀엽지 않다는 의견인 경우 귀엽지 않다는 의견의 수를 갱신
			if (result == 0) {
				noCnt++;
				
			// 귀엽다는 의견인 경우 귀엽다는 의견의 수를 갱신
			} else {
				yesCnt++;
			}
		}
		
		// 귀엽지 않다는 의견이 더 많은 경우 'Junhee is not cute!'를 출력
		if (noCnt > yesCnt) {
			out.write("Junhee is not cute!");
			
		// 귀엽다는 의견이 더 많은 경우 'Junhee is cute!'를 출력
		} else {
			out.write("Junhee is cute!");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}