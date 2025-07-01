package bronze4.num30999;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 문제 후보의 수와 출제위원의 수를 각 변수에 할당
		int questionNum = Integer.parseInt(st.nextToken());
		int examinerNum = Integer.parseInt(st.nextToken());
		
		// 문제가 출제되기 위해 필요한 과반수, 출제될 문제의 수를 저장할 각 변수 초기화
		int majorityCount = examinerNum / 2 + 1;
		int totalCount = 0;
		
		// while 반복문을 사용해 각 문제 후보를 순회
		while (questionNum-- > 0) {
			
			// readLine() 메서드를 사용해 입력 받은 문제 후보에 대한 찬반 의견를 변수 opinions에 할당
			String opinions = in.readLine();
			
			// for 반복문을 사용해 각 출제위원의 의견을 순회
			for (int idx = 0, count = 0; idx < examinerNum; idx++) {
				
				// 해당 출제위원이 문제 후보 출제에 찬성한 경우 찬성한 출제위원의 수를 갱신
				if (opinions.charAt(idx) == 'O')
					count++;
				
				// 해당 문제 후보가 과반수의 찬성을 얻은 경우 출제될 문제의 수를 갱신 후 반복문 탈출
				if (count == majorityCount) {
					totalCount++;
					break;
				}
			}
		}
		
		// valueOf() 및 write() 메서드를 사용해 출제될 문제의 수를 출력
		out.write(String.valueOf(totalCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}