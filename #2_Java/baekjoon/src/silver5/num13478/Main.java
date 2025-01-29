package silver5.num13478;

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
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 원래 직사각형의 크기를 각 변수에 할당
		int originWidth = Integer.parseInt(st.nextToken());
		int originHeight = Integer.parseInt(st.nextToken());
		
		// 세로가 가로에 비해 더 긴 경우 가로와 세로의 길이를 조정
		if (originHeight > originWidth) {
			int temp = originWidth;
			originWidth = originHeight;
			originHeight = temp;
		}
		
		// StringTokenizer 객체를 불러와 변수 st에 재할당
		st = new StringTokenizer(in.readLine());
		
		// nextToken() 및 parseInt() 메서드를 사용해 입력 받은 목표 직사각형의 크기를 각 변수에 할당
		int targetWidth = Integer.parseInt(st.nextToken());
		int targetHeight = Integer.parseInt(st.nextToken());
		
		// 세로가 가로에 비해 더 긴 경우 가로와 세로의 길이를 조정
		if (targetHeight > targetWidth) {
			int temp = targetWidth;
			targetWidth = targetHeight;
			targetHeight = temp;
		}
		
		// 목표 직사각형을 만들기 위해 접어야 하는 최소 횟수를 저장할 변수 minCount 초기화
		int minCount = -1;
		
		// 목표로 하는 직사각형을 만들 수 있는 경우
		if (originWidth >= targetWidth && originHeight >= targetHeight) {
			
			// foldCounter() 메서드를 호출해 목표 직사각형을 만들기 위해 접어야 하는 최소 횟수를 갱신
			minCount = foldCounter(originWidth, targetWidth) + foldCounter(originHeight, targetHeight);
			
			// 목표 직사각형의 가로와 세로를 뒤바꿔도 만들 수 있는 경우 목표 직사각형을 만들기 위해 접어야 하는 최소 횟수를 갱신
			if (originWidth >= targetHeight && originHeight >= targetWidth)
				minCount = Math.min(foldCounter(originWidth, targetHeight)
						+ foldCounter(originHeight, targetWidth), minCount);
		}
		
		// valueOf() 및 write() 메서드를 사용해 목표 직사각형을 만들기 위해 접어야 하는 최소 횟수룰 출력
		out.write(String.valueOf(minCount));
		
		// close() 메서드를 사용해 각 객체 종료
		in.close();
		out.close();
	}
	
	// ----------------------------------------------------------------------------------------------------

	// foldCounter() 메서드 정의
	public static int foldCounter(int originLength, int targetLength) {
		
		// 직사각형을 접은 횟수를 저장할 변수 count 초기화
		int count = 0;
		
		// while 반복문을 사용해 직사각형을 접은 횟수를 갱신
		while (originLength > targetLength) {
			targetLength *= 2;
			count++;
		}
		
		// 직사각형을 접은 횟수를 반환
		return count;
	}
}