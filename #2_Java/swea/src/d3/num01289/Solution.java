package d3.num01289;

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
		for (int i = 0; i < testCase; i++) {
			
			// readLine() 및 toCharArray() 메서드를 사용해 입력 받은 메모리 비트를 배열 bits에 저장
			char[] bits = in.readLine().toCharArray();
			
			// 수정 횟수를 저장할 변수 count 초기화
			int count = 0;
			
			// 1이 나타났는지 확인할 변수 isOneAppear 초기화
			boolean isOneAppear = false;
			
			// for 반복문을 사용해 각 메모리 비트의 자릿수를 순회
			for (int j = 0; j < bits.length;  j++) {
				
				// 처음으로 1이 나온 경우 isOneAppear 및 수정 횟수 갱신
				if (bits[j] == '1' && isOneAppear == false) {
					isOneAppear = true;
					count++;
				
				// 1이 나온 이후 값이 바뀐 경우 수정 횟수 갱신
				} else if (j > 0 && isOneAppear == true && bits[j - 1] != bits[j]) {
					count++;
				}
			}
			
			// write() 메서드를 사용해 최소 수정 횟수를 출력
			out.write("#" + (i + 1) + " " + count + "\n");
		}
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}