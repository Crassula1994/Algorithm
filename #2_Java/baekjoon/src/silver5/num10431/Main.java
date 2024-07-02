package silver5.num10431;

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
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 0; tc < testCase; tc++) {
			
			// 학생들이 뒤로 물러난 걸음 수의 총합을 저장할 각 변수 초기화
			int totalCount = 0;
			
			// 각 학생들의 줄서기 후 학생들의 키를 저장할 배열 line 초기화
			int[] line = new int[20];
			
			// StringTokenizer 객체를 불러와 변수 st에 할당
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 변호를 변수 testCaseNum에 할당
			int testCaseNum = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 입력 받은 학생들의 키를 순회
			for (int idx = 0; idx < line.length; idx++) {
				
				// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 학생의 키를 변수 height에 할당
				int height = Integer.parseInt(st.nextToken());
				
				// 현재 학생이 설 위치를 나타낼 변수 location 초기화
				int location = idx;
				
				// while 반복문을 사용해 앞선 모든 사람들이 자신보다 키가 작을 때까지 순회
                while (location > 0 && line[location - 1] > height) {
                	
                	// 현재 위치에 더 키가 큰 앞 사람을 배치
                    line[location] = line[location - 1];
                    
                    // 현재 학생이 설 위치 및 학생들이 뒤로 물러난 걸음 수를 갱신
                    location--;
                    totalCount++;
                }
                
                // 해당 학생의 키를 배열 line에 저장
                line[location] = height;
			}
			
			// write() 메서드를 사용해 테스트 케이스의 번호와 학생들이 뒤로 물러난 걸음 수의 총합을 출력
			out.write(testCaseNum + " " + totalCount + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}