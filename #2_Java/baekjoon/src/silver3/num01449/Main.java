package silver3.num01449;

// 필요한 패키지 불러오기
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
	    	
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 물이 새는 곳의 개수와 테이프의 개수를 각 변수에 할당
		int leakNum = Integer.parseInt(st.nextToken());
		int tapeLen = Integer.parseInt(st.nextToken());
		
		// 물이 새는 곳의 위치를 저장할 배열 location 초기화
		int[] location = new int[leakNum];
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// for 반복문을 사용해 입력 받은 물이 새는 곳의 위치를 배열 location에 저장
		for (int idx = 0; idx < location.length; idx++)
			location[idx] = Integer.parseInt(st.nextToken());
	    
		// sort() 메서드를 사용해 물이 새는 곳의 위치를 오름차순으로 정렬
		Arrays.sort(location);
	    
		// 항승이가 필요한 테이프의 개수 및 마지막으로 붙인 테이프의 끝 위치를 저장할 각 변수 초기화
		int tapeNum = 0;
		int tapeEnd = 0;

		// for 반복문을 사용해 각 물이 새는 곳의 위치를 순회
		for (int idx = 0; idx < location.length; idx++) {
      
			// 해당 위치가 마지막으로 붙인 테이프의 끝 위치보다 오른쪽에 위치한 경우
			if (location[idx] > tapeEnd) {

				// 필요한 테이프의 개수 및 마지막으로 붙인 테이프의 끝 위치를 갱신
				tapeNum++;
				tapeEnd = location[idx] + tapeLen - 1;
			}
		}

		// valueOf() 및 write() 메서드를 사용해 항승이가 필요한 테이프의 개수를 출력
		out.write(String.valueOf(tapeNum));

		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
}