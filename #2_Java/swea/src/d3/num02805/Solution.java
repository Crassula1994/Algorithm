package d3.num02805;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// Solution 클래스 정의
public class Solution {
    
	// main() 메서드 정의
	public static void main(String[] args) throws IOException {
		
		// BufferedReader 및 BufferedWriter 객체를 불러와 각 변수에 할당
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// readLine() 및 parseInt() 메서드를 사용해 입력 받은 테스트 케이스의 수를 변수 testCase에 할당
		int testCase = Integer.parseInt(in.readLine());
		
		// for 반복문을 사용해 각 테스트 케이스를 순회
		for (int tc = 1; tc <= testCase; tc++) {
			
			// readLine() 및 parseInt() 메서드를 사용해 입력 받은 농장의 크기를 변수 size에 할당
			int size = Integer.parseInt(in.readLine());
			
			// 농작물의 가치를 저장할 2차원 배열 farmMap 초기화
			int[][] farmMap = new int[size][size];
			
			// for 반복문을 사용해 농장의 각 행을 순회
			for (int r = 0; r < size; r++) {
				
				// 농장의 각 행별 농작물의 가치를 변수 line에 할당
				String line = in.readLine();
				
				// for 반복문을 사용해 농장의 각 열을 순회하며 농작물의 가치를 배열 farmMap에 저장
				for (int c = 0; c < size; c++)
					farmMap[r][c] = line.charAt(c) - '0';
			}
			
			// 농작물 수확의 시작 및 끝 인덱스를 나타낼 각 변수 초기화
			int start = size / 2;
			int end = size / 2;
			
			// 농작물 가치의 합을 저장할 변수 sum 초기화
			int sum = 0;
			
			// for 반복문을 사용해 각 행을 차례로 순회
			for (int r = 0; r < size; r++) {
				
				// for 반복문을 사용해 각 열을 차례로 순회
				for (int c = start; c <= end; c++)
					sum += farmMap[r][c];
				
				// 전반부 행인 경우 시작 인덱스 및 끝 인덱스 조정
				if (r < size / 2) {
					start--;
					end++;
				
				// 후반부 행인 경우 시작 인덱스 및 끝 인덱스 조정
				} else {
					start++;
					end--;
				}
			}
			
			// write() 메서드를 사용해 얻을 수 있는 수익을 출력
        	out.write("#" + tc + " " + sum + "\n");
		}

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}