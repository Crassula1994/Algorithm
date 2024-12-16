package gold3.num09567;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 외양간의 수와 입력 데이터의 수를 각 변수에 할당
		int stallNum = Integer.parseInt(st.nextToken());
		int lineCnt = Integer.parseInt(st.nextToken());
		
		// 외양간에 들어가지 못한 소의 수를 저장할 변수 remains 초기화
		int remains = 0;
		
		// 각 외양간에 존재하는 소의 수를 저장할 배열 stalls 초기화
		int[] stalls = new int[stallNum];
		
		// while 반복문을 사용해 각 입력 데이터를 순회
		while (lineCnt-- > 0) {
			
			// StringTokenizer 객체를 불러와 변수 st에 재할당
			st = new StringTokenizer(in.readLine());
			
			// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 각 데이터를 각 변수에 할당
			long cowNum = Integer.parseInt(st.nextToken());
			long upperLimit = Integer.parseInt(st.nextToken());
			long multiplier = Integer.parseInt(st.nextToken());
			long increment = Integer.parseInt(st.nextToken());
			
			// for 반복문을 사용해 각 외양간에 소를 추가
			for (int idx = 1; idx <= upperLimit; idx++)
				stalls[(int) ((idx * multiplier + increment) % stallNum)] += cowNum;
		}
		
		// for 반복문을 사용해 각 외양간을 두 번 순회
		for (int idx = 0; idx < stalls.length * 2; idx++) {
			
			// 현재 외양간 번호를 변수 curStall에 할당
			int curStall = idx % stallNum;
			
			// 해당 외양간에 한 마리 이상의 소가 있는 경우 들어가지 못한 소의 수를 갱신
			if (stalls[curStall] > 0) {
				remains += stalls[curStall] - 1;
				stalls[curStall] = 1;
				
			// 해당 외양간이 비어 있고 들어가지 못한 소가 있는 경우 들어가지 못한 소의 수를 갱신
			} else if (remains > 0) {
				remains--;
				stalls[curStall] = 1;
			}
		}
		
		// for 반복문을 사용해 각 외양간을 순회
		for (int idx = 0; idx < stalls.length; idx++) {
			
			// 해당 외양간이 비어 있는 경우 해당 외양간 번호를 출력 후 반복문 탈출
			if (stalls[idx] == 0) {
				out.write(String.valueOf(idx));
				break;
			}
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}